package p1s3;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Temperatura extends Observable implements Runnable{
    private double temperatura = 0;
    private ZonaGeografica zona;
    
    Temperatura(ZonaGeografica z){
        zona = z;
    }
    
    public ZonaGeografica getZona(){
        return (zona);
    }
    
    public double getTemperatura(){
        return (temperatura);
    }
    
    public void setZona(ZonaGeografica z){
        zona=z;
    }
    
    public void setTemperatura(double temperatura){
        this.temperatura = temperatura;
    }
    
    @Override
    public void run(){
        while (true){
            temperatura = Math.random()*(50);
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch(InterruptedException ex){
                System.out.println("Interrumpido");
            }
            setChanged();
            notifyObservers(this);
        }
    }
    
    @Override
    public String toString(){
        return String.format("%.2f", temperatura);
    }
}
