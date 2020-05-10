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

var datos = new Array(100).fill(0);

MongoClient.connect("mongodb://localhost:27017/", function(err, db) {
	httpServer.listen(8081);
	var io = socketio.listen(httpServer);

	var dbo = db.db("dbvotingsys");
	dbo.createCollection("test", function(err, collection){
		io.sockets.on('connection', function(client){
			client.emit('initialize-values', {data: datos});
			client.on('add-vote', function(data){
				io.sockets.emit('update-values', data);

				datos[data.ind]++;
				collection.insert(data, {safe:true}, function(err, result){});
			});
		});
	});
});

