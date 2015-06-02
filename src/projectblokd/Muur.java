package projectblokd;

import java.awt.Color;

public class Muur extends Item {

    public boolean kanKapot;

    public Muur(int xco, int yco) {
        super(xco, yco);
        color = Color.BLACK;
    }

}
