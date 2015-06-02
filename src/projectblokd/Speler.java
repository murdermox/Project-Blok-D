package projectblokd;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Speler extends Item{
   
    public Speler(int x, int y){
        super(x,y);
        color = Color.PINK;
    }
    
    
    public boolean checkItem(){
        
        return true;
    }
    public void pakItem(){
        
    }
    public void gebruikItem(){
        
    }
    public boolean checkVriend(){
        
        return true;
    }

}
