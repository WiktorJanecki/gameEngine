package renderEngine;

import static org.lwjgl.opengl.GL11.glTranslatef;

public class camera {
    private int x,y;
    public camera()
    {
        x = 0;
        y = 0;
    }
    public void use(){glTranslatef(x,y,0);}
    public void move(int x, int y){this.x = x;this.y = y;}

    //public int getX(){return x;}
    //public int getY(){return y;}

    //public void setX(int x) {this.x = x;}
    //public void setY(int y) {this.y = y;}
}
