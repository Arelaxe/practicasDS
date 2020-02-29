#ifndef VISITANTEEQUIPO
#define VISITANTEEQUIPO

using namespace std;

#include "Disco.hpp"
#include "Tarjeta.hpp"
#include "Bus.hpp"
#include <string>
#include <unordered_map>

class Disco;
class Tarjeta;
class Bus;

class VisitanteEquipo{
    private:
    unordered_map<string,double> catalogo;
    protected:
    double precioComponente(string n);
    public:
    VisitanteEquipo();
    virtual void visitarDisco(Disco & d);
    virtual void visitarTarjeta(Tarjeta & t);
    virtual void visitarBus(Bus & b);
};

#endif