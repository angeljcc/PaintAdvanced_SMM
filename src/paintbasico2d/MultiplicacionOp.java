/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbasico2d;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
 * Clase para realizar la operacion multilicar de dos imagenes.
 * @author Angel
 */
public class MultiplicacionOp extends BinaryOp{

    public MultiplicacionOp(BufferedImage img) {
        super(img);
    }

    @Override
    public int binaryOp(int i, int i1) {
        return clampRange(i*i1, 0, 255);
    }
      
}
