/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbasico2d;

import java.awt.image.BufferedImage;

/**
 *
 * @author Angel
 */
public class RestaOp extends sm.image.BinaryOp{
    
    public RestaOp(BufferedImage i){
        super(i);
    }

    @Override
    public int binaryOp(int i, int i1) {
        int b = Math.abs(i-i1);
        return clampRange(b, 0, 255);
    }
}
