#include <vector>
#include "ComponenteEquipo.hpp"
#include "Disco.hpp"
#include "Tarjeta.hpp"
#include "Bus.hpp"

using namespace std;

enum Tipo {TDisco, TTarjeta, TBus};

class Equipo{
    private:
    vector<pair<Tipo, ComponenteEquipo >> componentes;

    public:
    void insertarComponente(Disco d);
    void insertarComponente(Bus b);
    void insertarComponente(Tarjeta t);
    vector<pair<Tipo, ComponenteEquipo>> getComponentes() const;
};