
package p1s4;

import java.util.Observable;
import java.util.concurrent.TimeUnit;


public class Objetivo extends Observable implements Runnable{
    static final double RADIO = 0.15;
    
    private double tiempo; 
    private double velocidad;
    private double distancia, distanciaAcumulada;
    private double rpm, velCrucero;
    private double revoluciones;
    private double combustible;
    private double revCombustible, revAceite, revPastillas, revRevGeneral;
    
    private EstadoMotor estadoMotor;
    private EstadoSCACV estadoSCACV;
    
    private GestorFiltros gestor;
    
    
    // *************************************************************************
    // CONSTRUCTOR:
    // *************************************************************************
    
    public Objetivo(){
        revCombustible = revAceite = revPastillas = revRevGeneral = 0;
        distanciaAcumulada = 0;
        
        // El valor del combustible es un valor aleatorio entre 10 y 110
        combustible = 10 + (double)(Math.random() * 100);
        
        // Inicializamos el valor del estado del motor y del SCACV a APAGADO
        estadoMotor = EstadoMotor.APAGADO;
        estadoSCACV = EstadoSCACV.APAGADO;
        
        gestor = new GestorFiltros();
        
        // Añadimos en el constructor los dos filtros que queramos aplicarle.
        // Es importante el orden en el que añadimos los filtros.
        
        gestor.aniadirFiltro(new CalcularVelocidad());
        gestor.aniadirFiltro(new RepercutirRozamiento());
    }
    
    
    // *************************************************************************
    // MÉTODOS CONSULTORES:
    // *************************************************************************

    public double getVelocidad() {
        return velocidad;
    }
    public double getVelCrucero(){
        return velCrucero;
    }

    public double getDistancia() {
        return distancia;
    }
    public double getDistanciaAcumulada(){
        return distanciaAcumulada;
    }
    
    public double getRPM(){
        return rpm;
    }

    public double getRevoluciones() {
        return revoluciones;
    }
    public double getRevAceite() {
        return revAceite;
    }
    public double getRevPastillas() {
        return revPastillas;
    }
    public double getRevRevgeneral() {
        return revRevGeneral;
    }
    public double getRevCombustible() {
        return revCombustible;
    }
    
    public double getCombustible() {
        return combustible;
    }
    
    public EstadoMotor getEstadoMotor(){
        return estadoMotor;
    }
    public EstadoSCACV getEstadoSCACV() {
        return estadoSCACV;
    }
    
    
    
    // *************************************************************************
    // MÉTODOS MODIFICADORES:
    // *************************************************************************
    
    public void setGestor(GestorFiltros g){
        gestor = g;
    }
    
    public void setVelCrucero(double v){
        velCrucero = v;
    }

    public void setRevAceite(double r) {
        this.revAceite = r;
    }
    public void setRevPastillas(double r) {
        this.revPastillas = r;
    }
    public void setRevRevgeneral(double r) {
        this.revRevGeneral = r;
    }
    public void setRevCombustible(double revCombustible) {
        this.revCombustible = revCombustible;
    }
    
    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }
    
    public void setEstadoMotor(EstadoMotor e){
        this.estadoMotor = e;
    }
    public void setEstadoSCACV(EstadoSCACV estadoSCACV) {
        this.estadoSCACV = estadoSCACV;
    }
    
    // *************************************************************************
    // MÉTODOS AUXILIARES:
    // *************************************************************************
    
    // Método EJECUTAR: llamado por la cadena de filtros, se encarga de actualizar
    // las variables segun corresponda.
    
    
    public double ejecutar(double r, EstadoMotor e, EstadoSCACV es, boolean c){
        rpm = r;
        velocidad = 2*Math.PI*RADIO*rpm*(60.0/1000);
        
        double incrementoDist = velocidad*(1.0/3600);
        double incrementoRev = (rpm/60)*tiempo;
        
        if (rpm==0){
            distancia=0;
            revoluciones=0;
        }
        // Actualizamos la velocidad de crucero cada vez que entremos en modo mantener
        else if (estadoSCACV == EstadoSCACV.MANTENER){
            velCrucero = velocidad;
        }
        
        // Actualizamos distancias:
        distancia+=incrementoDist;
        distanciaAcumulada+=incrementoDist;
        
        // Actualizamos revoluciones:
        revoluciones+=incrementoRev;
        revAceite+=incrementoRev;
        revPastillas+=incrementoRev;
        revRevGeneral+=incrementoRev;
        revCombustible+=incrementoRev;
        
        // Actualizamos combustible
        combustible=Math.max(combustible-incrementoRev*incrementoRev*5*Math.pow(10,-2),0);
        
        if (estadoSCACV == EstadoSCACV.REINICIAR)
            actualizarEstadoReinicio();
        
        return rpm;
    }
    
    // Método necesario para actualizar el estado del motor en el caso de que esté
    // en estado de reinicio, teniendo en cuenta la velocidad de crucero, para que
    // posteriormente los filtros modifiquen los rpm correctamente según corresponda.
    
    private void actualizarEstadoReinicio(){
        
        if (velocidad < velCrucero-0.1){
            // Para evitar que entre en un bucle en caso de que la diferencia sea
            // mayor que 0.1
            if (estadoMotor == EstadoMotor.FRENANDO){
                estadoMotor = EstadoMotor.ENCENDIDO;
                velocidad=velCrucero;
                rpm=velCrucero/(2*Math.PI*RADIO*(60.0/1000));
            }else
                estadoMotor = EstadoMotor.ACELERANDO;
            
        }else if (velocidad > velCrucero+0.1){
            // Para evitar que entre en un bucle en caso de que la diferencia sea
            // mayor que 0.1
            if (estadoMotor == EstadoMotor.ACELERANDO){
                estadoMotor = EstadoMotor.ENCENDIDO;
                velocidad=velCrucero;
                rpm=velCrucero/(2*Math.PI*RADIO*(60.0/1000));
            }else
                estadoMotor = EstadoMotor.FRENANDO;
        }else 
            estadoMotor = EstadoMotor.ENCENDIDO;
    }
    
    // Método necesario para realizar la petición desde el controlador (solicitud
    // asíncrona); ejecutado también en la llamada al método RUN.
    
    public void realizarPeticion(){
        gestor.peticionFiltro(this, estadoMotor, estadoSCACV, combustible>0);
        
        setChanged();
        notifyObservers(this);
    }
    
    // Método RUN: ejecutado por las hebras (cada seg.)
    
    @Override
    public void run(){
        
        while(true){
            // Retardo de 1 seg.
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException ex){
                System.out.println("Interrumpido");
            }
            
            // Actualizamos tiempo
            tiempo+=1.0/3600;
            
            realizarPeticion();
        }
    }
}
