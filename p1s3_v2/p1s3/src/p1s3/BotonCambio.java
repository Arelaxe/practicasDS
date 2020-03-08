package p1s3;

import java.util.*;

public class BotonCambio implements Observer{
    private Temperatura temperatura;
    private boolean cambio_temperatura = false;
    
    public void setCambioTemperatura (boolean c){
        cambio_temperatura = c;
    }
    
    public void setTemperatura (double t){
        temperatura.setTemperatura(t);
    }
    
    @Override
    public void update(Observable obs, Object obj){
        if (cambio_temperatura){
            obs = temperatura;
        }
        else {
            temperatura = (Temperatura) obj;
        }
    }
}
