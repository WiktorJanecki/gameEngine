package renderEngine;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

public class windowManager {

    private long window;

    public windowManager() {
        if(!glfwInit())
        {
            throw new IllegalStateException("Failed to initialize GLFW!");
        }
    }
    public void windowCreate(String windowTitle, int width, int height) {
        window = glfwCreateWindow(width,height,windowTitle,NULL,NULL);
        if(window == 0)
        {
            throw new IllegalStateException("Failed to create window");
        }
        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(window,(videoMode.width()-width)/2, (videoMode.height()-height)/2);
        glfwShowWindow(window);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();

    }
    public void windowDelete(){
        glfwTerminate();
        System.exit(0);
    }
    public long getWindow(){
        return window;

    }

}
