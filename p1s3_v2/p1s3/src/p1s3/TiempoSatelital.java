/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1s3;

import java.util.*;

/**
 *
 * @author jesus
 */
public class TiempoSatelital implements Observer{
    private ArrayList<Temperatura> temperaturas = new ArrayList<>();
    private VentanaPrincipal v;
    private ZonaGeografica zona;
    
    public TiempoSatelital(ZonaGeografica z){
        zona=z;
    }
    
    public void addTemperatura(Temperatura t){
        temperaturas.add(t);
    }
    
    public void setVentana(VentanaPrincipal ventana){
        v = ventana;
    }
    
    @Override
    public void update(Observable obs, Object obj){
        zona = v.getMapa().getZona();

        temperaturas.add(((Temperatura)obj).getZona().ordinal(), (Temperatura) obj);
        v.getEtiquetaMapa().setText(zona.toString()+" - "+temperaturas.get(zona.ordinal()).toString());
    }
    
}
