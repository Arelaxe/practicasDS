package p2;

import p2.EstadoMotor;
import p2.EstadoSCACV;
import p2.Controlador;
import java.awt.Color;
import javax.swing.*;

public class InterfazGrafica extends javax.swing.JApplet {
    private Controlador controlador = new Controlador();
    
    private boolean modoManual = true;
    private boolean tieneCombustible = true;
    private boolean puedeReiniciar = false;
    private InterfazGrafica that = this;
    
    private EstadoMotor estadoMotor = EstadoMotor.APAGADO;
    private EstadoSCACV estadoSCACV = EstadoSCACV.APAGADO;
    
    @Override
    public void init() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                    controlador.setValores(that);
                    setSize(1200, 500);
                    barraCombustible.setOrientation(JProgressBar.VERTICAL);
                    aviso.setVisible(false);
                    
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    public void actualizarBotonEncender(){
        if (botonEncender.isSelected()){
            botonEncender.setForeground(Color.red);
            botonEncender.setText("APAGAR");
            etiquetaPrincipal.setText("ENCENDIDO");
            estadoMotor = EstadoMotor.ENCENDIDO;
            modoManual=true;
        }else{
            botonEncender.setForeground(Color.green);
            botonEncender.setText("ENCENDER");
            etiquetaPrincipal.setText("APAGADO");
            estadoMotor = EstadoMotor.APAGADO;
            modoManual=true;
            puedeReiniciar=false;
        }
    }
    
    public void actualizarBotonMantener() {
        etiquetaPrincipal.setText("MANTENIENDO VELOCIDAD DE CRUCERO");
        estadoSCACV = EstadoSCACV.MANTENER;
        estadoMotor = EstadoMotor.ENCENDIDO;
        puedeReiniciar=true;
    }
    
    public void actualizarBotonParar() {
        etiquetaPrincipal.setText("ENCENDIDO");
        estadoSCACV = EstadoSCACV.APAGADO;
        modoManual=true;
    }
    
    public void actualizarBotonFrenar() {
        if (botonFrenar.isSelected()){
            botonFrenar.setForeground(Color.red);
            botonFrenar.setText("SOLTAR FRENO");
            etiquetaPrincipal.setText("FRENANDO");
            estadoMotor = EstadoMotor.FRENANDO;
            modoManual=true;
        }else{
            botonFrenar.setForeground(Color.black);
            botonFrenar.setText("PISAR FRENO");
            etiquetaPrincipal.setText("ENCENDIDO");
            estadoMotor = EstadoMotor.ENCENDIDO;
        }
    }
    
    public void actualizarBotonAcelerar() {
        etiquetaPrincipal.setText("ACELERANDO AUTOMATICAMENTE");
        estadoSCACV = EstadoSCACV.ACELERAR;
        estadoMotor = EstadoMotor.ACELERANDO;
        modoManual=false;
    }
    
    public void actualizarBotonReiniciar() {
        etiquetaPrincipal.setText("REINICIO - VOLVEMOS A VELOCIDAD DE CRUCERO");
        estadoSCACV = EstadoSCACV.REINICIAR;
        modoManual=false;
    }
    
    public void actualizarBotonPisarAcelerador() {
        if (botonPisarAcelerador.isSelected()){
            botonPisarAcelerador.setForeground(Color.red);
            botonPisarAcelerador.setText("SOLTAR ACELERADOR");
            etiquetaPrincipal.setText("ACELERANDO");
            estadoMotor = EstadoMotor.ACELERANDO;
            modoManual = true;
        }else{
            botonPisarAcelerador.setForeground(Color.black);
            botonPisarAcelerador.setText("PISAR ACELERADOR");
            etiquetaPrincipal.setText("ENCENDIDO");
            estadoMotor = EstadoMotor.ENCENDIDO;
        }
    }
    
    // Métodos para activar/desactivar mensaje de aviso:
    public void activarAvisoVelocidad(){
        controlVelocidad.setText("¡ATENCIÓN!  MODERE SU VELOCIDAD");
    }
    public void desactivarAvisoVelocidad(){
        controlVelocidad.setText("AHORA MISMO MANTIENE UNA VELOCIDAD ADECUADA");
    }
    
    // Desactiva los botones seleccionados
    public void desactivarBotones(){
        botonEncender.setSelected(false);
        botonFrenar.setSelected(false);
        botonAcelerar.setSelected(false);
        botonAcelerar.setSelected(false);
        botonMantener.setSelected(false);
        botonReiniciar.setSelected(false);
        botonParar.setSelected(false);
        actualizarBotonAcelerar();
        actualizarBotonFrenar();
        actualizarBotonEncender();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonEncender = new javax.swing.JToggleButton();
        botonFrenar = new javax.swing.JToggleButton();
        etiquetaPrincipal = new javax.swing.JLabel();
        botonCambiarAceite = new javax.swing.JButton();
        botonCambiarPastillasFreno = new javax.swing.JButton();
        botonAniadirCombustible = new javax.swing.JButton();
        combustibleAniadir = new javax.swing.JTextField();
        botonMantener = new javax.swing.JToggleButton();
        botonParar = new javax.swing.JToggleButton();
        botonReiniciar = new javax.swing.JToggleButton();
        aviso = new javax.swing.JLabel();
        etiquetaVelocidadCrucero = new javax.swing.JLabel();
        distanciaReciente = new javax.swing.JTextField();
        distancia = new javax.swing.JTextField();
        rpm = new javax.swing.JTextField();
        revAceite = new javax.swing.JTextField();
        revPastillas = new javax.swing.JTextField();
        revRevGeneral = new javax.swing.JTextField();
        revoluciones = new javax.swing.JTextField();
        speedometer = new p2.Speedometer();
        velocidad = new javax.swing.JTextField();
        botonPisarAcelerador = new javax.swing.JToggleButton();
        botonAcelerar = new javax.swing.JToggleButton();
        barraCombustible = new javax.swing.JProgressBar();
        combustible = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        controlVelocidad = new javax.swing.JLabel();
        botonRevisionGeneral = new javax.swing.JButton();

        botonEncender.setForeground(new java.awt.Color(51, 204, 0));
        botonEncender.setText("ENCENDER");
        botonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncenderActionPerformed(evt);
            }
        });

        botonFrenar.setText("PISAR FRENO");
        botonFrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFrenarActionPerformed(evt);
            }
        });

        etiquetaPrincipal.setForeground(new java.awt.Color(255, 0, 0));
        etiquetaPrincipal.setText("APAGADO");

        botonCambiarAceite.setText("CAMBIAR ACEITE");
        botonCambiarAceite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarAceiteActionPerformed(evt);
            }
        });

        botonCambiarPastillasFreno.setText("CAMBIAR PASTILLAS FRENO");
        botonCambiarPastillasFreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCambiarPastillasFrenoActionPerformed(evt);
            }
        });

        botonAniadirCombustible.setText("AÑADIR COMBUSTIBLE");
        botonAniadirCombustible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirCombustibleActionPerformed(evt);
            }
        });

        combustibleAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combustibleAniadirActionPerformed(evt);
            }
        });

        botonMantener.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        botonMantener.setText("Mantener");
        botonMantener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMantenerActionPerformed(evt);
            }
        });

        botonParar.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        botonParar.setText("Apagar");
        botonParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPararActionPerformed(evt);
            }
        });

        botonReiniciar.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        botonReiniciar.setText("Reiniciar");
        botonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReiniciarActionPerformed(evt);
            }
        });

        etiquetaVelocidadCrucero.setText("NO DETERMINADA");

        rpm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpmActionPerformed(evt);
            }
        });

        revoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revolucionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout speedometerLayout = new javax.swing.GroupLayout(speedometer);
        speedometer.setLayout(speedometerLayout);
        speedometerLayout.setHorizontalGroup(
            speedometerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );
        speedometerLayout.setVerticalGroup(
            speedometerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        velocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                velocidadActionPerformed(evt);
            }
        });

        botonPisarAcelerador.setText("PISAR ACELERADOR");
        botonPisarAcelerador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPisarAceleradorActionPerformed(evt);
            }
        });

        botonAcelerar.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        botonAcelerar.setText("Acelerar");
        botonAcelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAcelerarActionPerformed(evt);
            }
        });

        jLabel1.setText("COMBUSTIBLE");

        jLabel2.setText("RPM's");

        jLabel3.setText("km/h");

        jLabel4.setText("CUENTA-KILÓMETROS");

        jLabel5.setText("km acumulados");

        jLabel6.setText("km actual");

        jLabel7.setText("Revoluciones totales");

        jLabel8.setText("REVISIÓN");

        jLabel9.setText("Frenos");

        jLabel10.setText("Aceite");

        jLabel11.setText("General");

        jLabel12.setText("Velocidad de crucero actual:");

        controlVelocidad.setText("AHORA MISMO MANTIENE UNA VELOCIDAD ADECUADA");

        botonRevisionGeneral.setText("REVISIÓN GENERAL");
        botonRevisionGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRevisionGeneralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rpm, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonEncender, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(222, 222, 222))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(controlVelocidad)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonPisarAcelerador)
                                        .addGap(32, 32, 32)
                                        .addComponent(botonFrenar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(botonParar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(botonMantener)
                        .addGap(274, 274, 274))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(combustible, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAniadirCombustible)
                .addGap(18, 18, 18)
                .addComponent(combustibleAniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(638, 638, 638)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAcelerar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(speedometer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(barraCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etiquetaPrincipal)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(revoluciones, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(distanciaReciente)
                                    .addComponent(distancia))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonCambiarAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCambiarPastillasFreno)
                            .addComponent(botonRevisionGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(168, 168, 168))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaVelocidadCrucero)
                .addGap(273, 273, 273))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(904, 904, 904)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(585, 585, 585)
                        .addComponent(aviso)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(revRevGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(revAceite, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(revPastillas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(102, 102, 102)))
                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(speedometer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(rpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(barraCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(combustible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel8)
                                        .addGap(4, 4, 4)
                                        .addComponent(revPastillas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(revAceite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(distanciaReciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(revRevGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(6, 6, 6)
                                                            .addComponent(jLabel9))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(26, 26, 26)
                                                            .addComponent(aviso)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel11))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(botonCambiarPastillasFreno)
                                .addGap(18, 18, 18)
                                .addComponent(botonCambiarAceite)
                                .addGap(18, 18, 18)
                                .addComponent(botonRevisionGeneral)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAniadirCombustible)
                            .addComponent(combustibleAniadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etiquetaPrincipal)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonAcelerar)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(controlVelocidad)
                                .addGap(3, 3, 3)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonParar)
                            .addComponent(botonMantener))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonReiniciar)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(etiquetaVelocidadCrucero)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(botonEncender)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonPisarAcelerador)
                            .addComponent(botonFrenar))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEncenderActionPerformed
        // Sepulsa si está en modo encendido (para apagar) o en modo apagado 
        // (para encender)
        
        if((estadoMotor == EstadoMotor.ENCENDIDO || estadoMotor == EstadoMotor.APAGADO) && modoManual)
            actualizarBotonEncender();
        else
            botonEncender.setSelected(!botonEncender.isSelected());
        
        // Avisamos al controlador para que cambie el estado del objetivo
        controlador.cambioEstadoMotor(estadoMotor);
    }//GEN-LAST:event_botonEncenderActionPerformed

    private void botonFrenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFrenarActionPerformed
        // Dependiendo de los casos en los que se pueda actualizar, actuamos
        // según corresponda
        if (((estadoMotor==EstadoMotor.ENCENDIDO || estadoMotor==EstadoMotor.FRENANDO) && modoManual) ||
            ((estadoSCACV==EstadoSCACV.REINICIAR || estadoSCACV==EstadoSCACV.ACELERAR
             || estadoSCACV==EstadoSCACV.MANTENER) &&!modoManual)){
            
            botonReiniciar.setSelected(false);
            botonAcelerar.setSelected(false);
            botonMantener.setSelected(false);
            botonParar.setSelected(true);

            if (estadoSCACV==EstadoSCACV.ACELERAR || estadoSCACV==EstadoSCACV.MANTENER){
                actualizarBotonParar();
                
                // Avisamos al controlador para que cambie el estado del objetivo
                controlador.cambioEstadoSCACV(estadoSCACV);
            }
            actualizarBotonFrenar();
        }
        else
            botonFrenar.setSelected(false);
        
        // Avisamos al controlador para que cambie el estado del objetivo
        controlador.cambioEstadoMotor(estadoMotor);
    }//GEN-LAST:event_botonFrenarActionPerformed

    private void combustibleAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combustibleAniadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combustibleAniadirActionPerformed

    private void botonCambiarAceiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarAceiteActionPerformed
        if (estadoMotor == EstadoMotor.APAGADO)
            controlador.cambiarAceite();
    }//GEN-LAST:event_botonCambiarAceiteActionPerformed

    private void botonCambiarPastillasFrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarPastillasFrenoActionPerformed
        if (estadoMotor == EstadoMotor.APAGADO)
            controlador.cambiarPastillasFrenos();
    }//GEN-LAST:event_botonCambiarPastillasFrenoActionPerformed

    private void botonAniadirCombustibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirCombustibleActionPerformed
        if (estadoMotor == EstadoMotor.APAGADO || !tieneCombustible)
            controlador.aniadirCombustible(combustibleAniadir.getText());
    }//GEN-LAST:event_botonAniadirCombustibleActionPerformed

    private void botonMantenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMantenerActionPerformed
       if (estadoSCACV == EstadoSCACV.ACELERAR){
            botonAcelerar.setSelected(false);
            actualizarBotonMantener();
        }else
            botonMantener.setSelected(!botonMantener.isSelected());
        
        // Avisamos al controlador para que cambie el estado del objetivo
        controlador.cambioEstadoSCACV(estadoSCACV);
    }//GEN-LAST:event_botonMantenerActionPerformed

    private void botonPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPararActionPerformed
        if (estadoSCACV == EstadoSCACV.ACELERAR || estadoSCACV == EstadoSCACV.MANTENER){
            botonAcelerar.setSelected(false);
            botonMantener.setSelected(false);
            
            actualizarBotonParar();
        }else
            botonParar.setSelected(!botonParar.isSelected());
        
        // Avisamos al controlador para que cambie el estado del objetivo
        controlador.cambioEstadoSCACV(estadoSCACV);
    }//GEN-LAST:event_botonPararActionPerformed

    private void botonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReiniciarActionPerformed
        if (estadoMotor == EstadoMotor.ENCENDIDO && modoManual && puedeReiniciar){
            botonParar.setSelected(false);
            actualizarBotonReiniciar();
        }else
            botonReiniciar.setSelected(!botonReiniciar.isSelected());
        
        controlador.cambioEstadoSCACV(estadoSCACV);
    }//GEN-LAST:event_botonReiniciarActionPerformed

    private void botonPisarAceleradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPisarAceleradorActionPerformed
        // Se puede pulsar si estamos en modo manual y está o encendido o acelerando
        // (este último para deseleccionar)
        
        if (((estadoMotor==EstadoMotor.ENCENDIDO || estadoMotor==EstadoMotor.ACELERANDO) 
            && modoManual) || (estadoSCACV==EstadoSCACV.REINICIAR && !modoManual))
                actualizarBotonPisarAcelerador();
        else
            botonAcelerar.setSelected(false);
        
        // Avisamos al controlador para que cambie el estado del objetivo
        controlador.cambioEstadoMotor(estadoMotor);
    }//GEN-LAST:event_botonPisarAceleradorActionPerformed

    private void botonAcelerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAcelerarActionPerformed
        if (estadoMotor == EstadoMotor.ACELERANDO){
            botonPisarAcelerador.setSelected(false);
            botonParar.setSelected(false);
            
            actualizarBotonPisarAcelerador();
            actualizarBotonAcelerar();
        }else
            botonAcelerar.setSelected(!botonAcelerar.isSelected());
        
        controlador.cambioEstadoSCACV(estadoSCACV);
    }//GEN-LAST:event_botonAcelerarActionPerformed

    private void velocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_velocidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_velocidadActionPerformed

    private void rpmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rpmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rpmActionPerformed

    private void revolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revolucionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_revolucionesActionPerformed

    private void botonRevisionGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRevisionGeneralActionPerformed
        if (estadoMotor == EstadoMotor.APAGADO)
            controlador.revisionGeneral();
    }//GEN-LAST:event_botonRevisionGeneralActionPerformed

    // *************************************************************************
    // MÉTODOS CONSULTORES:
    // *************************************************************************
    
    public JLabel getEtiquetaVelocidadCrucero() {
        return etiquetaVelocidadCrucero;
    }
    public JLabel getEtiquetaPrincipal() {
        return etiquetaPrincipal;
    }
    
    public EstadoMotor getEstadoMotor() {
        return estadoMotor;
    }

    public boolean puedeReiniciar(){
        return puedeReiniciar;
    }

    public JToggleButton getBotonEncender() {
        return botonEncender;
    }
    public JToggleButton getBotonMantener() {
        return botonMantener;
    }
    public JToggleButton getBotonParar() {
        return botonParar;
    }
    public JToggleButton getBotonReiniciar() {
        return botonReiniciar;
    }
    
    public JTextField getVelocidad() {
        return velocidad;
    }
    
    public JTextField getDistanciaReciente() {
        return distanciaReciente;
    }
    
    public JTextField getDistancia() {
        return distancia;
    }
    
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
    
    public JTextField getCombustible() {
        return combustible;
    }
    
    public JTextField getCombustibleAniadir() {
        return combustibleAniadir;
    }
    
    public Speedometer getSpeedometer() {
        return speedometer;
    }
    
    public JProgressBar getBarraCombustible(){
        return barraCombustible;
    }
    
    
    // *************************************************************************
    // MÉTODOS MODIFICADORES:
    // *************************************************************************
    
    
    public void setControlador(Controlador c){
        controlador = c;
    }
    
    public void setEtiquetaVelocidadCrucero(JLabel etiquetaVelocidadCrucero) {
        this.etiquetaVelocidadCrucero = etiquetaVelocidadCrucero;
    }
    public void setMensajeAviso(String s){
        aviso.setText(s);
    }

    public void setTieneCombustible(boolean tieneCombustible) {
        this.tieneCombustible = tieneCombustible;
    }
    
    public void setEstadoMotor(EstadoMotor estadoMotor) {
        this.estadoMotor = estadoMotor;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aviso;
    private javax.swing.JProgressBar barraCombustible;
    private javax.swing.JToggleButton botonAcelerar;
    private javax.swing.JButton botonAniadirCombustible;
    private javax.swing.JButton botonCambiarAceite;
    private javax.swing.JButton botonCambiarPastillasFreno;
    private javax.swing.JToggleButton botonEncender;
    private javax.swing.JToggleButton botonFrenar;
    private javax.swing.JToggleButton botonMantener;
    private javax.swing.JToggleButton botonParar;
    private javax.swing.JToggleButton botonPisarAcelerador;
    private javax.swing.JToggleButton botonReiniciar;
    private javax.swing.JButton botonRevisionGeneral;
    private javax.swing.JTextField combustible;
    private javax.swing.JTextField combustibleAniadir;
    private javax.swing.JLabel controlVelocidad;
    private javax.swing.JTextField distancia;
    private javax.swing.JTextField distanciaReciente;
    private javax.swing.JLabel etiquetaPrincipal;
    private javax.swing.JLabel etiquetaVelocidadCrucero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField revAceite;
    private javax.swing.JTextField revPastillas;
    private javax.swing.JTextField revRevGeneral;
    private javax.swing.JTextField revoluciones;
    private javax.swing.JTextField rpm;
    private p2.Speedometer speedometer;
    private javax.swing.JTextField velocidad;
    // End of variables declaration//GEN-END:variables


}
