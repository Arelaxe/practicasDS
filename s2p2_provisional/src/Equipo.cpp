#include "Equipo.hpp"

void Equipo::insertarComponente(Disco d){
    componentes.push_back(d);
    pcomponentes.push_back(&d);
}

void Equipo::insertarComponente(Tarjeta t){
    componentes.push_back(t);
    pcomponentes.push_back(&t);
}

void Equipo::insertarComponente(Bus b){
    componentes.push_back(b);
    pcomponentes.push_back(&b);
}


vector<ComponenteEquipo*> Equipo::getPComponentes() const {
    return (pcomponentes);
}