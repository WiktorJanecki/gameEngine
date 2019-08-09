package game;

import game.shapes.rectangle;
import inputEngine.keyboard;
import renderEngine.camera;
import renderEngine.model;
import renderEngine.texture;
import renderEngine.tile;

import static org.lwjgl.glfw.GLFW.*;

class player {
    private int x , y;
    rectangle rectangle = new rectangle(50,0,80,80,"./res/tilesTXT/man.png");
    keyboard keyboard = new keyboard();
    public playerCamera playerCamera = new playerCamera(1280,720);
    public player(){}

    //public void update(){}
    void move(long window){
        int speed = 10;
        if(keyboard.isKeyDown(window,GLFW_KEY_W)){ y+=speed; }
        if(keyboard.isKeyDown(window,GLFW_KEY_S)){ y-=speed; }
        if(keyboard.isKeyDown(window,GLFW_KEY_A)){ x-=speed; }
        if(keyboard.isKeyDown(window,GLFW_KEY_D)){ x+=speed; }
        if(keyboard.isKeyDown(window,GLFW_KEY_ESCAPE)){System.exit(0);}
        rectangle.setX(x);
        rectangle.setY(y);
        playerCamera.use(x,y);
    }

    void render() {rectangle.render();}
}
