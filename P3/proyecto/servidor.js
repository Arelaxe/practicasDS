var http = require("http");
var url = require("url");
var fs = require("fs");
var path = require("path");
var socketio = require("socket.io");

var MongoClient = require('mongodb').MongoClient;
var MongoServer = require('mongodb').Server;
var mimeTypes = { "html": "text/html", "jpeg": "image/jpeg", "jpg": "image/jpeg", "png": "image/png", "js": "text/javascript", "css": "text/css", "swf": "application/x-shockwave-flash"};

var httpServer = http.createServer(
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
}

MongoClient.connect("mongodb://localhost:27017/", function(err, db) {
	httpServer.listen(8081);
	var io = socketio.listen(httpServer);

	var dbo = db.db("dbvotingsys");
	dbo.createCollection("test", function(err, collection){
		io.sockets.on('connection', function(client){

			var info_sala = salas[cod_sala];
			client.emit('initialize-values', {data: info_sala});

			client.on('add-vote', function(data){
				io.sockets.emit('update-values', data);

				datos[data.ind]++;
				collection.insert(data, {safe:true}, function(err, result){});
			});
		});
	});

	dbo.createCollection("plantillas", function(err, collection){
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
	});
});

