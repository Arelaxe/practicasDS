#include "ComponenteEquipo.hpp"

void ComponenteEquipo::aceptarVisitante(VisitanteEquipo &v){
}

void ComponenteEquipo::setPrecio(double p){
    precio = p;
}

double ComponenteEquipo::getPrecio() const{
    return (precio);
}

void ComponenteEquipo::setNombre(string n) {
    nombre = n;
}

string ComponenteEquipo::getNombre() const {
    return (nombre);
}