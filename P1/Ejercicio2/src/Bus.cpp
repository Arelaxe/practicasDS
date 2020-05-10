#include "Bus.hpp"

Bus::Bus(string n){
    setNombre(n);
}

void Bus::aceptarVisitante (VisitanteEquipo * v){
    v->visitarBus(*this);
}
