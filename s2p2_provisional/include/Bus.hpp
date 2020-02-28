#ifndef BUS
#define BUS

#include "ComponenteEquipo.hpp"
#include "VisitanteEquipo.hpp"
class VisitanteEquipo;
class ComponenteEquipo;

class Bus : public ComponenteEquipo{
    public:
    Bus();
    void aceptarVisitante (VisitanteEquipo v);
};

#endif