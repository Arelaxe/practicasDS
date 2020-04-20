package p2;

import java.util.*;

public class CadenaFiltros {
    private ArrayList<Filtro> listaFiltros = new ArrayList<>();
    
    // *************************************************************************
    // CONSTRUCTOR:
    // *************************************************************************
    
    public CadenaFiltros(){
        listaFiltros.add(new CalcularVelocidad());
        listaFiltros.add(new RepercutirRozamiento());
    }
    
    
    // *************************************************************************
    // MÉTODOS AUXILIARES:
    // *************************************************************************
    
    // Método ejecutar; llamará al método ejecutar de cada filtro y del objetivo
    
    public double ejecutar(Objetivo s, EstadoMotor e, EstadoSCACV es, boolean c){
        double rpm = s.getRPM();
        
        for (Filtro f:listaFiltros){
            rpm=f.ejecutar(rpm, e, es, c);
        }
        
        s.ejecutar(rpm,e,es,c);
        
        return (rpm);
    }
    
    
    // Este método nos permite insertar un nuevo filtro
    
    public void insertarFiltro(Filtro f){
        listaFiltros.add(f);
    }
}
