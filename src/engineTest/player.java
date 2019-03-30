package engineTest;

import renderEngine.camera;
import renderEngine.model;
import renderEngine.texture;

import java.io.IOException;

import static org.lwjgl.glfw.GLFW.*;

class player {
    private int x , y ;
    private texture texture;
    private float[] vertices = new float[]{
            600,440,0,       //top left
            680,440,0,       //top right
            680,280,0,       //bottom right

            680,280,0,       //bottom right
            600,280,0,       //bottom left
            600,440,0,       //top left

    };

    private float[] txtVertices = new float[]{
            0,0,
            1,0,
            1,1,

            1,1,
            0,1,
            0,0
    };
    private model model  = new model(vertices,txtVertices);
    private camera camera = new camera();
    public player(){
        try{
            texture = new texture("./res/tilesTXT/man.png");
        }catch (NullPointerException e)
        {
            System.out.println("Can't load Player texture!");
            System.exit(1);
        }
    }

    //public void update(){}
    void move(long window){
        //W

        if(glfwGetKey(window, GLFW_KEY_W ) == GLFW_TRUE){
            y = y - 10;
            camera.move(x,y);
            camera.use();
            y = 0;
        }

        //S
        if(glfwGetKey(window, GLFW_KEY_S ) == GLFW_TRUE){
            y = y +10;
            camera.move(x,y);
            camera.use();
            y = 0;
        }

        //A
        if(glfwGetKey(window, GLFW_KEY_A ) == GLFW_TRUE){
            x = x +10;
            camera.move(x,y);
            camera.use();
            x = 0;
        }

        //D
        if(glfwGetKey(window, GLFW_KEY_D ) == GLFW_TRUE){
            x = x -10;
            camera.move(x,y);
            camera.use();
            x = 0;
        }

    }

    void render() {texture.bind();model.render();}


    //public int getX() {return x;}
    //public int getY() {return y;}
}
