#ifndef VISITANTEEQUIPO
#define VISITANTEEQUIPO

using namespace std;

#include "Disco.hpp"
#include "Tarjeta.hpp"
#include "Bus.hpp"
class Disco;
class Tarjeta;
class Bus;

class VisitanteEquipo{
    public:
    void visitarDisco(Disco & d);
    void visitarTarjeta(Tarjeta & t);
    void visitarBus(Bus & b);
};

#endif