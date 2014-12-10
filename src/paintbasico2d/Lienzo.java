/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbasico2d;


import Dibujo.UserCurva;
import Dibujo.UserEllipse;
import Dibujo.UserLinea;
import Dibujo.UserPunto;
import Dibujo.UserRectangulo;
import Dibujo.UserShape;
import Dibujo.UserTrazoLibre;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
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
 * Clase que crea una Ventana para poder dibujar todas las clases de figuras.
 * @author Angel
 */
public   class Lienzo extends javax.swing.JPanel {

    
    
     private   int forma=6;
     private int control=0;
     private  Color color= new Color(0,0,0);
     private Color colorTrazo= new Color(0,0,255);
     private GradientPaint gr;
    
     private  boolean relleno = false;
     private   boolean editar = false;
     private   boolean continua =true;
     private boolean isGradiente=false;
     
     private boolean crearCurva=false;
     
     private Shape shape;
     private UserShape shape2,editShape;
     private UserCurva curva;
     private  List<UserShape> vectorShape= new ArrayList();
     private   Stroke stroke = new BasicStroke((float) 1.0);
     private float strokeWidth;
     private Point2D puntoInicial,puntofinal,puntocurva,puntoI;
     private final Point2D p2=new Point(0,0);
     private BufferedImage img;

     public List<UserShape> getVector(){
         return vectorShape;
     }
     
     
     
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        
        
    }

    /**
     * Metodo que nos pinta la figura deseada
     * @param g Graphics que hay que pasarle al metodo para poder pintar
     */
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setPaint(color);
        g2d.setStroke(stroke);
        if(img!=null) g2d.drawImage(img,0,0,this); 

            for (UserShape s : this.vectorShape) {
              s.paint(g2d);
            }
            if(shape2!=null)shape2.paint(g2d);
            
    }
    /**
     * Vuelca una imagen desde el lienzo al
     * @param img
     * @return 
     */
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
    /**
     * Cambia la forma de la figura: PUnto, Linea, Rectagulo, Elipse o curva.
     * @param f entero entre 0 y 4 dependiendo de la figura que sea.
     */
    public   void SetForma(int f){
        forma=f;
    }
    
    /**
     * Devuelve el color del traazo
     * @return deuvuelve un tipo {@link Color}
     */
    public Color getColorTrazo() {
        return colorTrazo;
    }
    
    /**
     * Asigna un color al trazo
     * @param colorTrazo Se asigna un color al trazo de la figura.
     */
    public void setColorTrazo(Color colorTrazo) {
        this.colorTrazo = colorTrazo;
    }
    /**
     *  Asigna el color del relleno
     * @param color1 Tipo {@link Color}
     */
    public  void SetColor(Color color1){
       color = color1;
       
    }
    
    /**
     * asigna si es relleno o no
     * @param b boolean
     */
    public   void SetRelleno(boolean b){
        relleno = b;
        
    }
    
    /**
     * Asigna el grosor del trazo
     * @param s float
     */
    public   void SetStroke(float s){
        strokeWidth = s;
    }
    
    /**
     * Asiga si se puede editar
     * @param edi boolean
     */
    public   void SetEditar(boolean edi){
       editar = edi;
        
    }
    
            /**
             * Devuelve si se puede editar.
             * @return Boolean
             */
    public boolean getEditar(){
        return editar;
    }
    
    /**
     * Asiga un gradiente al relleno
     * @param gr GradientPaint
     */
    public void setGradiente(GradientPaint gr){
        //shape2.setGradiente(gr);
        this.gr=gr;
    }
    
    /**
     * Devuelve el obejeto tipo gradiente
     * @return GradientPaint
     */
    public GradientPaint getGradiente(){
        return shape2.getGradiente();
    }
    
    /**
     * Nos dice si se puede poner un gradiente
     * @return Boolean
     */
    public boolean getIsGradiente(){
        return shape2.isGradiente();
    }
    
    /**
     * Asigna si tiene gradiente el relleno
     * 
     * @param gr boolean
     */
    public void setIsGradiente(boolean gr){
        //shape2.setisGradiente(gr);
        this.isGradiente=gr;
    }
    
    /**
     * Asigna una imagen a lienzo
     * @param image BufferedImage
     */
    public void setImage(BufferedImage image){
        img=image;
        setPreferredSize(new Dimension(img.getWidth(),img.getHeight())); 
    }
    
    /**
     * Devuelve la imagen
     * @return BufferedImage img.
     */
    public BufferedImage getImage(){
        return img;
    }
    /**
     * Asigna si es continua o no el trazo
     * @param con boolean
     */
    public void setisContinua(boolean con){
        
        continua=con;
        
    }
    
    
    /**
     * Metodo para crear una forma
     * @param forma entero con la forma seleccionada
     * @param P1 Primer Punto del lienzo
     * @param P2 Segundo Punto del lienzo
     * @return Una forma
     */
    public Shape createShape(int forma, Point2D P1,Point2D P2){
        if((P1==null) || (P2 == null) && (forma!=0)) return null;
        switch(forma){
            case 0:
                this.shape2 = new UserPunto(P1, P1);
                shape2.setColorRelleno(color);
                shape2.setColorTrazo(colorTrazo);
                shape2.setRelleno(relleno);
                shape2.setContinua(continua);
                shape2.setStroke(strokeWidth);
                
                return this.shape2;
                
            case 1:
                this.shape2 = new UserLinea(P1, P2);
                shape2.setColorRelleno(color);
                shape2.setColorTrazo(colorTrazo);
                shape2.setRelleno(relleno);
                shape2.setContinua(continua);
                shape2.setStroke(strokeWidth);
                shape2.setisGradiente(isGradiente);
                return this.shape2;
                
            case 2:
                this.shape2 = new UserRectangulo();
                ((UserRectangulo)this.shape2).setFrameFromDiagonal(P1, P2);
                shape2.setColorRelleno(color);
                shape2.setColorTrazo(colorTrazo);
                shape2.setRelleno(relleno);
                shape2.setContinua(continua);
                shape2.setisGradiente(isGradiente);
                shape2.setStroke(strokeWidth);
                return this.shape2;
                
                //falta variable boolean para gradiente
            case 3:
                this.shape2=new UserEllipse();
                ((UserEllipse)this.shape2).setFrameFromDiagonal(P1, P2);
                shape2.setColorRelleno(color);
                shape2.setColorTrazo(colorTrazo);
                shape2.setGradiente(gr);
                shape2.setRelleno(relleno);
                shape2.setContinua(continua);
                shape2.setisGradiente(isGradiente);
                shape2.setStroke(strokeWidth);
                return this.shape2;
            case 4:
                 this.shape2=new UserCurva(color, strokeWidth, P1,P2, puntocurva, gr, relleno, continua);
//                ((UserCurva)this.shape2).setCurve(curva);
//                shape2.setColorRelleno(color);
//                shape2.setColorTrazo(colorTrazo);
//                shape2.setRelleno(relleno);
//                shape2.setContinua(continua);
//                shape2.setStroke(strokeWidth);
                return this.shape2;
            case 5:
                this.shape2=new UserTrazoLibre();
                ((UserTrazoLibre)this.shape2).moveTo(P1.getX(), P1.getY());
                shape2.setColorRelleno(color);
                shape2.setColorTrazo(colorTrazo);
                shape2.setGradiente(gr);
                shape2.setRelleno(relleno);
                shape2.setContinua(continua);
                shape2.setisGradiente(isGradiente);
                shape2.setStroke(strokeWidth);
                return this.shape2;
        }
        return this.shape2=null;
    }
    /**
     * Metodo para actualizar una forma
     * @param forma
     * @param p1
     * @param p2 
     */
    public void updateShape(int forma,Point2D p1,Point2D p2){
       // if (forma==4)curva.update(p1, p2);
        shape2.update(p1, p2);
    }
    /**
     * Devuelve una forma
     * @return UserShape
     */
    public UserShape getSelectedShape(){
        if(editShape != null){
            return this.editShape;
        }
        return null;
    }
    /**
     * devuelve la forma sseleccionada
     * @param p Point2D del puntero del raton
     * @return UserShape 
     */
    public UserShape getSelectedShape(Point2D p){
        for(UserShape s: vectorShape){
            if(s.isContained(p)){
                editShape=s;
                return s;
            }
        }
        return null;
        
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
            this.shape2 = getSelectedShape(evt.getPoint());
            if (this.shape2 != null) {
                if(this.shape2 instanceof UserLinea){
                    x=((UserLinea)this.shape2).getX1();
                    y=((UserLinea)this.shape2).getY1();
                }else{
                    x=this.shape2.getBounds2D().getX();
                    y=this.shape2.getBounds2D().getY();
                }
                this.p2.setLocation(x - this.puntoInicial.getX(), y - this.puntoInicial.getY());
            }
        }else{
            if(forma==4){
                crearCurva=true;
                //curva=new UserCurva();
                if(control==1){
                    System.out.println(control);
                    puntoI=evt.getPoint();
                    //curva.setInicio(puntoInicial);
                    control=2;
                    //vectorShape.add((UserShape)createShape(forma, puntoInicial, puntoInicial));
                    repaint();
                    
                }else if(control==3){
                    System.out.println(control);
                    //curva.setControl(evt.getPoint());
                    puntocurva=evt.getPoint();
                    
                    //shape2.update(puntocurva, puntocurva);
                    control=1;
                    vectorShape.add((UserShape)createShape(forma, puntoI, puntofinal));
                    crearCurva=false;
                    repaint();
                }
            }else{
                this.vectorShape.add((UserShape) createShape(forma, puntoInicial, puntoInicial));
            }
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
       // puntoFinal=evt.getPoint();
        //updateShape(forma,puntoInicial,puntoFinal);
        formMouseDragged(evt);
        if(crearCurva)control=3;
       // repaint();
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point2D puntoFinal=evt.getPoint();
//        if (forma==4){
//            curva.setControl(puntoFinal);
//            if(editar){
//                if(this.curva!=null)
//                    curva.setLocation( new Point2D.Double(puntoFinal.getX()+this.p2.getX(), puntoFinal.getY()+this.p2.getY()));
//            }else{
                    
//            }
//        }
        if(editar){
            if(this.shape2!=null)
                shape2.setLocation( new Point2D.Double(puntoFinal.getX()+this.p2.getX(), puntoFinal.getY()+this.p2.getY()));
            repaint();
        }else if(forma==4){
            if(control==2){
                    System.out.println(control);
                    puntofinal=evt.getPoint();
                    System.out.println("Dragged_____________________");
                    System.out.println(puntoI);
                    System.out.println(puntofinal);
                    //curva.setFin(evt.getPoint());
                    //control=3;
                    //shape2.update(puntoInicial, puntoFinal);
                    repaint();
            }
        }else{
            shape2.update(puntoInicial,puntoFinal);
        repaint();
        }

        
    }//GEN-LAST:event_formMouseDragged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public Point2D getPuntoInicial() {
        return puntoInicial;
    }

    public void setPuntoInicial(Point2D puntoInicial) {
        this.puntoInicial = puntoInicial;
    }

    public void setControl(int control) {
        this.control = control;
    }

    
}
