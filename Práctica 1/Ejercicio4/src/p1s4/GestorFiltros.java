package p1s4;

public class GestorFiltros {
    private CadenaFiltros cadenaFiltros = new CadenaFiltros();
    
    public void peticionFiltro (Objetivo s, EstadoMotor e){
        cadenaFiltros.ejecutar(s, e);
    }
    
    public void aniadirFiltro (Filtro f){
        cadenaFiltros.insertarFiltro(f);
    }
}
