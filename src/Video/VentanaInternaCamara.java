/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Video;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.media.Buffer;
import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.format.YUVFormat;
import javax.media.util.BufferToImage;

/**
 *  Clase que nos crea una ventana para ver la camara web
 * @author Angel
 */
public class VentanaInternaCamara extends javax.swing.JInternalFrame {
    private Player player;
    Component video;
    Component control;
    /**
     * Creates new form VentanaInternaCamara
     */
    public VentanaInternaCamara() {
        initComponents();
    }
   /**
    * Metodo que inicia la camara web
    */
    public void play(){
        try{
            
            String dName = "vfw://0";
        MediaLocator ml = new MediaLocator(dName);
        player = Manager.createRealizedPlayer(ml);
        Component areaVisual = player.getVisualComponent();
        if (areaVisual != null) {
            areaVisual.setBounds(20, 20, 600, 600);
            add(areaVisual);
            Component panelControl = player.getControlPanelComponent();
            if (panelControl != null) {
                add(panelControl,BorderLayout.SOUTH);
            }
            this.pack();
            
        }
        player.start();
        }catch(Exception e){
            
        }
    }
    
  
    /**
     * Dectructor de la clase
     */
    private void close(){
        if(player!= null){
            player.stop();
            player.deallocate();
        }
    }
    /**
     * Metodo que nos devuelve la instancia del Player
     * @return Devuelve un {@link Player} {@code player}
     */
    public Player getPlayer(){
        return this.player;
    }
    /**
     * Métodoo para capturar una imagen de una ventana tanto en reproducción
     * de vídeo como de una ventana webcam.
     * @return Imagen capturada.
     */
    public BufferedImage getFrame(){
        FrameGrabbingControl fgc;
        String claseCtr = "javax.media.control.FrameGrabbingControl";
        fgc = (FrameGrabbingControl)player.getControl(claseCtr );
        Buffer bufferFrame = fgc.grabFrame();
        BufferToImage bti;
        bti=new BufferToImage((VideoFormat)bufferFrame.getFormat());
        Image img = bti.createImage(bufferFrame);
        return (BufferedImage)img;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        player.close();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel;
    // End of variables declaration//GEN-END:variables
}
