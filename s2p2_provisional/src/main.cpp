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
    VisitantePrecio vp;
    VisitantePrecioDetalle vd;
    
    eq.insertarComponente(Disco("Disco SAS"));
    eq.insertarComponente(Bus("Bus PCI"));
    eq.insertarComponente(Bus("Bus PCIe"));
    eq.insertarComponente(Tarjeta("Tarjeta red"));
    eq.insertarComponente(Disco("Nombre inventado"));

    // Para que se llamen a los métodos aceptarVisitante de las subclases, debemos
    // trabajar con punteros
    vector<ComponenteEquipo*> pcomponentes = eq.getPComponentes();


    for (int i=0; i<pcomponentes.size(); i++){
        pcomponentes[i]->aceptarVisitante(&vd);
        pcomponentes[i]->aceptarVisitante(&vp);
    }

    vd.mostrarDetalles();
    cout << endl;
    cout << "Coste total: " << vp.precioTotal() << endl;

    return (0);
}