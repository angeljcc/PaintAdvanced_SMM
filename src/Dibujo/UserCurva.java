/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dibujo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import sun.awt.AWTAccessor;

/**
 * Clase heredada de {@link UserShape} para poder hacer curvas con puntos de control
 *
 * @author Angel
 */
public class UserCurva extends QuadCurve2D.Double implements UserShape{
    private Color color;
    private float width;
    private Point2D inicio, fin, control;
    private GradientPaint gr;
    private boolean isRelleno,isContinua,isGradiente;
    private Stroke stroke;  
    
    public UserCurva() {
    }

    
    
    
    public UserCurva(Color color, float width, Point2D inicio, Point2D fin, Point2D control, GradientPaint gr, boolean isRelleno, boolean isContinua) {
        super(inicio.getX(), inicio.getY(), control.getX(), control.getY(), fin.getX(), fin.getY());
        System.out.println(inicio.getX());
        System.out.println(inicio.getY());
        System.out.println(fin.getX());
        System.out.println(fin.getY());
        this.color = color;
        this.width = width;
        this.inicio = inicio;
        this.fin = fin;
        this.control = control;
        this.gr = gr;
        this.isRelleno = isRelleno;
        this.isContinua = isContinua;
        
    }

   
    
    
    public Point2D getInicio() {
        return inicio;
    }

    public void setInicio(Point2D inicio) {
        this.inicio = inicio;
    }

    public Point2D getFin() {
        return fin;
    }

    public void setFin(Point2D fin) {
        this.fin = fin;
    }

    public Point2D getControl() {
        return control;
    }

    public void setControl(Point2D control) {
        this.control = control;
    }
    
    
            

    /**
     * 
     * @param color un color {@code variable}
     */
    @Override
    public void setColorTrazo(Color color) {
        this.color = color;
    }

    @Override
    public Color getColorTrazo() {
        return color;
    }

    @Override
    public void setColorRelleno(Color color) {
        this.color=color;
    }

    @Override
    public Color getColorRelleno() {
        return color;
    }

    @Override
    public void setGradiente(GradientPaint gr) {
       this.gr=gr;
    }

    @Override
    public GradientPaint getGradiente() {
        return this.gr;
    }

    @Override
    public void setStroke(float w) {
        this.width = w;
    }

    @Override
    public float getStroke() {
        return width;
    }

    @Override
    public void setRelleno(boolean relleno) {
        this.isRelleno=relleno;
    }

    @Override
    public boolean isRelleno() {
        return isRelleno;
    }

    @Override
    public void setContinua(boolean c) {
       isContinua=c;
    }

    @Override
    public boolean isContinua() {
       return isContinua;
    }

    @Override
    public boolean isGradiente() {
       return isGradiente;
    }

    @Override
    public void setisGradiente(boolean gr) {
       isGradiente=gr;
    }

    @Override
    public void setisContinua(boolean con) {
       isContinua=con;
    }

    @Override
    public void setisRelleno(boolean rell) {
       isRelleno=rell;
    }

    @Override
    public boolean isContained(Point2D p) {
        return this.contains(p);
    }

    @Override
    public void setLocation(Point2D pos) {
        //inicio=pos;
        //this.setFrame(pos.getX(), pos.getY(), this.getWidth(), this.getHeight());
        Rectangle2D v = this.getBounds2D();
        v.setFrame(pos.getX(), pos.getY(), v.getWidth(), v.getHeight());
//        this.contains(pos);
       
    }

    @Override
    public void update(Point2D p1, Point2D p2) {
//       this.setInicio(p1);
//       this.setFin(p2);
        
        
        if(p1.equals(p2)){
            this.setControl(p2);
        }else{
            inicio=p1;
            fin=p2;
        }
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;
        
        if(isContinua){
            stroke=new BasicStroke(width);
            g2d.setStroke(stroke);
            
        }else{
            stroke= new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, UserShape.discontinua, 0.0f);
            g2d.setStroke(stroke);
        }
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        g2d.setColor(color);
       
        
        g2d.draw(this);
        
    }

   
   
    
}
