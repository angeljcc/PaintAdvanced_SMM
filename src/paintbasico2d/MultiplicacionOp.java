/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbasico2d;

import java.awt.image.BufferedImage;
import sm.image.BinaryOp;

/**
 *
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
