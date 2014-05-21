/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbasico2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Angel
 */
public class Lienzo extends javax.swing.JPanel {

    
    
     private static int forma=5;
     private static Color color= new Color(0,0,0);
     private static boolean relleno = false;
     private static boolean editar = false;

    
     private Shape shape;
     private List<Shape> vectorShape= new ArrayList();
     private static Stroke stroke = new BasicStroke((float) 1.0);
     private Point2D puntoInicial;
     private Point2D p2=new Point(0,0);
     private BufferedImage img;

     public List<Shape> getVector(){
         return vectorShape;
     }
     
     
     
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
    }

    
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setPaint(color);
        g2d.setStroke(stroke);
        if(img!=null) g2d.drawImage(img,0,0,this); 

            for (Shape s : this.vectorShape) {
              if (relleno) g2d.fill(s);
              g2d.draw(s);
            }
    }
    
    public BufferedImage volcarImg(BufferedImage img){
        Graphics2D gd2 = img.createGraphics();
        gd2.setPaint(color);
        gd2.setStroke(stroke);
        for(Shape s: this.vectorShape){
            if (relleno) gd2.fill(s);
              gd2.draw(s);
        }
        return img;
    }
    //Para cambiar la opcion del boton
    public static void SetForma(int f){
        forma=f;
    }

    /**
     *
     * @param color1
     */
    public static void SetColor(Color color1){
       color = color1;
    }
    
    public static void SetRelleno(boolean b){
        relleno = b;
    }
    
    public static void SetStroke(Stroke s){
        stroke = s;
    }
    
    public static void SetEditar(boolean edi){
        editar = edi;
    }
    
    public void setImage(BufferedImage image){
        img=image;
        setPreferredSize(new Dimension(img.getWidth(),img.getHeight())); 
    }
    public BufferedImage getImage(){
        return img;
    }
    
    public Shape createShape(int forma, Point2D P1,Point2D P2){
        if((P1==null) || (P2 == null) && (forma!=0)) return null;
        switch(forma){
            case 0:
                return this.shape = new Line2D.Double(P1, P1);
                
            case 1:
                return this.shape = new Line2D.Double(P1, P2);
                
            case 2:
                this.shape = new Rectangle2D.Double();
                ((RectangularShape)this.shape).setFrameFromDiagonal(P1, P2);
                return this.shape;
            
            case 3:
                this.shape = new Ellipse2D.Double();
                ((RectangularShape)this.shape).setFrameFromDiagonal(P1, P2);
                return this.shape;
        }
        return this.shape=null;
    }
    
    public void updateShape(int forma,Point2D p1,Point2D p2){
         if((p1==null) || (p2 == null) && (forma!=0)) return ;
        switch(forma){
            case 0:
                ((Line2D)this.shape).setLine(p1, p1);
                break;
            case 1:
                ((Line2D)this.shape).setLine(p1, p2);
                break;                
                        
            case 2:
            case 3:
                ((RectangularShape)this.shape).setFrameFromDiagonal(p1, p2);
                break;
        }
        
    }
    private boolean contains(Shape sh, Point2D p){
        if(sh instanceof Line2D) 
            return isNear((Line2D)sh, p);
        return shape.contains(p);
    }
    
    public Shape getSelectedShape(Point2D p){
        for(ListIterator it = this.vectorShape.listIterator(this.vectorShape.size());it.hasPrevious();){
            //System.out.println(it.previousIndex());
            if(contains(this.shape=(Shape)it.previous(), p)){
                return this.shape;
            }
        }
        return null;
        
    }
    
    private boolean isNear(Line2D line, Point2D p){  
        if (line.getP1().equals(line.getP2()))
            return line.getP1().distance(p)<=2.0;
        return line.ptLineDist(p)<=2.0; 
    } 
    private void setLocationLinea(Line2D linea,Point2D p){
        double dx=p.getX()-linea.getX1(); 
        double dy=p.getY()-linea.getY1();  
        Point2D newp2 = new Point2D.Double(linea.getX2()+dx,linea.getY2()+dy);    
        linea.setLine(p,newp2); 
    }
    private void setLocation(Shape shap, Point2D p){
        if((shap instanceof Line2D))
            setLocationLinea((Line2D)shap, p);
        if((shap instanceof RectangularShape)){
            RectangularShape R=(RectangularShape)shap;
            R.setFrame(p, new Dimension((int)R.getWidth(), (int)R.getHeight()));
            //R.setFrame((Rectangle2D)shap);
            //System.out.println("setLocation->RegularShape");
        }   
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

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

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        puntoInicial = evt.getPoint();
        double x,y;
        if(editar){
            this.shape = getSelectedShape(puntoInicial);
            if (this.shape != null) {
                if(this.shape instanceof Line2D){
                    x=((Line2D)this.shape).getX1();
                    y=((Line2D)this.shape).getY1();
                }else{
                    x=this.shape.getBounds2D().getX();
                    y=this.shape.getBounds2D().getY();
                }
                this.p2.setLocation(x - this.puntoInicial.getX(), y - this.puntoInicial.getY());
            }
        }else
            this.vectorShape.add(createShape(forma, puntoInicial, puntoInicial));
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
       // puntoFinal=evt.getPoint();
        //updateShape(forma,puntoInicial,puntoFinal);
        formMouseDragged(evt);
       // repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point2D puntoFinal=evt.getPoint();
        if(editar){
            if(this.shape!=null)
                setLocation(shape, new Point2D.Double(puntoFinal.getX()+this.p2.getX(), puntoFinal.getY()+this.p2.getY()));
        }else
            updateShape(forma,puntoInicial,puntoFinal);
        repaint();

        
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
