/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dibujo;

import java.awt.geom.Point2D;

/**
 *  Clase para dibujar Puntos heredada de la clase {@link UserShape}
 * @author Angel
 */
public class UserPunto extends LineaAbstract{
    
   
    public UserPunto(Point2D p1,Point2D p2){
        super(p1, p1);
    }
    
    @Override
    public void setLocation(Point2D pos) {
        super.setLine(pos.getX(), pos.getY(), pos.getX() + 1, pos.getY() + 1);
    }

    @Override
    public void update(Point2D p1, Point2D p2) {
        setLine(p1, p1);
    }
    
}
