#include "VisitantePrecio.hpp"

VisitantePrecio::VisitantePrecio(){
}

void VisitantePrecio::visitarDisco(Disco & d) {
    d.setPrecio(precioComponente(d.getNombre()));
    if (d.getPrecio() > 0)  coste_total += d.getPrecio();
}

void VisitantePrecio::visitarTarjeta(Tarjeta & t) {
    t.setPrecio(precioComponente(t.getNombre()));
    if (t.getPrecio() > 0)  coste_total += t.getPrecio();
}

void VisitantePrecio::visitarBus(Bus & b) {
    b.setPrecio(precioComponente(b.getNombre()));
    if (b.getPrecio() > 0)  coste_total += b.getPrecio();
}

double VisitantePrecio::precioTotal() const {
    return (coste_total);
}
