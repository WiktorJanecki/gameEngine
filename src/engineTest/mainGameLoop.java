package engineTest;

import renderEngine.tile;
import renderEngine.windowManager;
import worldEngine.worldFileReader;

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

        gl2DInit init = new gl2DInit(1280,720);
        tileID tid = new tileID();
        player player = new player();
        worldFileReader worldFileReader = new worldFileReader("test");
        tile[][] tile = new tile[20][20];

        //
        //LOADING ALL ASSETS
        //



        for(int i = 0; i < worldFileReader.getTileid()[0].length;i++)
        {
            for(int j= 0;j < worldFileReader.getTileid().length;j++)
            {
                tile[j][i] = new tile (tid.getFilename(worldFileReader.getTileid()[j][i]),j,i);
            }
        }
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
                //player move
                player.move(windowManager.getWindow());

            //render

                glClear(GL_COLOR_BUFFER_BIT);

                //
                // RENDER IMAGES HERE
                //

            for(int i = 0; i < worldFileReader.getTileid()[0].length;i++)
            {
                for(int j= 0;j < worldFileReader.getTileid().length;j++)
                {
                    tile[j][i].bind();
                }
            }
                glPushMatrix();     //ZAPISUJE POZYCJE PO RUSZENIU
                glLoadIdentity();   //ZERUJE POZYCJE
                player.render();    //ROBI OBRAZKI NA WYZEROWANEJ POZYCJI
                glPopMatrix();      //WCZYTUJE POZYCJE PO RUSZENIU I OD NOWA
                glfwSwapBuffers(windowManager.getWindow());
        }
        windowManager.windowDelete();
    }
}
