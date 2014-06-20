/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbasico2d;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 *
 * @author Angel
 */
public class UmbralizacionOp extends sm.image.BufferedImageOpAdapter{
    private final int umbral;
    public UmbralizacionOp(int umbral){
        this.umbral=umbral;
    }
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
          if (dest == null) { 
            dest = createCompatibleDestImage(src, null); 
        } 
        WritableRaster srcRaster = src.getRaster(); 
        WritableRaster destRaster = dest.getRaster(); 
 
        for (sm.image.BufferedImageSampleIterator it = new sm.image.BufferedImageSampleIterator(src); it.hasNext();) { 
                    sm.image.BufferedImageSampleIterator.SampleData sample = it.next();  
                     if(sample.value>=umbral)sample.value = 255;
                     else if(sample.value<umbral)sample.value=0;
                    destRaster.setSample(sample.col, sample.row, sample.band, sample.value); 
                 
             
        }
        return dest; 
 
    }
    
    
    
}
