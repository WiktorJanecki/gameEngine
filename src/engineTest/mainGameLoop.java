package engineTest;

import renderEngine.windowManager;
import tileEngine.tile;

import java.util.concurrent.atomic.AtomicLong;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;


public class mainGameLoop {

    private int fpsCount;

    private static final String TITLE = "ENGINE TEST";
    private static final String VERSION = "0.00";
    private static final String SPACE = "          ";



    public static void main(String[] args) {
        System.out.println("Game started successfully!");
        new mainGameLoop();


    }
    private mainGameLoop()
    {
        //Timers for fps counter
        var fpsStart = new AtomicLong(System.currentTimeMillis());
        long fpsStop;

        //Window
        windowManager windowManager = new windowManager();
        windowManager.windowCreate(TITLE,1280,720);
        glfwSwapInterval(1);

        //Gl for 2D&Pixels
        glViewport(0,0,1280,720);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, 1280, 0, 720, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);



        //
        //LOADING ALL ASSETS
        //



        tile[][] tile = new tile[15][8];
        tile[0][0] = new tile (1,0,0);
        tile[1][1] = new tile (1,1,1);






        while(!glfwWindowShouldClose(windowManager.getWindow()))
        {
            //logic

                //fps counter
                fpsCount++;
                fpsStop = System.currentTimeMillis();
                if(fpsStop- fpsStart.get() >1000)
                {
                    fpsStart.set(System.currentTimeMillis());
                    glfwSetWindowTitle(windowManager.getWindow(),(TITLE + SPACE +"Version : " + VERSION + SPACE + "FPS : " + "" + fpsCount));
                    fpsCount=0;
                }
                //fps counter


            //event

                //close window
                glfwPollEvents();



            //render

                glClear(GL_COLOR_BUFFER_BIT);

                //
                // RENDER IMAGES HERE
                //


               tile[0][0].bind();
               tile[1][1].bind();



            glfwSwapBuffers(windowManager.getWindow());
        }
        windowManager.windowDelete();
    }
}
