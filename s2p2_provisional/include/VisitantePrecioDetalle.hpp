#include "VisitanteEquipo.hpp"

class VisitantePrecioDetalle : VisitanteEquipo{
    public:
    void visitarDisco(Disco & d);
    void visitarBus(Bus & b);
    void visitarTarjeta(Tarjeta & t);
    void mostrarDetalles();
};