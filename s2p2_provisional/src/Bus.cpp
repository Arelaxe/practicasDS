#include "Bus.hpp"

Bus::Bus(){
}

void Bus::aceptarVisitante (VisitanteEquipo v){
    v.visitarBus(*this);
}
