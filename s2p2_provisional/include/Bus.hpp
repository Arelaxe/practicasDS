#ifndef BUS
#define BUS

#include "ComponenteEquipo.hpp"

class Bus : ComponenteEquipo{
    public:
    Bus();
    void aceptarVisitante (VisitanteEquipo v);
};

#endif