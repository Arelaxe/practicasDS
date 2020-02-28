#ifndef COMPONENTEEQUIPO
#define COMPONENTEEQUIPO

#include <string>
using namespace std;

class VisitanteEquipo;
class VisitantePrecio;
class VisitantePrecioDetalle;

class ComponenteEquipo{
    private:
    double precio;
    string nombre;
    public:
    void aceptarVisitante(VisitanteEquipo& v);
    void setPrecio (double p);
    double getPrecio () const;
    void setNombre (string n);
    string getNombre () const;
};

#endif