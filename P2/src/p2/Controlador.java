
package p2;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class Controlador implements Observer{
    private DecimalFormat df = new DecimalFormat("#.###");
    private InterfazGrafica i;
    private Objetivo obj = new Objetivo();
    
    // *************************************************************************
    // CONSTRUCTOR:
    // *************************************************************************
    
    public Controlador(){
        HebraObjetivo ho = new HebraObjetivo(obj);
        ho.start();
    }
    
    public void setValores(InterfazGrafica i){
        this.i = i;
        this.obj.addObserver(this);
    }
    
    // *************************************************************************
    // MÉTODOS AUXILIARES:
    // *************************************************************************
    // Cabe destacar la variedad en cuanto a la funcionalidad de estos métodos,
    // ya que esta clase se encarga de gestionar todas las comunicaciones más
    // genéricas entre el modelo y la vista.
    
    // Método para cambiar el aceite:
    public void cambiarAceite(){
        obj.setRevAceite(0);
    }
    
    // Método para cambiar las pastillas de frenos:
    public void cambiarPastillasFrenos(){
        obj.setRevPastillas(0);
    }
    
    // Método para realizar la revisión general;
    public void revisionGeneral(){
        obj.setRevRevgeneral(0);
    }
    
    // Método para cambiar el estado del motor (necesario para com. síncrona)
    public void cambioEstadoMotor(EstadoMotor e){
        obj.setEstadoMotor(e);
        obj.realizarPeticion();
    }
    
    // Método para cambiar el estado del SCACV (necesario para com. síncrona)
    public void cambioEstadoSCACV(EstadoSCACV e){
        obj.setEstadoSCACV(e);
        obj.realizarPeticion();
    }
    
    // Método para añadir más combustible
    public void aniadirCombustible(String c){
         System.out.println(obj.getCombustible());
        obj.setCombustible(obj.getCombustible()+Double.valueOf(c));
    }
    
    // Actualiza el estado del panel si estamos en modo reinicio
    private void actualizarEstadoReinicio(){
        
        if (this.obj.getEstadoMotor()==EstadoMotor.ACELERANDO){
            i.getEtiquetaPrincipal().setText("ACELERANDO");
            i.setEstadoMotor(EstadoMotor.ACELERANDO);
        }
        else if (this.obj.getEstadoMotor()==EstadoMotor.FRENANDO){
            i.getEtiquetaPrincipal().setText("FRENANDO");
            i.setEstadoMotor(EstadoMotor.FRENANDO);
        }
        else {
            // En el caso de que hayamos estabilizado el sistema, entramos en
            // modo "mantener" (desactivamos modo reiniciar)
            i.actualizarBotonMantener();
            i.getBotonMantener().setSelected(true);
            i.getBotonReiniciar().setSelected(false);
            
            this.obj.setEstadoSCACV(EstadoSCACV.MANTENER);
        }
    }
    
    
    // Método update; al que llamará el Subject cada vez que realice un notify
    
    @Override
    public void update (Observable obs, Object obj){
        this.obj = (Objetivo) obj;
        Date date = new Date();
        
        // Activamos (o desactivamos) el mensaje de aviso de velocidad en caso 
        // de que estemos próximos al límite
        if (this.obj.getRPM()>(CalcularVelocidad.MAX_VEL-50))
            i.activarAvisoVelocidad();
        else 
            i.desactivarAvisoVelocidad();
        
        // Mostramos los avisos correspondientes cuando haya que realizar las 
        // renovaciones
        if (this.obj.getRevAceite() > 5*Math.pow(10,6))
            i.setMensajeAviso("Necesita cambiar el aceite");
        
        if (this.obj.getRevPastillas() > Math.pow(10,8))
            i.setMensajeAviso("Necesita cambiar las pastillas de freno");
        
        if (this.obj.getRevRevgeneral() > Math.pow(10, 9))
            i.setMensajeAviso("Necesita una revisión general");
        
        
        // Actualizamos etiqueta de la velocidad de crucero cuando se pueda 
        // reiniciar (después de que haya estado al menos una vez en mantenimiento)
        if (i.puedeReiniciar())
            i.getEtiquetaVelocidadCrucero().setText(df.format(this.obj.getVelCrucero()));
        
        if (this.obj.getEstadoSCACV()==EstadoSCACV.REINICIAR)
            actualizarEstadoReinicio();
        
        
        // En el caso de que no haya combustible, actualizamos botones y 
        // etiquetas según corresponda
        if (this.obj.getCombustible()==0){
            i.setTieneCombustible(false);
            i.desactivarBotones();
            this.obj.setEstadoMotor(EstadoMotor.APAGADO);
            this.obj.setEstadoSCACV(EstadoSCACV.APAGADO);
        }else
            this.obj.setEstadoMotor(i.getEstadoMotor());
        
        // Actualizamos la velocidad del i
        i.getVelocidad().setText(df.format(this.obj.getVelocidad()));
        i.getSpeedometer().setSpeed(date, this.obj.getVelocidad());
        
        // Actualizamos la distancia (actual y acumulada) del i
        i.getDistanciaReciente().setText(df.format(this.obj.getDistancia()));
        i.getDistancia().setText(df.format(this.obj.getDistanciaAcumulada()));
        
        // Actualizamos rpm y revoluciones, así como las revoluciones acumuladas
        // desde la última vez que se cambio el aceite, pastillas o revisión general
        i.getRPM().setText(df.format(this.obj.getRPM()));
        i.getRevoluciones().setText(df.format(this.obj.getRevoluciones()));
        i.getRevAceite().setText(df.format(this.obj.getRevAceite()));
        i.getRevPastillas().setText(df.format(this.obj.getRevPastillas()));
        i.getRevRevGeneral().setText(df.format(this.obj.getRevRevgeneral()));
        
        // Actualizamos el combustible
        i.getCombustible().setText(df.format(this.obj.getCombustible()));
        i.getBarraCombustible().setValue((int)(this.obj.getCombustible()*100)/110);

        // Cambiamos el color de la etiqueta de la velocidad para que avise en caso
        // de que estemos en el límite aceptado (igual para desactivarla)
        if (this.obj.getRPM()>(CalcularVelocidad.MAX_VEL-50)){
            i.getVelocidad().setBackground(Color.red);
            i.getRevoluciones().setBackground(Color.red);
        }
        else{
            i.getVelocidad().setBackground(Color.white);
            i.getRevoluciones().setBackground(Color.white);
        }
    }
}
