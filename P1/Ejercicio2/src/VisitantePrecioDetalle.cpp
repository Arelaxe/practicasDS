#include <iostream>
#include "VisitantePrecioDetalle.hpp"

using namespace std;

VisitantePrecioDetalle::VisitantePrecioDetalle(TipoVisitante t): VisitanteEquipo(t){
}

void VisitantePrecioDetalle::visitarDisco(Disco & d) {
    d.setPrecio((1-descuento)*precioComponente(d.getNombre()));
    componentes.push_back(d.getNombre());
}

void VisitantePrecioDetalle::visitarTarjeta(Tarjeta & t) {
    t.setPrecio((1-descuento)*precioComponente(t.getNombre()));
    componentes.push_back(t.getNombre());

}

void VisitantePrecioDetalle::visitarBus(Bus & b) {
    b.setPrecio((1-descuento)*precioComponente(b.getNombre()));
    componentes.push_back(b.getNombre());
}

void VisitantePrecioDetalle::mostrarDetalles() {
    double precio;
    
    for (int i=0; i<componentes.size(); i++){
        cout << "Componente " << i+1 << ": " << componentes[i] << " - ";

        if ((precio = (1-descuento)*precioComponente(componentes[i])) >= 0)
            cout << precio << endl;
        else 
            cout << "sin identificar" << endl;
        
    }
}
