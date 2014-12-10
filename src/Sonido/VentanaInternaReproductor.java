/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sonido;
      
import java.io.File;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import sm.sound.SMClipPlayer;
import sm.sound.SMPlayer;

/**
 * Clase que nos  permite lanazar un dialogo para reproducir un sonido
 * @author Angel
 */
public class VentanaInternaReproductor extends javax.swing.JInternalFrame{
    
    SMClipPlayer player;
    LineListener lineListener = new LineListener(){
        /**
         * Actualiza el estado del listener
         * @param event Evento escuchador
         */
        public void update(LineEvent event){
            if(event.getType()==LineEvent.Type.START){
                //jToggleButton_Play.setSelectedIcon(new javax.swing.ImageIcon("/iconos/PlayPressed_48x48.png"));
                
            }
            if(event.getType()==LineEvent.Type.STOP){
                //jToggleButton_STOP.setIcon(new javax.swing.ImageIcon("StopNormalRed_48x48.png"));
                buttonGroup1.clearSelection();
            }
        }
    };
    /**
     * Creates new form VentanaInternaReproductor
     * Constructor por defecto que nos crea una ventana para repruducir audio
     * @param f archivo que se quiere reproducir.
     */
    public VentanaInternaReproductor(File f) {
        initComponents();
        player = new SMClipPlayer(f);
        player.setLineListener(lineListener);
   
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
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/PlayPressed_48x48.png"))); // NOI18N

        buttonGroup1.add(jToggleButton_Play);
        jToggleButton_Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/PlayDisabled_48x48.png"))); // NOI18N
        jToggleButton_Play.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToggleButton_Play.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/PlayPressed_48x48.png"))); // NOI18N
        jToggleButton_Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_PlayActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButton_STOP);
        jToggleButton_STOP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/StopDisabled_48x48.png"))); // NOI18N
        jToggleButton_STOP.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/StopNormalRed_48x48.png"))); // NOI18N
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
                .addComponent(jToggleButton_STOP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton_STOP)
                    .addComponent(jToggleButton_Play))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton_PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_PlayActionPerformed
       if(player!=null) player.play();
    }//GEN-LAST:event_jToggleButton_PlayActionPerformed

    private void jToggleButton_STOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_STOPActionPerformed
       if(player!=null) player.stop();
    }//GEN-LAST:event_jToggleButton_STOPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton jToggleButton_Play;
    private javax.swing.JToggleButton jToggleButton_STOP;
    // End of variables declaration//GEN-END:variables
}
