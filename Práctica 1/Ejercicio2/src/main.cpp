#include <iostream>
#include <vector>
#include "VisitanteEquipo.hpp"
#include "VisitantePrecioDetalle.hpp"
#include "VisitantePrecio.hpp"
#include "ComponenteEquipo.hpp"
#include "Equipo.hpp"

using namespace std;

int main(void){
    Equipo eq;
    VisitantePrecio vp(TipoVisitante::TEstudiante);
    VisitantePrecioDetalle vd(TipoVisitante::TEstudiante);
    
    eq.insertarComponente(Disco("Disco SAS"));
    eq.insertarComponente(Bus("Bus PCI"));
    eq.insertarComponente(Bus("Bus PCIe"));
    eq.insertarComponente(Tarjeta("Tarjeta red"));
    eq.insertarComponente(Disco("Nombre inventado"));


    vector<pair<TipoComponente,ComponenteEquipo>> componentes = eq.getComponentes();

    for (int i=0; i<componentes.size(); i++){
        if (componentes[i].first == TipoComponente::TDisco){
            ((Disco *)&componentes[i].second)->aceptarVisitante(&vd);
            ((Disco *)&componentes[i].second)->aceptarVisitante(&vp);
        }
        else if (componentes[i].first == TipoComponente::TTarjeta){
            ((Tarjeta *)&componentes[i].second)->aceptarVisitante(&vd);
            ((Tarjeta *)&componentes[i].second)->aceptarVisitante(&vp);
        }
        else if (componentes[i].first == TipoComponente::TBus){
            ((Bus *)&componentes[i].second)->aceptarVisitante(&vd);
            ((Bus *)&componentes[i].second)->aceptarVisitante(&vp);
        }
    }

    vd.mostrarDetalles();
    cout << endl;
    cout << "Coste total: " << vp.precioTotal() << endl;

    return (0);
}