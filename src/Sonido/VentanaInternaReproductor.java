/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sonido;
      
import java.io.File;
import sm.sound.SMClipPlayer;
import sm.sound.SMPlayer;

/**
 *
 * @author Angel
 */
public class VentanaInternaReproductor extends javax.swing.JInternalFrame {
    
    SMPlayer player;
    /**
     * Creates new form VentanaInternaReproductor
     */
    public VentanaInternaReproductor(File f) {
        initComponents();
        player = new SMClipPlayer(f);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToggleButton_Play = new javax.swing.JToggleButton();
        jToggleButton_STOP = new javax.swing.JToggleButton();

        setClosable(true);

        buttonGroup1.add(jToggleButton_Play);
        jToggleButton_Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/PlayDisabled_48x48.png"))); // NOI18N
        jToggleButton_Play.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToggleButton_Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_PlayActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButton_STOP);
        jToggleButton_STOP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/StopNormalRed_48x48.png"))); // NOI18N
        jToggleButton_STOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_STOPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToggleButton_Play)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton_STOP))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jToggleButton_STOP)
                .addComponent(jToggleButton_Play))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton_PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_PlayActionPerformed
        if(player!=null)player.play();
    }//GEN-LAST:event_jToggleButton_PlayActionPerformed

    private void jToggleButton_STOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_STOPActionPerformed
        if(player!=null)player.stop();
        
    }//GEN-LAST:event_jToggleButton_STOPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton jToggleButton_Play;
    private javax.swing.JToggleButton jToggleButton_STOP;
    // End of variables declaration//GEN-END:variables
}
