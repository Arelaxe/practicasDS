package p1s4;

import java.util.*;

public class CadenaFiltros {
    private ArrayList<Filtro> listaFiltros = new ArrayList<>();
    
    public CadenaFiltros(){
        listaFiltros.add(new CalcularVelocidad());
        listaFiltros.add(new RepercutirRozamiento());
    }
    
    public double ejecutar(Objetivo s, EstadoMotor e){
        double revoluciones = s.getRevoluciones();
        
        for (Filtro f:listaFiltros){
            revoluciones=f.ejecutar(revoluciones, e);
        }
        s.ejecutar(revoluciones,e);
        
        return (revoluciones);
    }
    
    public void insertarFiltro(Filtro f){
        listaFiltros.add(f);
    }
}
