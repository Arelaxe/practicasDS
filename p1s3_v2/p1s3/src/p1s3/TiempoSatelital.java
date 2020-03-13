package p1s3;

import java.util.*;

public class TiempoSatelital extends javax.swing.JFrame implements Observer{
    private ArrayList<Temperatura> temperaturas = new ArrayList<>();
    private ZonaGeografica zona;
    
    public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
    
    public TiempoSatelital(ZonaGeografica z) {
        setLocation(1200,0);
        zona = z;
        initComponents();
    }
    
    public void addTemperatura(Temperatura t){
        temperaturas.add(t);
    }
    
    @Override
    public void update(Observable obs, Object obj){
        zona = mapa1.getZona();

        temperaturas.add(((Temperatura)obj).getZona().ordinal(), (Temperatura) obj);
        temperaturaLocal.setText(zona.toString()+" - "+temperaturas.get(zona.ordinal()).toString());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        temperaturaLocal = new javax.swing.JLabel();
        mapa1 = new p1s3.Mapa();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        temperaturaLocal.setText("Temperatura localizada");

        jDesktopPane1.setLayer(temperaturaLocal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(mapa1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(mapa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(temperaturaLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(mapa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(temperaturaLocal)))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private p1s3.Mapa mapa1;
    private javax.swing.JLabel temperaturaLocal;
    // End of variables declaration//GEN-END:variables
}
