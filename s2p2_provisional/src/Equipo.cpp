#include "Equipo.hpp"

void Equipo::insertarComponente(Disco d){
    componentes.push_back(pair<Tipo, ComponenteEquipo>(Tipo::TDisco,d));
}

void Equipo::insertarComponente(Tarjeta t){
    componentes.push_back(pair<Tipo, ComponenteEquipo>(Tipo::TTarjeta,t));
}

void Equipo::insertarComponente(Bus b){
    componentes.push_back(pair<Tipo, ComponenteEquipo>(Tipo::TBus,b));
}


vector<pair<Tipo,ComponenteEquipo>> Equipo::getComponentes() const {
    return (componentes);
}