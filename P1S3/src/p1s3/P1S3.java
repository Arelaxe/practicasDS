/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1s3;

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
        Temperatura t = new Temperatura();
        HebraTemperatura h = new HebraTemperatura(t); 
        
        t.addObserver(boton);
        t.addObserver(pantalla);
        t.addObserver(grafica);
        h.start();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal v = new VentanaPrincipal();
                pantalla.setVentana(v);
                grafica.setVentana(v);
                v.setBotonCambio(boton);
                v.setVisible(true);
            }
        });
    }
    
}
