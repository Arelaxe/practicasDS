package p1s4;

import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;


public class ControladorPanelBotones implements Observer{
    
    private DecimalFormat df = new DecimalFormat("#.###");
    private PanelBotones p;
    private Controlador c;
    private Objetivo obj;
    
    // *************************************************************************
    // CONSTRUCTOR:
    // *************************************************************************
    
    public ControladorPanelBotones(PanelBotones p, Objetivo obj){
        this.p = p;
        this.obj = obj;
    }
    
    // *************************************************************************
    // MÉTODOS CONSULTORES:
    // *************************************************************************
    

    public PanelBotones getPanel() {
        return p;
    }
    
    
    // *************************************************************************
    // MÉTODOS AUXILIARES:
    // *************************************************************************
    
    
    // Actualiza el estado del panel si estamos en modo reinicio
    private void actualizarEstadoReinicio(){
        
        if (this.obj.getEstadoMotor()==EstadoMotor.ACELERANDO){
            p.getEtiquetaPrincipal().setText("ACELERANDO");
            p.setEstadoMotor(EstadoMotor.ACELERANDO);
        }
        else if (this.obj.getEstadoMotor()==EstadoMotor.FRENANDO){
            p.getEtiquetaPrincipal().setText("FRENANDO");
            p.setEstadoMotor(EstadoMotor.FRENANDO);
        }
        else {
            // En el caso de que hayamos estabilizado el sistema, entramos en
            // modo "mantener" (desactivamos modo reiniciar)
            p.actualizarBotonMantenerAuto();
            p.getBotonMantenerAuto().setSelected(true);
            p.getBotonReiniciarAuto().setSelected(false);
            
            this.obj.setEstadoSCACV(EstadoSCACV.MANTENER);
        }
    }
    
    
    // Método update; al que llamará el Subject cada vez que realice un notify
    
    @Override
    public void update (Observable obs, Object obj){
        this.obj = (Objetivo) obj;
        
        // Activamos (o desactivamos) el mensaje de aviso de velocidad en caso 
        // de que estemos próximos al límite
        if (this.obj.getRPM()>(CalcularVelocidad.MAX_VEL-50))
            p.activarAvisoVelocidad();
        else 
            p.desactivarAvisoVelocidad();
        
        // Mostramos los avisos correspondientes cuando haya que realizar las 
        // renovaciones
        if (this.obj.getRevAceite() > 5*Math.pow(10,6))
            p.setMensajeAviso("Necesita cambiar el aceite");
        
        if (this.obj.getRevPastillas() > Math.pow(10,8))
            p.setMensajeAviso("Necesita cambiar las pastillas de freno");
        
        if (this.obj.getRevRevgeneral() > Math.pow(10, 9))
            p.setMensajeAviso("Necesita una revisión general");
        
        
        // Actualizamos etiqueta de la velocidad de crucero cuando se pueda 
        // reiniciar (después de que haya estado al menos una vez en mantenimiento)
        if (p.puedeReiniciar())
            p.getEtiquetaVelocidadCrucero().setText(df.format(this.obj.getVelCrucero()));
        
        if (this.obj.getEstadoSCACV()==EstadoSCACV.REINICIAR)
            actualizarEstadoReinicio();
        
        
        // En el caso de que no haya combustible, actualizamos botones y 
        // etiquetas según corresponda
        if (this.obj.getCombustible()==0){
            p.setTieneCombustible(false);
            p.desactivarBotones();
            this.obj.setEstadoMotor(EstadoMotor.APAGADO);
            this.obj.setEstadoSCACV(EstadoSCACV.APAGADO);
        }else
            this.obj.setEstadoMotor(p.getEstadoMotor());
    }
}
