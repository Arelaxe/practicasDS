#include "ComponenteEquipo.hpp"
#include "VisitanteEquipo.hpp"

class VisitantePrecio : public VisitanteEquipo{
    private:
    double coste_total;
    public:
    void visitarDisco(Disco & d);
    void visitarBus(Bus & b);
    void visitarTarjeta(Tarjeta & t);
    double precioTotal() const;
};