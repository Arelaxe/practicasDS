#include "Disco.hpp"

Disco::Disco(){
}

void Disco::aceptarVisitante(VisitanteEquipo v) {
    v.visitarDisco(this);
}