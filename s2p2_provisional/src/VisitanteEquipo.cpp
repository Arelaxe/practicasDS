#include "VisitanteEquipo.hpp"

VisitanteEquipo::VisitanteEquipo (){
    catalogo.insert(pair<string, double>("Disco SAS",10.2));
    catalogo.insert(pair<string, double>("Disco SATA",10.4));
    catalogo.insert(pair<string, double>("Disco SCSI",10.8));

    catalogo.insert(pair<string, double>("Bus PCI",20));
    catalogo.insert(pair<string, double>("Bus PCIe",20.5));
    catalogo.insert(pair<string, double>("USB",20.7));

    catalogo.insert(pair<string, double>("Tarjeta gráfica",30.3));
    catalogo.insert(pair<string, double>("Tarjeta red",30.9));
}

double VisitanteEquipo::precioComponente (string nombre){
    auto it = catalogo.find(nombre);

    if (it != catalogo.end())
        return (it->second);
    else
        return (-1);
}

void VisitanteEquipo::visitarDisco(Disco & d){
}

void VisitanteEquipo::visitarBus(Bus & b){
}

void VisitanteEquipo::visitarTarjeta(Tarjeta & t){
}