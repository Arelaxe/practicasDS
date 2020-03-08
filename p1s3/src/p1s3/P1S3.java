/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1s3;

import java.util.*;

/**
 *
 * @author noelia
 */
public class P1S3 {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BotonCambio boton = new BotonCambio ();
        PantallaTemperatura pantalla = new PantallaTemperatura();
        GraficaTemperatura grafica = new GraficaTemperatura();
        Temperatura t = new Temperatura(ZonaGeografica.ZONA1);
        HebraTemperatura h = new HebraTemperatura(t); 
        
        
        TiempoSatelital ts = new TiempoSatelital(ZonaGeografica.ZONA1);
        
        for (int i=0; i<ZonaGeografica.values().length; i++){
            Temperatura t_aux = new Temperatura(ZonaGeografica.values()[i]);
            HebraTemperatura ht_aux = new HebraTemperatura(t_aux);
            
            ts.addTemperatura(t_aux);
            t_aux.addObserver(ts);
            
            ht_aux.start();
        }
        
        t.addObserver(boton);
        t.addObserver(grafica);
        h.start();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal v = new VentanaPrincipal();
                pantalla.setVentana(v);
                grafica.setVentana(v);
                ts.setVentana(v);
                v.setBotonCambio(boton);
                v.setPantallaTemperatura(pantalla);
                v.setTemperatura(t);
                v.setVisible(true);
            }
        });
    }
    
}
