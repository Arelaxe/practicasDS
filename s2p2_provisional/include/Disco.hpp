#ifndef DISCO
#define DISCO

using namespace std;

#include "ComponenteEquipo.hpp"
#include "VisitanteEquipo.hpp"
class VisitanteEquipo;
class ComponenteEquipo;

class Disco : public ComponenteEquipo{
    public:
    Disco();
    void aceptarVisitante (VisitanteEquipo v);
};

#endif