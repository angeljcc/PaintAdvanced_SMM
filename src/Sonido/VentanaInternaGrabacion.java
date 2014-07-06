/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Sonido;


import java.io.File;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import sm.sound.SMRecorder;
import sm.sound.SMSoundRecorder;


/**
 *
 * @author Angel
 */
public class VentanaInternaGrabacion extends javax.swing.JInternalFrame {
    SMSoundRecorder record;
    LineListener lineListener = new LineListener(){
        public void update(LineEvent event){
            if(event.getType()==LineEvent.Type.START){
                //jToggleButton_Play.setSelectedIcon(new javax.swing.ImageIcon("/iconos/PlayPressed_48x48.png"));
                
            }
            if(event.getType()==LineEvent.Type.STOP){
                //jToggleButton_STOP.setIcon(new javax.swing.ImageIcon("StopNormalRed_48x48.png"));
//                buttonGroup1.clearSelection();
            }
        }
    };
    /**
     * Creates new form VentanaInternaGrabacion
     */
    public VentanaInternaGrabacion(File f) {
        initComponents();
        record = new SMSoundRecorder(f);
        record.setLineListener(lineListener);
        buttonGroup1.clearSelection();
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
        jToggleButtonGrabar = new javax.swing.JToggleButton();
        jToggleButton_STOP = new javax.swing.JToggleButton();

        setClosable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RecordPressed_48x48.png"))); // NOI18N

        buttonGroup1.add(jToggleButtonGrabar);
        jToggleButtonGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RecordDisabled_48x48.png"))); // NOI18N
        jToggleButtonGrabar.setSelected(true);
        jToggleButtonGrabar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/RecordPressed_48x48.png"))); // NOI18N
        jToggleButtonGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonGrabarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jToggleButton_STOP);
        jToggleButton_STOP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/StopDisabled_48x48.png"))); // NOI18N
        jToggleButton_STOP.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/StopPessedBlue_48x48.png"))); // NOI18N
        jToggleButton_STOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_STOPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToggleButtonGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton_STOP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButtonGrabar)
                    .addComponent(jToggleButton_STOP))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton_STOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_STOPActionPerformed
        if(record!=null) record.stop();
        this.setTitle("Stop");
    }//GEN-LAST:event_jToggleButton_STOPActionPerformed

    private void jToggleButtonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonGrabarActionPerformed
        if(record!=null) record.record();
        this.setTitle("Grabando...");
    }//GEN-LAST:event_jToggleButtonGrabarActionPerformed

    
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton jToggleButtonGrabar;
    private javax.swing.JToggleButton jToggleButton_STOP;
    // End of variables declaration//GEN-END:variables
}
