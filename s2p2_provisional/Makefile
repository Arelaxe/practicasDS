SRC = src
OBJ = obj
BIN = bin
INC = include

all: $(BIN)/ejecutable

$(BIN)/ejecutable: $(OBJ)/main.o $(OBJ)/Equipo.o $(OBJ)/ComponenteEquipo.o $(OBJ)/VisitanteEquipo.o $(OBJ)/VisitantePrecio.o $(OBJ)/VisitantePrecioDetalle.o $(OBJ)/Disco.o $(OBJ)/Tarjeta.o $(OBJ)/Bus.o
	g++ -o $(BIN)/ejecutable $(OBJ)/main.o $(OBJ)/Equipo.o $(OBJ)/ComponenteEquipo.o $(OBJ)/VisitanteEquipo.o $(OBJ)/VisitantePrecio.o $(OBJ)/VisitantePrecioDetalle.o $(OBJ)/Disco.o $(OBJ)/Tarjeta.o $(OBJ)/Bus.o -std=c++11

$(OBJ)/main.o: $(SRC)/main.cpp $(INC)/Equipo.hpp $(INC)/ComponenteEquipo.hpp $(INC)/VisitanteEquipo.hpp $(INC)/VisitantePrecio.hpp $(INC)/VisitantePrecioDetalle.hpp $(INC)/Disco.hpp
	g++ -c -o $(OBJ)/main.o $(SRC)/main.cpp -I$(INC) -std=c++11

$(OBJ)/Equipo.o: $(SRC)/Equipo.cpp $(INC)/Equipo.hpp $(INC)/ComponenteEquipo.hpp
	g++ -c -o $(OBJ)/Equipo.o $(SRC)/Equipo.cpp -I$(INC) -std=c++11

$(OBJ)/ComponenteEquipo.o: $(SRC)/ComponenteEquipo.cpp $(INC)/VisitanteEquipo.hpp $(INC)/ComponenteEquipo.hpp
	g++ -c -o $(OBJ)/ComponenteEquipo.o $(SRC)/ComponenteEquipo.cpp -I$(INC) -std=c++11

$(OBJ)/VisitanteEquipo.o: $(SRC)/VisitanteEquipo.cpp $(INC)/VisitanteEquipo.hpp $(INC)/Disco.hpp $(INC)/Tarjeta.hpp $(INC)/Bus.hpp
	g++ -c -o $(OBJ)/VisitanteEquipo.o $(SRC)/VisitanteEquipo.cpp -I$(INC) -std=c++11

$(OBJ)/VisitantePrecio.o: $(SRC)/VisitantePrecio.cpp $(INC)/VisitantePrecio.hpp $(INC)/VisitanteEquipo.hpp
	g++ -c -o $(OBJ)/VisitantePrecio.o $(SRC)/VisitantePrecio.cpp -I$(INC) -std=c++11

$(OBJ)/VisitantePrecioDetalle.o: $(SRC)/VisitantePrecioDetalle.cpp $(INC)/VisitantePrecioDetalle.hpp $(INC)/VisitanteEquipo.hpp
	g++ -c -o $(OBJ)/VisitantePrecioDetalle.o $(SRC)/VisitantePrecioDetalle.cpp -I$(INC) -std=c++11

$(OBJ)/Disco.o: $(SRC)/Disco.cpp $(INC)/Disco.hpp $(INC)/Tarjeta.hpp $(INC)/Bus.hpp $(INC)/ComponenteEquipo.hpp
	g++ -c -o $(OBJ)/Disco.o $(SRC)/Disco.cpp -I$(INC) -std=c++11

$(OBJ)/Tarjeta.o: $(SRC)/Tarjeta.cpp $(INC)/Tarjeta.hpp $(INC)/Disco.hpp $(INC)/Bus.hpp $(INC)/ComponenteEquipo.hpp
	g++ -c -o $(OBJ)/Tarjeta.o $(SRC)/Tarjeta.cpp -I$(INC) -std=c++11

$(OBJ)/Bus.o: $(SRC)/Bus.cpp $(INC)/Tarjeta.hpp $(INC)/Disco.hpp $(INC)/Bus.hpp $(INC)/ComponenteEquipo.hpp
	g++ -c -o $(OBJ)/Bus.o $(SRC)/Bus.cpp -I$(INC) -std=c++11