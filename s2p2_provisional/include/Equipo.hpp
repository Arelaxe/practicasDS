#include <vector>
#include "ComponenteEquipo.hpp"
#include "Disco.hpp"
#include "Tarjeta.hpp"
#include "Bus.hpp"

using namespace std;



class Equipo{
    private:
    vector<ComponenteEquipo> componentes;
    vector<ComponenteEquipo *> pcomponentes;

    public:
    void insertarComponente(Disco d);
    void insertarComponente(Bus b);
    void insertarComponente(Tarjeta t);
    vector<ComponenteEquipo*> getPComponentes() const;
};