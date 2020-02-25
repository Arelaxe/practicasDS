#include "Disco.hpp"
#include "Tarjeta.hpp"
#include "Bus.hpp"

class VisitanteEquipo{
    public:
    virtual void visitarDisco(Disco & d);
    virtual void visitarTarjeta(Tarjeta & t);
    virtual void visitarBus(Bus & b);
};