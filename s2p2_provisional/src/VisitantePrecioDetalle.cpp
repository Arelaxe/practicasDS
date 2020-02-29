#include <iostream>
#include "VisitantePrecioDetalle.hpp"

using namespace std;

VisitantePrecioDetalle::VisitantePrecioDetalle(){
}

void VisitantePrecioDetalle::visitarDisco(Disco & d) {
    d.setPrecio(precioComponente(d.getNombre()));
    componentes.push_back(d.getNombre());
}

void VisitantePrecioDetalle::visitarTarjeta(Tarjeta & t) {
    t.setPrecio(precioComponente(t.getNombre()));
    componentes.push_back(t.getNombre());

}

void VisitantePrecioDetalle::visitarBus(Bus & b) {
    b.setPrecio(precioComponente(b.getNombre()));
    componentes.push_back(b.getNombre());
}

void VisitantePrecioDetalle::mostrarDetalles() {
    double precio;
    
    for (int i=0; i<componentes.size(); i++){
        cout << "Componente " << i+1 << ": " << componentes[i] << " - ";

        if ((precio = precioComponente(componentes[i])) != -1)
            cout << precio << endl;
        else 
            cout << "sin identificar" << endl;
        
    }
}
