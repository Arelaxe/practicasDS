#include "ComponenteEquipo.hpp"
#include "VisitanteEquipo.hpp"
#include<vector>

class VisitantePrecioDetalle : public VisitanteEquipo{
    private:
    vector<string> componentes;
    public:
    VisitantePrecioDetalle(TipoVisitante t);
    void visitarDisco(Disco & d);
    void visitarBus(Bus & b);
    void visitarTarjeta(Tarjeta & t);
    void mostrarDetalles();
};