#ifndef TARJETA
#define TARJETA

#include "ComponenteEquipo.hpp"
#include "VisitanteEquipo.hpp"
class VisitanteEquipo;
class ComponenteEquipo;

class Tarjeta : public ComponenteEquipo{
    public:
    Tarjeta(string nombre);
    void aceptarVisitante (VisitanteEquipo * v);
};

#endif