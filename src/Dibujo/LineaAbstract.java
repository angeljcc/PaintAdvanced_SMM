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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *Clase abstracta para poder realizar despues las lineas y los puntos
 * 
 * @author Angel
 */
abstract class LineaAbstract extends Line2D.Double implements UserShape{
    private Color ColorTrazo;
    private Color ColorRelleno;
    private GradientPaint gradiente;
    private Stroke stroke;
    private float width;
    private boolean isRelleno;
    private boolean isContinuo;
    private boolean isGradiente;

    /**
     * Constructor por defecto de la clase 
     */
    public LineaAbstract() {
        super();
        this.ColorRelleno=Color.BLACK;
        ColorRelleno=null;
        this.width=1.0F;
        isRelleno=false;
        isContinuo=true;
        isGradiente=false;
    }
    
    /**
     * constructor por parametros de la clase
     * @param p1    Punto uno de la clase
     * @param p2    Punto dos de la clase
     */
    protected LineaAbstract(Point2D p1,Point2D p2){
        super(p1,p2);
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
    
    private boolean isNear(Point2D p) {
        return this.ptLineDist(p) <= 2.0;
    }
    
    @Override
    public boolean isContained(Point2D p) {
        return isNear(p);
    }

    @Override
    abstract public void setLocation(Point2D pos);

    @Override
    abstract public void update(Point2D p1, Point2D p2);

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if(isContinuo){
            stroke = new BasicStroke(width);
            g2d.setStroke(stroke);
        }else{
            stroke = new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, discontinua, 0.0f);
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
}
