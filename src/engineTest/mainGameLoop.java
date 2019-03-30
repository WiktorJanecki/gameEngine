package engineTest;

import renderEngine.windowManager;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;


public class mainGameLoop {

    private int fpsCount;



    public static void main(String[] args) {
        System.out.println("Game started successfully!");
        new mainGameLoop();

    }
    private mainGameLoop()
    {
        long fpsStart = System.currentTimeMillis() , fpsStop;

 
        //Loading
        windowManager windowManager = new windowManager();
        windowManager.windowCreate("Engine Test",1280,720);
        glfwSwapInterval(1);

        glEnable(GL_TEXTURE_2D);


        while(!glfwWindowShouldClose(windowManager.getWindow()))
        {
            //logic
                fpsCount++;
                fpsStop = System.currentTimeMillis();
                if(fpsStop-fpsStart >1000)
                {
                    fpsStart = System.currentTimeMillis();
                    glfwSetWindowTitle(windowManager.getWindow(),"GameEngine Test     FPS : " +Integer.toString(fpsCount));
                    fpsCount=0;
                }








            //event
            glfwPollEvents();



            //render
            glClear(GL_COLOR_BUFFER_BIT);


            glfwSwapBuffers(windowManager.getWindow());
        }
        windowManager.windowDelete();
    }
}
