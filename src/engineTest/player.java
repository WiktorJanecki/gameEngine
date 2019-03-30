package engineTest;

import renderEngine.camera;
import renderEngine.model;
import renderEngine.texture;

import static org.lwjgl.glfw.GLFW.*;

public class player {
    public int x , y ;
    texture texture = new texture("./res/til/air.png");
    float[] vertices = new float[]{
            600,440,0,       //top left
            680,440,0,       //top right
            680,280,0,       //bottom right

            680,280,0,       //bottom right
            600,280,0,       //bottom left
            600,440,0,       //top left

    };

    float[] txtVertices = new float[]{
            0,0,
            1,0,
            1,1,

            1,1,
            0,1,
            0,0
    };
    model model  = new model(vertices,txtVertices);
    camera camera = new camera();

    public void update(){
    }
    public void move(long window){
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

    public void render() {
        texture.bind();
        model.render();
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
