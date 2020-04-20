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
                    setSize(1200, 600);
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

        aviso = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botonMantener = new javax.swing.JToggleButton();
        botonAcelerar = new javax.swing.JToggleButton();
        botonParar = new javax.swing.JToggleButton();
        botonReiniciar = new javax.swing.JToggleButton();
        jLabel12 = new javax.swing.JLabel();
        etiquetaVelocidadCrucero = new javax.swing.JLabel();
        botonRevisionGeneral = new javax.swing.JButton();
        botonCambiarAceite = new javax.swing.JButton();
        botonCambiarPastillasFreno = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        revRevGeneral = new javax.swing.JTextField();
        revAceite = new javax.swing.JTextField();
        revPastillas = new javax.swing.JTextField();
        botonFrenar = new javax.swing.JToggleButton();
        controlVelocidad = new javax.swing.JLabel();
        revoluciones = new javax.swing.JTextField();
        distanciaReciente = new javax.swing.JTextField();
        distancia = new javax.swing.JTextField();
        botonEncender = new javax.swing.JToggleButton();
        botonPisarAcelerador = new javax.swing.JToggleButton();
        etiquetaPrincipal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combustible = new javax.swing.JTextField();
        barraCombustible = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        combustibleAniadir = new javax.swing.JTextField();
        botonAniadirCombustible = new javax.swing.JButton();
        rpm = new javax.swing.JTextField();
        speedometer = new p2.Speedometer();
        velocidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        botonMantener.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        botonMantener.setText("Mantener");
        botonMantener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMantenerActionPerformed(evt);
            }
        });

        botonAcelerar.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        botonAcelerar.setText("Acelerar");
        botonAcelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAcelerarActionPerformed(evt);
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

        jLabel12.setText("Velocidad de crucero actual:");

        etiquetaVelocidadCrucero.setText("NO DETERMINADA");

        botonRevisionGeneral.setText("REVISIÓN GENERAL");
        botonRevisionGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRevisionGeneralActionPerformed(evt);
            }
        });

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

        jLabel11.setText("General");

        jLabel10.setText("Aceite");

        jLabel9.setText("Frenos");

        jLabel8.setText("REVISIÓN");

        revRevGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revRevGeneralActionPerformed(evt);
            }
        });

        botonFrenar.setText("PISAR FRENO");
        botonFrenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFrenarActionPerformed(evt);
            }
        });

        controlVelocidad.setText("AHORA MISMO MANTIENE UNA VELOCIDAD ADECUADA");

        revoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revolucionesActionPerformed(evt);
            }
        });

        botonEncender.setForeground(new java.awt.Color(51, 204, 0));
        botonEncender.setText("ENCENDER");
        botonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncenderActionPerformed(evt);
            }
        });

        botonPisarAcelerador.setText("PISAR ACELERADOR");
        botonPisarAcelerador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPisarAceleradorActionPerformed(evt);
            }
        });

        etiquetaPrincipal.setForeground(new java.awt.Color(255, 0, 0));
        etiquetaPrincipal.setText("APAGADO");

        jLabel4.setText("CUENTA-KILÓMETROS");

        jLabel5.setText("km acumulados");

        jLabel6.setText("km actual");

        jLabel7.setText("Revoluciones totales");

        jLabel1.setText("COMBUSTIBLE");

        combustibleAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combustibleAniadirActionPerformed(evt);
            }
        });

        botonAniadirCombustible.setText("AÑADIR COMBUSTIBLE");
        botonAniadirCombustible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirCombustibleActionPerformed(evt);
            }
        });

        rpm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rpmActionPerformed(evt);
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

        jLabel2.setText("RPM's");

        jLabel3.setText("km/h");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 115, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(etiquetaVelocidadCrucero)
                                .addGap(539, 539, 539))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(118, 118, 118)
                                        .addComponent(jLabel4)
                                        .addGap(206, 206, 206)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addComponent(controlVelocidad)
                                                .addGap(95, 95, 95))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(botonParar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(115, 115, 115)))
                                        .addComponent(botonMantener)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(257, 257, 257)
                                .addComponent(botonEncender, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(botonPisarAcelerador, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonFrenar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rpm, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(combustible, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(botonAniadirCombustible)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combustibleAniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(271, 271, 271)
                                .addComponent(etiquetaPrincipal))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(speedometer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)
                                .addComponent(barraCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(distanciaReciente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(distancia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(revPastillas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(revAceite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(revRevGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(botonCambiarAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(botonCambiarPastillasFreno)
                                                    .addComponent(botonRevisionGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 44, Short.MAX_VALUE)))))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonAcelerar, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(botonReiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(440, 440, 440))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(speedometer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(rpm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(barraCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(combustible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAniadirCombustible)
                            .addComponent(combustibleAniadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etiquetaPrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(controlVelocidad)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(etiquetaVelocidadCrucero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(botonEncender))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(revPastillas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(distancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(distanciaReciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(revAceite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(revoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(revRevGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCambiarPastillasFreno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonCambiarAceite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonRevisionGeneral)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAcelerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonParar)
                        .addComponent(botonMantener)
                        .addComponent(botonFrenar))
                    .addComponent(botonPisarAcelerador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonReiniciar)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(585, 585, 585)
                .addComponent(aviso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(aviso))
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

    private void revRevGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revRevGeneralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_revRevGeneralActionPerformed

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField revAceite;
    private javax.swing.JTextField revPastillas;
    private javax.swing.JTextField revRevGeneral;
    private javax.swing.JTextField revoluciones;
    private javax.swing.JTextField rpm;
    private p2.Speedometer speedometer;
    private javax.swing.JTextField velocidad;
    // End of variables declaration//GEN-END:variables


}
