package p1s3;

import java.util.*;

public class GraficaTemperatura implements Observer{
    private Temperatura temperatura;
    
    @Override
    public void update(Observable obs, Object obj){
        temperatura = (Temperatura) obj;
    }
}
