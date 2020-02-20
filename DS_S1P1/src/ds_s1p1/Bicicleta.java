/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_s1p1;

/**
 *
 * @author escaleranm
 */
public abstract class Bicicleta extends Thread{
    private Integer identificador;
    private double tiempo;
    FactoriaCarreraYBicicleta factoria;
    
    public Bicicleta(){
        tiempo=-1;
    }
    
    public Bicicleta(FactoriaCarreraYBicicleta factoria){
        this.factoria = factoria;
        tiempo=-1;
    }
    
    public void setIdentificador(int id){
        identificador = id;
    }
    
    public void inicio(){
        tiempo = Math.random()*(60-5)+5;
        
        try {
            Thread.sleep((long)tiempo*1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrumpido");
        }
        
        if (factoria instanceof FactoriaCarretera)
            System.out.println("La bicicleta "+identificador+" de carretera ha llegado ("+tiempo+" seg.)");
        else
            System.out.println("La bicicleta "+identificador+" de montaña ha llegado ("+tiempo+" seg.)");
    }
    
    public double getTiempo(){
        return (tiempo);
    }
    
    @Override
    public void run(){
        inicio();
    }
}
