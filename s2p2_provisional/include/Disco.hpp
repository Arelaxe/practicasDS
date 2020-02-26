#ifndef DISCO
#define DISCO

#include "ComponenteEquipo.hpp"

using namespace std;

class Disco : ComponenteEquipo{
    public:
    Disco();
    void aceptarVisitante (VisitanteEquipo v);
};

#endif