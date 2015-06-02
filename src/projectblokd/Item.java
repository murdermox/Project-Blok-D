package projectblokd;

import java.awt.Color;
import java.awt.Dimension;

public class Item {

    public Dimension locatie;
    public int x;
    public int y;
    public Color color = Color.GRAY;

    public Item(int xco, int yco) {
        x = xco;
        y = yco;
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
    
    public Color getColor() {
        return color;
    }

}
