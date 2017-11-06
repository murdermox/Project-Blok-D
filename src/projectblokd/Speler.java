package projectblokd;

public class Speler extends Item {

    private int x;
    private int y;

    public Speler(int x, int y) {
        this.x = x;
        this.y = y;
        imageString = getImageString();
    }

    public String getImageString() {
        if (Level.bullet == 0) {
            imageString = "src\\resources\\images\\Mario.png";
        } else {
            imageString = "src\\resources\\images\\PoweredUp.png";
        }
        return imageString;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int setX(int xco) {
        return x = xco;
    }

    @Override
    public int setY(int yco) {
        return y = yco;
    }
}
