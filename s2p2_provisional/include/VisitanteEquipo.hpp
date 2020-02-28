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
    virtual void visitarDisco(Disco & d);
    virtual void visitarTarjeta(Tarjeta & t);
    virtual void visitarBus(Bus & b);
};

#endif