package p1s4;

import java.text.SimpleDateFormat;
import java.util.*;

public class Salpicadero extends javax.swing.JPanel {
    private static final double RADIO = 0.15; 
    private SimpleDateFormat formato_tiempo = new SimpleDateFormat("ss");
    private float tiempo = 0; 
    private double velocidad;
    private double distancia;
    private double revoluciones;
    
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        this.revoluciones = revoluciones;
        
        velocidad = 2*Math.PI*RADIO*revoluciones*(60/1000);
        
        Date t_actual = new Date();
        tiempo += Double.parseDouble(formato_tiempo.format(t_actual));
        
        return this.revoluciones;
    }
    
    public Salpicadero() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
