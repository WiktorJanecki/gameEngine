package engineTest;

import renderEngine.tile;
import renderEngine.windowManager;

import java.util.concurrent.atomic.AtomicLong;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glTranslatef;


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

        gl2DInit init = new gl2DInit(1280,720);
        tileID tid = new tileID();
        player player = new player();

        //
        //LOADING ALL ASSETS
        //



        tile[][] tile = new tile[15][8];
        tile[0][0] = new tile (tid.getFilename(1),0,0);
        tile[1][1] = new tile (tid.getFilename(0),1,1);

        while(!glfwWindowShouldClose(windowManager.getWindow()))
        {


            //logic

                //fps counter
                fpsCount++;
                fpsStop = System.currentTimeMillis();
                if(fpsStop- fpsStart.get() >1000)
                {
                    fpsStart.set(System.currentTimeMillis());
                    glfwSetWindowTitle(windowManager.getWindow(),(TITLE + SPACE + "Version : " + VERSION + SPACE + "FPS : " + "" + fpsCount));
                    fpsCount=0;
                }
                //fps counter


            //event

                //close window
                glfwPollEvents();
                player.move(windowManager.getWindow());
            //render

                glClear(GL_COLOR_BUFFER_BIT);

                //
                // RENDER IMAGES HERE
                //

                 tile[0][0].bind();
                 tile[1][1].bind();
            glPushMatrix();//ZAPISUJE POZYCJE PO RUSZENIU
            glLoadIdentity();//ZERUJE POZYCJE
            player.render();//ROBI OBRAZKI NA WYZEROWANEJ POZYCJI
            glPopMatrix();//WCZYTUJE POZYCJE PO RUSZENIU I OD NOWA
            glfwSwapBuffers(windowManager.getWindow());
        }
        windowManager.windowDelete();
    }
}
