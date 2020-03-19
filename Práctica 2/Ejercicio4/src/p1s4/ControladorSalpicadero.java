package p1s4;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;


public class ControladorSalpicadero implements Observer{
    private Salpicadero salpicadero;
    private Objetivo obj;
    private DecimalFormat df = new DecimalFormat("#.###");
    
    
    // *************************************************************************
    // CONSTRUCTOR:
    // *************************************************************************
    
    public ControladorSalpicadero(Salpicadero s, Objetivo obj){
        salpicadero = s;
        this.obj = obj;
    }
    
    
    // *************************************************************************
    // MÉTODOS AUXILIARES:
    // *************************************************************************
    
    // Método update; al que llamará el Subject cada vez que realice un notify

    @Override
    public void update (Observable obs, Object obj){
        this.obj = (Objetivo) obj;
        
        // Actualizamos la velocidad del salpicadero
        salpicadero.getVelocimetro().getVelocidad().setText(df.format(this.obj.getVelocidad()));
        
        // Actualizamos la distancia (actual y acumulada) del salpicadero
        salpicadero.getCuentaKilometros().getDistanciaReciente().setText(df.format(this.obj.getDistancia()));
        salpicadero.getCuentaKilometros().getDistancia().setText(df.format(this.obj.getDistanciaAcumulada()));
        
        // Actualizamos rpm y revoluciones, así como las revoluciones acumuladas
        // desde la última vez que se cambio el aceite, pastillas o revisión general
        salpicadero.getCuentaRevoluciones().getRPM().setText(df.format(this.obj.getRPM()));
        salpicadero.getCuentaRevoluciones().getRevoluciones().setText(df.format(this.obj.getRevoluciones()));
        salpicadero.getCuentaRevoluciones().getRevAceite().setText(df.format(this.obj.getRevAceite()));
        salpicadero.getCuentaRevoluciones().getRevPastillas().setText(df.format(this.obj.getRevPastillas()));
        salpicadero.getCuentaRevoluciones().getRevRevGeneral().setText(df.format(this.obj.getRevRevgeneral()));
        
        // Actualizamos el combustible
        salpicadero.getControlCombustible().getCombustible().setText(df.format(this.obj.getCombustible()));

        // Cambiamos el color de la etiqueta de la velocidad para que avise en caso
        // de que estemos en el límite aceptado (igual para desactivarla)
        if (this.obj.getRPM()>(CalcularVelocidad.MAX_VEL-50)){
            salpicadero.getVelocimetro().getVelocidad().setBackground(Color.red);
            salpicadero.getCuentaRevoluciones().getRevoluciones().setBackground(Color.red);
        }
        else{
            salpicadero.getVelocimetro().getVelocidad().setBackground(Color.white);
            salpicadero.getCuentaRevoluciones().getRevoluciones().setBackground(Color.white);
        }
    }
}
