/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbasico2d;



import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;
import sm.image.ImageTools;
import sm.image.KernelProducer;


/**
 * Clase para realizar el efecto Fronteras de una imagen.
 * @author Angel
 */
public class SobelOp extends BufferedImageOpAdapter{
    @Override
    public BufferedImage filter(BufferedImage imgsrc, BufferedImage imgdest) {
        
        if(imgdest==null){
            imgdest=createCompatibleDestImage(imgsrc, null);
        }
        Kernel sobelx = KernelProducer.createKernel(5);
        Kernel sobely = KernelProducer.createKernel(6); //creamos los tipòs kernel 5 sobelX; 6 sobelY
        
        ConvolveOp convx=new ConvolveOp(sobelx);
        ConvolveOp convy=new ConvolveOp(sobely);    //creamos los tipos convolveop con el tipo kernelProducer sober
        
        BufferedImage imx=convx.filter(imgsrc,null);
        BufferedImage imy=convy.filter(imgsrc,null);    //aplicamos el filtro a la imagen.
        
        BufferedImagePixelIterator itx = new BufferedImagePixelIterator(imx);
        BufferedImagePixelIterator ity = new BufferedImagePixelIterator(imy);
        
        
        
        while(itx.hasNext()){       // y ahora vamos recorreindo pixel a pixel.
            BufferedImagePixelIterator.PixelData pixelX=itx.next();
            BufferedImagePixelIterator.PixelData pixelY=ity.next();
            
            int X,Y;
            X=Y=0;
            for(int i=0;i<pixelX.numSamples;i++){
                X=X+pixelX.sample[i];
                Y=Y+pixelY.sample[i];
            }
            int m = (int)Math.hypot(X,Y);  //Devuelve sqrt(x2 +y2)
            m = ImageTools.clampRange(m, 0, 255);  //truncamos el valor entre 0 y 255 si supera 255 se quedaria a 255
            Color C=new Color(m, m, m);
            imgdest.setRGB(pixelX.col,pixelX.row,C.getRGB());

        }
        return imgdest;
    }
    
    
}
