var http = require("http");
var express = require('express');
var path = require("path");
var socketio = require("socket.io");
var hash = require('pbkdf2-password')()
var session = require('express-session');
var app = module.exports = express();


// Declaramos variables adicionales
var MongoClient = require('mongodb').MongoClient;
var httpServer = http.createServer(app);
var plantillas = [];
var salas = [];
var msgUserDesc =  "Para realizar esta acción debe estar previamente identificado.";

// ***********************************************************************
// Configuración de express

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

// ***********************************************************************
// Configuración del middleware

app.use(express.urlencoded({ extended: false }))
app.use(session({
  resave: false,
  saveUninitialized: false,
  secret: 'secret'
}));

// Establecimiento de mensajes asociados a la persistencia de la sesión

app.use(function(req, res, next){
	var err = req.session.error;
	var msg = req.session.success;
	delete req.session.error;
	delete req.session.success;
	res.locals.message = '';
	if (err) res.locals.message = '<p class="msg error">' + err + '</p>';
	if (msg) res.locals.message = '<p class="msg success">' + msg + '</p>';
	next();
});

// ***********************************************************************
// Métodos de actuación ante peticiones GET

// Por defecto, redireccionamos a la página de log-in
app.get('/', function(req, res){
	if (req.session.user != undefined)
		res.redirect('/index');
	else
		res.redirect('/login');
});

// Petición de logout
app.get('/logout', function(req, res){
	req.session.destroy(function(){
	  res.redirect('/');
	});
});
  
// Petición de login
app.get('/login', function(req, res){
	res.render('login');
});

// Petición de registro
app.get('/register', function(req, res){
	res.render('register');
});

// Petición de acceso a página principal
app.get('/index', function(req, res){
	if (req.session.user != undefined)
		res.render('index');
	else{
		req.session.error = msgUserDesc;
		res.redirect('/login');
	}
});

// Petición de acceso a la sala de votación
app.get('/sala', function(req, res){
	if (req.session.user != undefined){
		var info_sala = salas[req.query.id_sala];

		if (info_sala != undefined){
			var plantilla = getPlantilla (info_sala.plantilla);
			res.render('sala', {sala: info_sala, plantilla: plantilla});
		}
		else{
			req.session.error = "La sala a la que intenta acceder está vacía.";
			res.redirect('/index');
		}
	}	
	else{
		req.session.error = msgUserDesc;
		res.redirect('/login');
	}
});

// Petición de votación
app.get('/votacion', function(req, res){
	if (req.session.user != undefined){
		var info_sala = salas[req.query.id_sala];

		if (info_sala == undefined){
			req.session.error = "La sala a la que intenta acceder está vacía.";
			res.redirect('/index');
		}
		/*
		else if (new Date(salas[req.query.id_sala].hora_ini) > Date.now()){
			req.session.error = "La votación comienza el " + salas[req.query.id_sala].hora_ini;
			res.redirect('/index');
		}
		else if (new Date(salas[req.query.id_sala].hora_fin) < Date.now()){
			req.session.error = "La votación ya ha finalizado";
			res.redirect('/index');
		*/
		else{
			var listaUsers = salas[req.query.id_sala].users['nombre'];
			var ind = -1;
			for (var i=0; i<listaUsers.length; i++){
				if (listaUsers[i] == req.session.user){
					ind = i;
				}
			}
			// Determinamos si el usuario cumple los requisitos para votar
			if (ind == -1){
				req.session.error = "El usuario no puede votar en esta votación.";
				res.redirect('/index');
			}
			else if (salas[req.query.id_sala].users['votado'][ind] == 1){
				req.session.error = "El usuario ya ha votado en esta votación.";
				res.redirect('/index');
			}
			else{
				salas[req.query.id_sala].users['votado'][ind] = 1;

				var plantilla = getPlantilla (info_sala.plantilla);
				res.render('votacion', {sala: info_sala, plantilla: plantilla});
			}
		}
			
	}	
	else{
		req.session.error = msgUserDesc;
		res.redirect('/login');
	}
});

// Petición de creación de una nueva plantilla
app.get('/nueva-plantilla', function(req, res){
	if (req.session.user != undefined){
		res.locals.title = "Nueva plantilla";
		res.render('nueva-plantilla');
	}
	else{
		req.session.error = msgUserDesc;
		res.redirect('/login');
	}
});

// Petición de creación de una nueva votación
app.get('/nueva-votacion', function(req, res){
	if (req.session.user != undefined)
		res.render('nueva-votacion');
	else{
		req.session.error = msgUserDesc;
		res.redirect('/login');
	}
});



// ***********************************************************************
// Control de peticiones que involucran comunicación con la BASE DE DATOS




MongoClient.connect("mongodb://localhost:27017/", function(err, db) {
	httpServer.listen(3000);
	var io = socketio.listen(httpServer);

	var dbo = db.db("dbvotingsys");

	// Operaciones asociadas a la base de datos de usuario
	dbo.createCollection("user", function(err, collection){

		// Registro de usuario
		app.post('/register', function(req, res){
			var user = req.body.username;
			collection.find({usuario:user}).toArray(function(err, results){
				if (results.length > 0){
					req.session.error = 'Este usuario ya existe';
					res.redirect('/register');
				}
				else{
					var pass = req.body.password;
					hash({ password:pass }, function (err, pass, salt, hash) {
						var user_salt = salt;
						var user_hash = hash;
	
						collection.insert({usuario:user, pass:user_hash, sal:user_salt}, {safe:true}, function(err, result){});
					});
					req.session.regenerate(function(){
						req.session.user = user;
						req.session.success = 'Registrado correctamente';
						res.redirect('/index');
					});
				}
			});
		});

		// Comprobación de datos correctos en log-in
		app.post('/login', function(req, res){
			var user = req.body.username;
			collection.find({usuario:user}).toArray(function(err, results){
				if (results.length > 0){
					var passwd = results[0].pass;
					var salty = results[0].sal;
					var pass_usu = req.body.password;
					hash({ password:pass_usu, salt:salty }, function (err, pass, salt, hash) {
						if (hash === passwd){
							req.session.regenerate(function(){
								req.session.user = user;
								req.session.success = 'Sesión iniciada correctamente';
								res.redirect('/index');
							});
						}
						else{
							req.session.error = 'Credenciales incorrectos';
							res.redirect('/login');
						}
					});
				}
				else{
					req.session.error = 'Credenciales incorrectos';
					res.redirect('/login');
				}
			});
		});
	});

	// Operaciones asociadas a la base de datos de las plantillas
	dbo.createCollection("plantillas", function(err, collection){

		// Obtenemos inicialmente las plantillas
		collection.find().forEach(function(c){
			plantillas.push(c);
		});

		io.sockets.on('connection', function(client){

			// Cargamos las plantillas (necesario para crear una nueva votación)
			client.emit('cargar-plantillas', {data:plantillas});

			// Añadimos una plantilla
			client.on('add-plantilla', function(data){
				plantillas.push(data);
				collection.insert(data, {safe:true}, function(err, result){
					io.sockets.emit('cargar-plantillas', {data:plantillas});
				});
			});
		});
	});

	// Operaciones asociadas a la base de datos de las salas
	dbo.createCollection("salas", function(err, collection){
		collection.find().forEach(function(c){
			salas[c.codigo] = c.informacion;
		});

		// Creación de una nueva votación
		app.post('/nueva-votacion', function(req, res){

			// Comprobación inicial para asignar el código; se asocia a la sala
			// con el menor código y que tuviese una votación expirada
			var codigo = -1;
			for (var i=0; i<salas.length; i++){
				if (salas[i] == undefined /*|| new Date(salas[i].hora_fin) < Date.now()*/)
					codigo = i;
			}
			if (codigo == -1)
				codigo = salas.length;

			// Inicializamos valores a almacenar en la base de datos
			var data = {};
			data['nombre'] = req.body.nombre;
			data['plantilla'] = req.body.plantilla;
			data['hora_ini'] = req.body.hora_ini;
			data['hora_fin'] = req.body.hora_fin;
			data['users'] = {};
			data['users']['nombre'] = [req.session.user];
			data['users']['votado'] = [0];
			data['resultados'] = [];

			var plantilla = getPlantilla(data['plantilla']);
			
			for (var i=0; i<plantilla.preguntas.length; i++){
				data['resultados'][i] = [];

				for (var j=0; j<plantilla.preguntas[i].alternativas.length; j++){
					data['resultados'][i].push(0);
				}
			}

			// Actualizamos la información en la MP y almacenamos en la BD
			salas[codigo] = data;
			collection.insert({codigo: codigo, informacion: data});

			req.session.success = "El codigo de la sala es " + codigo;
			res.redirect('/index');
		});

		
		// Consulta de las votaciones personales
		app.get('/consultar-votaciones', function(req, res){
			if (req.session.user != undefined){
				collection.find().toArray(function(err, results){
					var votaciones = [];

					for (var i=0; i<results.length; i++){
						
						if (results[i].informacion.users['nombre'][0] == req.session.user/* &&
							new Date(results[i].informacion.hora_fin) > Date.now()*/)
							votaciones.push({cod: results[i].codigo, nombre: results[i].informacion.nombre});
					}
					res.render('consultar-votaciones', {votaciones: votaciones});
				});
			}
			else {
				req.session.error = msgUserDesc;
				res.redirect('/login');
			}
		});

		
		// Petición POST con la info del nuevo usuario añadido
		app.post('/consultar-votaciones', function(req, res){
			// Comprobamos si el usuario ya estaba previamente registrado en la votación
			if (salas[req.body.cod] != undefined){

				var encontrado = false;
				for (var i=0; i<salas[req.body.cod].users['nombre'].length && !encontrado; i++){
					if (salas[req.body.cod].users['nombre'][i] == req.body.user)
						encontrado = true;
				}
				if (encontrado){
					req.session.error = "El usuario ya estaba registrado en la votación";
					res.redirect('/index');
				}
				else{
					salas[req.body.cod].users['nombre'].push(req.body.user);
					salas[req.body.cod].users['votado'].push(0);

					// Modificamos la información correspondiente en la base de datos
					var cod = parseInt(req.body.cod, 10);

					collection.find({codigo:cod}).toArray(function(err, results){
						var id = results[results.length-1]._id;
						collection.update({_id: id}, { $set: {informacion: salas[req.body.cod]} });
					});

					req.session.success = "El usuario se ha registrado en la votación correctamente";
					res.redirect('/index');
				}
			}
			else{
				req.session.error = msgUserDesc;
				res.redirect('/login');
			}
		});

		io.sockets.on('connection', function(client){

			// Añadimos un usuario a una votación; esta acción solamente puede ser realizada por el 
			// creador de la votación.
			client.on('add-user-votacion', function(data){
				if (!salas[data.codigo].users['nombre'].includes(data.nombre_user)){
					salas[data.codigo].users['nombre'].push(data.nombre_user);
					salas[data.codigo].users['votado'].push(0);

					// Accedemos a la última referencia de sala en la colección, que es la
					// activa, y actualizamos el valor
					// Modificamos la información correspondiente en la base de datos
					var cod = parseInt(data.codigo, 10);

					collection.find({codigo: cod}).toArray(function(err, results){
						var id = results[results.length-1]._id;
						collection.update({_id: id}, { $set: {informacion: salas[data.codigo]} });
					});
				}
			});

			// Cada vez que se añada un voto, se notifica a los usuarios
			// que estén en la sala
								
			client.on('add-vote', function(data){

				salas[data.cod].resultados[data.preg][data.alt]++;

				// Modificamos la información en la base de datos.
				var cod = parseInt(data.cod, 10);

				collection.find({codigo: cod}).toArray(function(err, results){
					var id = results[results.length-1]._id;
					collection.update({_id: id}, { $set: {informacion: salas[data.cod]} });
				});

				io.sockets.emit('update-values', data);
			});
		});
	});
});


// ***********************************************************************
// Funciones asociadas a OPERACIONES AUXILIARES


// Permite obtener la información asociada a una plantilla a partir de su nombre

function getPlantilla(nombre){
	var plantilla;

	for (var i=0; i<plantillas.length; i++){
		if (plantillas[i].nombre == nombre){
			plantilla = plantillas[i];
		}
	}
	return plantilla;
}
