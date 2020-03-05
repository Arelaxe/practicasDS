
package p1s3;
import java.util.*;

public class PantallaTemperatura implements Observer {
    private Temperatura temperatura;
    private VentanaPrincipal v;
    
    public void setVentana (VentanaPrincipal v){
        this.v = v;
    }
    
    @Override
    public void update(Observable obs, Object obj){
        temperatura = (Temperatura) obj;
        v.getEtiqueta().setText(temperatura.toString());
    }
}
