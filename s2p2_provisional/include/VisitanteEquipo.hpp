#ifndef VISITANTEEQUIPO
#define VISITANTEEQUIPO

#include "Disco.hpp"
#include "Tarjeta.hpp"
#include "Bus.hpp"

using namespace std;

class VisitanteEquipo{
    public:
    virtual void visitarDisco(Disco & d);
    virtual void visitarTarjeta(Tarjeta & t);
    virtual void visitarBus(Bus & b);
};

#endif