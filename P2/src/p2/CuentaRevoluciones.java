/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2;

import javax.swing.JTextField;


public class CuentaRevoluciones extends javax.swing.JPanel {

    
    // *************************************************************************
    // CONSTRUCTOR:
    // *************************************************************************
    
    
    public CuentaRevoluciones() {
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

        etiquetaPrincipal = new javax.swing.JLabel();
        rpm = new javax.swing.JTextField();
        etiquetaRPM = new javax.swing.JLabel();
        etiquetaRevoluciones = new javax.swing.JLabel();
        etiquetaRevAceite = new javax.swing.JLabel();
        etiquetaRevPastillas = new javax.swing.JLabel();
        etiquetaRevRevGeneral = new javax.swing.JLabel();
        revoluciones = new javax.swing.JTextField();
        revAceite = new javax.swing.JTextField();
        revPastillas = new javax.swing.JTextField();
        revRevGeneral = new javax.swing.JTextField();

        etiquetaPrincipal.setText("Cuenta Revoluciones");
        etiquetaPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rpm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpmActionPerformed(evt);
            }
        });

        etiquetaRPM.setText("RPM");

        etiquetaRevoluciones.setText("Revoluciones");

        etiquetaRevAceite.setText("Revoluciones (sin cambiar aceite)");

        etiquetaRevPastillas.setText("Revoluciones (sin cambiar pastillas f.)");

        etiquetaRevRevGeneral.setText("Revoluciones (sin realizar revisión)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaRevAceite)
                    .addComponent(etiquetaPrincipal)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(etiquetaRevoluciones))
                    .addComponent(etiquetaRevPastillas)
                    .addComponent(etiquetaRevRevGeneral))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(revAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(revPastillas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(revRevGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(etiquetaRPM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rpm, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(etiquetaPrincipal)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaRPM))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaRevoluciones)
                    .addComponent(revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaRevAceite)
                    .addComponent(revAceite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaRevPastillas)
                    .addComponent(revPastillas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaRevRevGeneral)
                    .addComponent(revRevGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rpmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rpmActionPerformed

    
    // *************************************************************************
    // MÉTODOS CONSULTORES:
    // *************************************************************************
    
    
    public JTextField getRPM() {
        return rpm;
    }

    public JTextField getRevAceite() {
        return revAceite;
    }

    public JTextField getRevPastillas() {
        return revPastillas;
    }

    public JTextField getRevRevGeneral() {
        return revRevGeneral;
    }
    
    public JTextField getRevoluciones() {
        return revoluciones;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etiquetaPrincipal;
    private javax.swing.JLabel etiquetaRPM;
    private javax.swing.JLabel etiquetaRevAceite;
    private javax.swing.JLabel etiquetaRevPastillas;
    private javax.swing.JLabel etiquetaRevRevGeneral;
    private javax.swing.JLabel etiquetaRevoluciones;
    private javax.swing.JTextField revAceite;
    private javax.swing.JTextField revPastillas;
    private javax.swing.JTextField revRevGeneral;
    private javax.swing.JTextField revoluciones;
    private javax.swing.JTextField rpm;
    // End of variables declaration//GEN-END:variables
}
