package inputEngine;

import static org.lwjgl.glfw.GLFW.*;

public class keyboard {
    public boolean isKeyDown(long window,int key){
        if(glfwGetKey(window,key)== GLFW_TRUE){
            return true;
        }else{
            return false;
        }
    }
}
