/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dibujo;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 *  Interface de una figura para que cada instancia  tenga sus propiedades diferentes 
 * @author Angel
 */
public interface UserShape extends Shape{
    static final float discontinua[]={10.f};
    /**
     * Asigna el color del trazo
     * 
     * @param color El color de trazo 
     * 
     */
    void setColorTrazo(Color color);
    
    /**
     * Devuelve el color del trazo
     * @return El color de trazo
     */
    Color getColorTrazo();
    
    /**
     * Asigna el color de releno a la forma
     * 
     * @param color Color de relleno
     */
    void setColorRelleno(Color color);
    
    /**
     * Devuelve el color de relleno de la forma
     * 
     * @return El color de relleno
     */
    Color getColorRelleno();
    
    /**
     * asigna el gradiente a la forma
     * @param gr relleno de degradado
     */
    void setGradiente(GradientPaint gr);
    
    /**
     * devuelve el gradiente de la forma actual
     * @return degradado de la forma
     */
    GradientPaint getGradiente();
    
    /**
     * Asigna el grosor al trazo de la forma
     * @param w tamaño del trazo
     */
    void setStroke(float w);
    
    /**
     * Devuelve el tamaño del trazo de la forma
     * @return Tamaño del trazo.
     */
    float getStroke();
    
    /**
     * Metodo para asignar el relleno
     * @param relleno boolean que determina si está relleno o no la figura
     */
    void setRelleno(boolean relleno);
    
    /**
     * Devuelve si tiene relleno solido la figura
     * @return 
     */
    boolean isRelleno();
    
    /**
     * Asigna si el trazo es continuo o discontinuo.
     * @param c {@code    boolean} 
     */
    void setContinua(boolean c);
    
    /**
     * Devuelve si el trazo es continuo.
     * @return {@code boolean}
     */
    boolean isContinua();
    
    /**
     * devuelve si se pinta con gradiente
     * @return  {@code  boolean}
     */
    boolean isGradiente();
    /**
     * Metodo asigna que tiene gradiente la forma
     * @param gr boolean
     */
    void setisGradiente(boolean gr);
    
    /**
     * asigna que el trazo es continuo
     * @param con 
     */
    void setisContinua(boolean con);
    
    /**
     * asigna que la figura es rellena
     * @param rell 
     */
    void setisRelleno(boolean rell);
    
    /**
     * devuelve si la figura esta contenida en el {@link Point2D} pasado por parametro.
     * @param p {@code Point2D}
     * @return {@code boolean}
     */
    boolean isContained(Point2D p);
    
    /**
     * Metodo para mover la forma desde el evento del Raton
     * @param pos {@code Point2D} Para mover la forma.
     */
    void setLocation(Point2D pos);
    /**
     * metodo para actualizar la forma del dibujo.
     * @param p1 punto inicial
     * @param p2 punto final
     */
    void update(Point2D p1,Point2D p2);
    /**
     * Metodo para dibujar la forma con sus atributos correspondientes
     * @param g Graphics que dibuja la forma con sus corespondientes atributos.
     */
    void paint(Graphics g);
    
}
