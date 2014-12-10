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
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Angel
 */
public class UserTrazoLibre extends GeneralPath.Float implements UserShape{
    private Color ColorTrazo;
    private Color ColorRelleno;
    private GradientPaint gradiente;
    private Stroke stroke;
    private float width;
    private boolean isRelleno;
    private boolean isContinuo;
    private boolean isGradiente;

    public UserTrazoLibre() {
    }
    
    
    
    
    public UserTrazoLibre(Color ColorTrazo, Color ColorRelleno, GradientPaint gradiente, float width, boolean isRelleno, boolean isContinuo) {
        super();
        this.ColorTrazo = ColorTrazo;
        this.ColorRelleno = ColorRelleno;
        this.gradiente = gradiente;
        this.width = width;
        this.isRelleno = isRelleno;
        this.isContinuo = isContinuo;
        
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
    public boolean isContained(Point2D p) {
        if(contains(p)){
            return true;
        }else return false; 
    }

    @Override
    public void setLocation(Point2D pos) {
        Rectangle2D area = getBounds2D();
        area.setFrame(pos.getX(), pos.getY(), area.getWidth(), area.getHeight());
    }

    @Override
    public void update(Point2D p1, Point2D p2) {
        this.lineTo(p2.getX(), p2.getY());
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if(isContinuo){
            stroke=new BasicStroke(width);
            g2d.setStroke(stroke);
        }else{
            stroke= new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, UserShape.discontinua, 0.0f);
            g2d.setStroke(stroke);
        }
        g2d.setPaint(ColorTrazo);
        g2d.draw(this);
        if(isRelleno){
            g2d.setPaint(ColorRelleno);
            g2d.draw(this);
        }else if(isGradiente){
            g2d.setPaint(gradiente);
            g2d.draw(this);
        }
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
    public boolean isGradiente() {
        return isGradiente;
    }

    @Override
    public void setisGradiente(boolean gr) {
        this.isGradiente=gr;
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
