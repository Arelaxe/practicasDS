/*var http = require("http");
var url = require("url");
var fs = require("fs");*/
var express = require('express');
var path = require("path");
var socketio = require("socket.io");
var hash = require('pbkdf2-password')()
var session = require('express-session');

var app = module.exports = express();

// config

app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));

// middleware

app.use(express.urlencoded({ extended: false }))
app.use(session({
  resave: false, // don't save session if unmodified
  saveUninitialized: false, // don't create session until something stored
  secret: 'shhhh, very secret'
}));


// Session-persisted message middleware

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


// dummy database

var users = {
	tj: { name: 'tj' }
};

// when you create a user, generate a salt
// and hash the password ('foobar' is the pass here)

hash({ password: 'foobar' }, function (err, pass, salt, hash) {
	if (err) throw err;
	// store the salt & hash in the "db"
	users.tj.salt = salt;
	users.tj.hash = hash;
});

// Authenticate using our plain-object database of doom!

function authenticate(name, pass, fn) {
	if (!module.parent) console.log('authenticating %s:%s', name, pass);
	var user = users[name];
	// query the db for the given username
	if (!user) return fn(new Error('cannot find user'));
	// apply the same algorithm to the POSTed password, applying
	// the hash against the pass / salt, if there is a match we
	// found the user
	hash({ password: pass, salt: user.salt }, function (err, pass, salt, hash) {
	  if (err) return fn(err);
	  if (hash === user.hash) return fn(null, user)
	  fn(new Error('invalid password'));
	});
}


function restrict(req, res, next) {
	if (req.session.user) {
	  next();
	} else {
	  req.session.error = 'Access denied!';
	  res.redirect('/login');
	}
}

app.get('/', function(req, res){
	res.redirect('/register');
});

app.get('/restricted', restrict, function(req, res){
	res.send('Wahoo! restricted area, click to <a href="/logout">logout</a>');
});


app.get('/logout', function(req, res){
	// destroy the user's session to log them out
	// will be re-created next request
	req.session.destroy(function(){
	  res.redirect('/');
	});
  });
  
  app.get('/login', function(req, res){
	res.render('login');
  });

  app.get('/register', function(req, res){
	res.render('register');
  });

  



/* istanbul ignore next */
if (!module.parent) {
	app.listen(3000);
	console.log('Express started on port 3000');
  }


var MongoClient = require('mongodb').MongoClient;
var MongoServer = require('mongodb').Server;
var mimeTypes = { "html": "text/html", "jpeg": "image/jpeg", "jpg": "image/jpeg", "png": "image/png", "js": "text/javascript", "css": "text/css", "swf": "application/x-shockwave-flash"};

/*var httpServer = http.createServer(
	function(request, response) {
		var uri = url.parse(request.url).pathname;

		if (uri=="/") uri = "/index.html";

		else if (uri.includes('sala')){
			cod_sala = uri.split('=')[1];
			if (salas[cod_sala] !== undefined)
				uri = "/sala.html";
		}
		else if (uri.includes('new-template'))
			uri = "/crear_plantilla.html";
		else if (uri.includes('new-voting'))
			uri = "/crear_votacion.html";
		else if (uri.includes('voting')){
			cod_sala = uri.split('=')[1];
			if (salas[cod_sala] !== undefined)
				uri = "/voting.html";
		}

		console.log(uri);

		var fname = path.join(process.cwd(), uri);

		fs.exists(fname, function(exists) {
			if (exists) {
				fs.readFile(fname, function(err, data){
					if (!err) {
						var extension = path.extname(fname).split(".")[1];
						var mimeType = mimeTypes[extension];
						response.writeHead(200, mimeType);
						response.write(data);
						response.end();
					}
					else {
						response.writeHead(200, {"Content-Type": "text/plain"});
						response.write('Error de lectura en el fichero: '+uri);
						response.end();
					}
				});
			}
			else{
				console.log("Peticion invalida: "+uri);
				response.writeHead(200, {"Content-Type": "text/plain"});
				response.write('404 Not Found\n');
				response.end();
			}
		});
	}
);
var salas = {};
var datos = new Array(100).fill(0);
var plantillas = [];
var cod_sala;

function getRandomCode(length){
	var result           = '';
	var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	var charactersLength = characters.length;
	for ( var i = 0; i < length; i++ ) {
    	result += characters.charAt(Math.floor(Math.random() * charactersLength));
   	}
   	return result;
}*/


MongoClient.connect("mongodb://localhost:27017/", function(err, db) {
	if (err) {
		throw err;
	}

	var dbo = db.db("dbvotingsys");
	dbo.createCollection("user", function(err, collection){
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
						res.redirect('back');
					});
				}
			});
		});
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
								res.redirect('back');
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
	/*dbo.createCollection("test", function(err, collection){
		io.sockets.on('connection', function(client){

			var info_sala = salas[cod_sala];
			client.emit('initialize-values', {data: info_sala});

			client.on('add-vote', function(data){
				io.sockets.emit('update-values', data);

				datos[data.ind]++;
				collection.insert(data, {safe:true}, function(err, result){});
			});
		});
	});*/

	/*dbo.createCollection("plantillas", function(err, collection){
		collection.find().forEach(function(c){
			plantillas.push(c);
		});

		io.sockets.on('connection', function(client){
			
			client.emit('cargar-plantillas', {data:plantillas});

			client.on('add-plantilla', function(data){
				plantillas.push(data);

				collection.insert(data, {safe:true}, function(err, result){
					io.sockets.emit('cargar-plantillas', {data:plantillas});
				});
			});

			client.on('nueva-votacion', function(data){
				var codigo;
				do{
					codigo = getRandomCode(6);
					console.log(codigo + " - " + salas[codigo]);
				}while(salas[codigo] !== undefined);
				

				collection.find({nombre:data.plantilla}).toArray(function(err, results){
					salas[codigo] = results[0];
					console.log(results);
					client.emit('establecer-sala', {codigo: codigo});
				});
			});
		});
	});*/
});

