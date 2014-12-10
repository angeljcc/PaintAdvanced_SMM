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
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 *  Clase para DIbujar Elipses heradada de {@link UserShape}
 * @author Angel
 */
public class UserEllipse extends Ellipse2D.Double implements UserShape{
    private Color ColorTrazo;
    private Color ColorRelleno;
    private GradientPaint gradiente;
    private Stroke stroke;
    private float width;
    private boolean isRelleno;
    private boolean isContinuo;
    private boolean isGradiente;
    
    public UserEllipse(){
        this.ColorRelleno=Color.BLACK;
        ColorRelleno=null;
        this.width=1.0F;
        isRelleno=false;
        isContinuo=true;
        isGradiente=false;
    }
    
    @Override
    public void setColorTrazo(Color color) {
        ColorTrazo=color;
    }

    @Override
    public Color getColorTrazo() {
        return ColorTrazo;
    }

    @Override
    public void setColorRelleno(Color color) {
        ColorRelleno=color;
    }

    @Override
    public Color getColorRelleno() {
        return ColorRelleno;
    }

    @Override
    public void setGradiente(GradientPaint gr) {
        gradiente=gr;
    }

    @Override
    public GradientPaint getGradiente() {
        return gradiente;
    }

    @Override
    public void setStroke(float w) {
        width=w;
    }

    @Override
    public float getStroke() {
        return width;
    }

    @Override
    public void setRelleno(boolean relleno) {
        isRelleno=relleno;
    }

    @Override
    public boolean isRelleno() {
        return isRelleno;
    }

    @Override
    public void setContinua(boolean c) {
        isContinuo=c;
    }

    @Override
    public boolean isContinua() {
        return isContinuo;
    }

    @Override
    public boolean isContained(Point2D p) {
        return this.contains(p);
    }

    @Override
    public void setLocation(Point2D pos) {
        setFrame(pos.getX(), pos.getY(), getWidth(), getHeight());
    }

    @Override
    public void update(Point2D p1, Point2D p2) {
        setFrameFromDiagonal(p1, p2);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;
        if(isContinuo){
            stroke= new BasicStroke(width);
            g2d.setStroke(stroke);
        }else{
            stroke=new BasicStroke(width,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,10.0f,UserShape.discontinua,0.0f);
            g2d.setStroke(stroke);  
        }
        g2d.setPaint(ColorRelleno);
        g2d.draw(this);
        if(isRelleno){
            g2d.setPaint(ColorTrazo);
            g2d.fill(this);
        }else if(isGradiente){
            g2d.setPaint(gradiente);
            g2d.fill(this);
        }
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
        isContinuo=con;
    }

    @Override
    public void setisRelleno(boolean rell) {
        isRelleno=rell;
    }
    
}
