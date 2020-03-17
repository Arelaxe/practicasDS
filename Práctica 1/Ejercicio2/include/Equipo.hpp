#include <vector>
#include "ComponenteEquipo.hpp"
#include "Disco.hpp"
#include "Tarjeta.hpp"
#include "Bus.hpp"

using namespace std;

enum TipoComponente {TDisco, TTarjeta, TBus};

class Equipo{
    private:
    vector<pair<TipoComponente, ComponenteEquipo >> componentes;
    double descuento;

    public:
    void insertarComponente(Disco d);
    void insertarComponente(Bus b);
    void insertarComponente(Tarjeta t);
    vector<pair<TipoComponente, ComponenteEquipo>> getComponentes() const;
    double getDescuento() const;
};