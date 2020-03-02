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

enum TipoVisitante {TNormal, TEstudiante, TMayorista};

class VisitanteEquipo{
    private:
    unordered_map<string,double> catalogo;
    protected:
    double descuento;
    double precioComponente(string n);
    public:
    VisitanteEquipo(TipoVisitante t);
    virtual void visitarDisco(Disco & d);
    virtual void visitarTarjeta(Tarjeta & t);
    virtual void visitarBus(Bus & b);
};

#endif