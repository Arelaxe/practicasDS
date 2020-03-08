/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1s3;
import java.util.*;

public class HebraTemperatura extends Thread implements Observer{
    private Temperatura t;
    
    public HebraTemperatura(){
    }

    public HebraTemperatura (Temperatura t){
        this.t = t;
    }
    
    public void setTemperatura (Temperatura t){
        this.t = t;
    }
    
    @Override
    public void run(){
        t.run();
    }
    
    @Override
    public void update(Observable obs, Object obj){
        t = (Temperatura) obj;
    }
}
