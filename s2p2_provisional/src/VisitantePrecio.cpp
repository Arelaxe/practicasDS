#include "VisitantePrecio.hpp"

void VisitantePrecio::visitarDisco(Disco & d) {
    d.setPrecio(30);
    coste_total += d.getPrecio();
}

void VisitantePrecio::visitarTarjeta(Tarjeta & t) {
    t.setPrecio(20);
    coste_total += t.getPrecio();
}

void VisitantePrecio::visitarBus(Bus & b) {
    b.setPrecio(10);
    coste_total += b.getPrecio();
}

double VisitantePrecio::precioTotal() const {
    return (coste_total);
}
