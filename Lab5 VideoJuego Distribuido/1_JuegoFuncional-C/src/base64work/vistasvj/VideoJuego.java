/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base64work.vistasvj;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import base64work.principalvj.MiVentana;
import base64work.principalvj.Main;
import base64work.subpanelesvj.Panel_VJ;

/**
 *
 * @author Jorge
 */
public class VideoJuego extends javax.swing.JPanel {

     // Variables
    private MiVentana ventana = null;
    private Thread hiloG;
    private Panel_VJ panelVJ;
    private int keyCodePressed = 0;
    
    // Función para cambiar el codigo de tecla
    public void setKeyCodePressed(int keyC) {
        this.keyCodePressed = keyC;
    }
    
    /**
     * Creates new form VideoJuego
     */
    public VideoJuego() {
        initComponents();
    }

    public VideoJuego(MiVentana vtn) {
        initComponents();
        this.ventana = vtn;
        // Ajustes de ventana
        this.jPanelVJ.setSize(800, 560);
        Dimension dim = this.jPanelVJ.getSize();
        // Crear canvas        
        this.panelVJ = new Panel_VJ(dim.width, dim.height, Main.CONSTANT_BG, Main.CONSTANT_SP);
        this.panelVJ.setVisible(true);
        this.jPanelVJ.add(this.panelVJ);
        this.jPanelVJ.setVisible(true);
        // -------------------------------------
        // -------------------------------------
        // Crear e iniciar nuevo hilo
        this.hiloG = new Thread(){
            // Proceso secuncario
            public void run(){
                while (true) {
                    try {
                        Thread.sleep(10);
                        windowsPanelUpdate();
                    } catch (Exception e) {
                        Logger.getLogger(VideoJuego.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }
        };
        this.hiloG.start();
        // -------------------------------------
        // -------------------------------------
    }
    
    // Función de actualización
    public void windowsPanelUpdate() {
        // Validar
        if (keyCodePressed == 0) {
            // Cancelar movimiento
            panelVJ.player_cancelMov();
        } else {
            // Cambiar movimiento
            if (keyCodePressed == 37) {
                panelVJ.player_movToLeft();
            } else {
                panelVJ.player_movToRight();
            }
        }
        // Actualizar canvas
        this.panelVJ.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanelVJ = new javax.swing.JPanel();

        jButton1.setText("Cerrar cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanelVJ.setFocusCycleRoot(true);
        jPanelVJ.setFocusTraversalPolicyProvider(true);

        javax.swing.GroupLayout jPanelVJLayout = new javax.swing.GroupLayout(jPanelVJ);
        jPanelVJ.setLayout(jPanelVJLayout);
        jPanelVJLayout.setHorizontalGroup(
            jPanelVJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelVJLayout.setVerticalGroup(
            jPanelVJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(693, Short.MAX_VALUE))
            .addComponent(jPanelVJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelVJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.ventana != null) {
            this.ventana.endGameView();
            this.keyCodePressed = 0;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanelVJ;
    // End of variables declaration//GEN-END:variables
}