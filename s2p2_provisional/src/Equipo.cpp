#include "Equipo.hpp"


void Equipo::insertarComponente(Disco d){
    componentes.push_back(pair<TipoComponente, ComponenteEquipo>(TipoComponente::TDisco,d));
}

void Equipo::insertarComponente(Tarjeta t){
    componentes.push_back(pair<TipoComponente, ComponenteEquipo>(TipoComponente::TTarjeta,t));
}

void Equipo::insertarComponente(Bus b){
    componentes.push_back(pair<TipoComponente, ComponenteEquipo>(TipoComponente::TBus,b));
}


vector<pair<TipoComponente,ComponenteEquipo>> Equipo::getComponentes() const {
    return (componentes);
}

double Equipo::getDescuento() const {
    return(descuento);
}