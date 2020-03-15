package p1s3;

public class P1S3 {
    
    public static void main(String[] args) {
        // Inicializamos los distintos componentes del sistema
        BotonCambio boton = new BotonCambio ();
        GraficaTemperatura grafica = new GraficaTemperatura();
        Temperatura t = new Temperatura(ZonaGeografica.ZONA1);
        PantallaTemperatura pantalla = new PantallaTemperatura(t);
        HebraTemperatura h = new HebraTemperatura(t); 
        HebraPantallaTemperatura p = new HebraPantallaTemperatura(pantalla);
        TiempoSatelital ts = new TiempoSatelital(ZonaGeografica.ZONA1);
        
        for (int i=0; i<ZonaGeografica.values().length; i++){
            Temperatura t_aux = new Temperatura(ZonaGeografica.values()[i]);
            HebraTemperatura ht_aux = new HebraTemperatura(t_aux);
            
            ts.addTemperatura(t_aux);
            t_aux.addObserver(ts);
            
            ht_aux.start();
        }
        
        // Suscribimos los observadores
        t.addObserver(ts);
        t.addObserver(boton);
        t.addObserver(grafica);
        
        // Iniciamos las hebras
        h.start();
        p.start();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Hacemos visibles los JFrames
                grafica.setVisible(true);
                pantalla.setVisible(true);
                boton.setVisible(true);
                ts.setVisible(true);
            }
        });
    }
    
}
