#include "VisitanteEquipo.hpp"
#include <string>

class ComponenteEquipo{
    private:
    double precio;
    string nombre;
    public:
    virtual void aceptarVisitante(VisitanteEquipo v);
    void setPrecio (double p);
    double getPrecio () const;
    void setNombre (string n);
    string getNombre () const;
};