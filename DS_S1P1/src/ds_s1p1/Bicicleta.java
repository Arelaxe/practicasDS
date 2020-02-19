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
    private int identificador;
    
    public Bicicleta(){
    }
    
    public void setIdentificador(int id){
        identificador = id;
    }
    
    public void inicio(){
        double tiempo = Math.random()*(60-5)+5;
        
        try {
            Thread.sleep((long)tiempo*1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrumpido");
        }
        
        
        System.out.println("La bicicleta "+identificador+" ha llegado ("+tiempo+" seg.)");
    }
    
    @Override
    public void run(){
        inicio();
    }
}
