package projectblokd;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Item {

    public Dimension locatie;
    public int x;
    public int y;
    public BufferedImage image;
    public static BufferedImage[][] imageArray;
    public String imageString;
    public JLabel label = new JLabel();
    
    public Item(int xco, int yco) {
        x = xco;
        y = yco;
    }
    
    public Item(){
        
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public int setX(int xco){
        return x = xco;
    }
    public int setY(int yco){
        return y = yco;
    }
    
    public static BufferedImage padImage;
    public static BufferedImage muurImage;
    
    public Image setImage(){
        if (this instanceof Pad) {
            if (padImage != null) {
                return padImage;
            }
            try{
               image = ImageIO.read(new File(imageString));
            } catch (IOException ex) {
               System.out.println(ex);
            }
            
            padImage = image;
            return image;
        }
        
         if (this instanceof Muur) {
            if (muurImage != null) {
                return muurImage;
            }
            try{
               image = ImageIO.read(new File(imageString));
            } catch (IOException ex) {
               System.out.println(ex);
            }
            
            muurImage = image;
            return image;
        }
         
        try{
            image = ImageIO.read(new File(imageString));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return image;
    }

}
