package p1s3;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Temperatura extends Observable implements Runnable{
    private double temperatura = 0;
    
    Temperatura(){
    }
    
    public double getTemperatura(){
        return (temperatura);
    }
    
    public void setTemperatura(float temperatura){
        this.temperatura = temperatura;
    }
    
    @Override
    public void run(){
        while (true){
            temperatura = Math.random()*(50);
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException ex){
                System.out.println("Interrumpido");
            }
            setChanged();
            notifyObservers(this);
            System.out.println(Double.toString(temperatura));
        }
    }
    
    @Override
    public String toString(){
        return Double.toString(Math.floor(temperatura));
    }
}
