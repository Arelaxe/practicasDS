#ifndef TARJETA
#define TARJETA

#include "ComponenteEquipo.hpp"

class Tarjeta : ComponenteEquipo{
    public:
    Tarjeta();
    void aceptarVisitante (VisitanteEquipo v);
};

#endif