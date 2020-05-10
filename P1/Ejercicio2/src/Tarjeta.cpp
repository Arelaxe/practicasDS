#include "Tarjeta.hpp"

Tarjeta::Tarjeta(string n){
    setNombre(n);
}

void Tarjeta::aceptarVisitante(VisitanteEquipo * v) {
    v->visitarTarjeta(*this);
}
