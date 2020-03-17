#include "Disco.hpp"
#include "VisitantePrecioDetalle.hpp"

Disco::Disco(string n){
    setNombre(n);
}

void Disco::aceptarVisitante (VisitanteEquipo * v) {
    v->visitarDisco(*this);
}