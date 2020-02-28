#include "Tarjeta.hpp"

Tarjeta::Tarjeta(){
}

void Tarjeta::aceptarVisitante(VisitanteEquipo v) {
    v.visitarTarjeta(*this);
}
