
package p1s3;
import java.util.*;

public class PantallaTemperatura implements Observer {
    private Temperatura temperatura;
    
    @Override
    public void update(Observable obs, Object obj){
        temperatura = (Temperatura) obj;
    }
}
