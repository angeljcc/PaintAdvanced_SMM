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
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *    Clase para dibujar Rectangulos heredada de la clase {@link UserShape}
 * @author Angel
 */
public class UserRectangulo extends Rectangle2D.Double implements UserShape{
    private Color ColorTrazo;
    private Color ColorRelleno;
    private GradientPaint gradiente;
    private Stroke stroke;
    private float width;
    private boolean isRelleno;
    private boolean isContinuo;
    private boolean isGradiente;
    
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
    
    /**
     * Devuelve el color del rectangulo
     * @return {@link Color} {@code ColorRelleno} 
     */
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
        return this.width;
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
        this.setFrame(pos.getX(), pos.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void update(Point2D p1, Point2D p2) {
        setFrameFromDiagonal(p1, p2);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d;
        g2d=(Graphics2D) g;
        if(isContinuo){
            stroke=new BasicStroke(width);
            g2d.setStroke(stroke);
            
        }else{
            stroke= new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, UserShape.discontinua, 0.0f);
            g2d.setStroke(stroke);
        }
        
        g2d.setPaint(ColorRelleno);
        g2d.draw(this);
        if(isRelleno){
            g2d.setPaint(ColorTrazo);
            g2d.fill(this);
        }
        if(isGradiente){
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
        isGradiente=con;
    }

    @Override
    public void setisRelleno(boolean rell) {
        isRelleno=rell;
    }
    
}
