#include "ComponenteEquipo.hpp"
#include "VisitanteEquipo.hpp"

class VisitantePrecioDetalle : public VisitanteEquipo{
    public:
    void visitarDisco(Disco & d);
    void visitarBus(Bus & b);
    void visitarTarjeta(Tarjeta & t);
    void mostrarDetalles();
};