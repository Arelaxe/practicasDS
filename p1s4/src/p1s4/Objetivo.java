/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1s4;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;


public class Objetivo extends Thread{
    static final double MAX_VEL = 5000;
    static final double RADIO = 0.15; 
    
    private double tiempo = 0; 
    private double velocidad;
    private double distancia=0;
    private double distancia_reciente=0;
    private double revoluciones;
    
    
    private GestorFiltros gestor;
    private VentanaPrincipal v;
    
    public Objetivo(VentanaPrincipal v){
        this.v = v;
        gestor = new GestorFiltros();
        
        // Añadimos en el constructor los dos filtros que queramos aplicarle.
        // Es importante el orden en el que añadimos los filtros.
        
        gestor.aniadirFiltro(new CalcularVelocidad());
        gestor.aniadirFiltro(new RepercutirRozamiento());
        
        // Activamos una hebra para que vaya realizando todas las modificaciones
        // de forma periódica (cada segundo)
        this.start();
    }
    
    // Método básico para actualizar los atributos del objetivo
    
    public double ejecutar(double r, EstadoMotor estadoMotor){
        revoluciones = r;
        velocidad = 2*Math.PI*RADIO*r*(60.0/1000);
        distancia_reciente = distancia;
        distancia+=velocidad*(1.0/3600); // Añadimos inc. de acuerdo a la v en 1s
        
        return revoluciones;
    }
    
    // Métodos consultores:
    
    public double getVelocidad() {
        return velocidad;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getRevoluciones() {
        return revoluciones;
    }
    
    // Métodos modificadores:
    
    public void setGestor(GestorFiltros g){
        gestor = g;
    }
    
    // Método RUN; ejecutado por las hebras:
    
    @Override
    public void run(){
        
        DecimalFormat df = new DecimalFormat("#.###");
        
        while(true){
            // Actualizamos tiempo
            tiempo+=1.0/3600;
            
            gestor.peticionFiltro(this, v.getPanelBotones().getEstadoMotor());
            
            v.getSalpicadero().getVelocimetro().getVelocidad().setText(df.format(velocidad));
            v.getSalpicadero().getCuentaKilometros().getDistanciaReciente().setText(df.format(distancia_reciente));
            v.getSalpicadero().getCuentaKilometros().getDistancia().setText(df.format(distancia));
            v.getSalpicadero().getCuentaRevoluciones().getRevoluciones().setText(df.format(revoluciones));
            
            if (revoluciones>(MAX_VEL-50)){
                v.getSalpicadero().getVelocimetro().getVelocidad().setBackground(Color.red);
                v.getSalpicadero().getCuentaRevoluciones().getRevoluciones().setBackground(Color.red);
                v.getPanelBotones().activarAvisoVelocidad();
            }
            else{
                v.getSalpicadero().getVelocimetro().getVelocidad().setBackground(Color.white);
                v.getSalpicadero().getCuentaRevoluciones().getRevoluciones().setBackground(Color.white);
                v.getPanelBotones().desactivarAvisoVelocidad();
            }
            
            // Retardo de 1 seg.
            
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException ex){
                System.out.println("Interrumpido");
            }
            
        }
    }
}
