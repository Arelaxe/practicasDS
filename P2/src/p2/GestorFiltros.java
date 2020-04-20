package p2;

public class GestorFiltros {
    private CadenaFiltros cadenaFiltros = new CadenaFiltros();
    
    // *************************************************************************
    // MÉTODOS AUXILIARES:
    // *************************************************************************
    
    public void peticionFiltro (Objetivo s, EstadoMotor e, EstadoSCACV es, boolean c){
        cadenaFiltros.ejecutar(s, e, es, c);
    }
    
    public void aniadirFiltro (Filtro f){
        cadenaFiltros.insertarFiltro(f);
    }
}
