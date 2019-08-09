package game;

import renderEngine.tile;
import renderEngine.windowManager;
import worldEngine.worldFileReader;

import java.util.concurrent.atomic.AtomicLong;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;


public class main {

    private int fpsCount;

    private static final String TITLE = "ENGINE TEST";
    private static final String VERSION = "0.00";
    private static final String SPACE = "          ";
    public int WIDTH = 1920;
    public int HEIGHT = 1080;



    public static void main(String[] args) {
        System.out.println("Game started successfully!");
        new main();
    }
    private main()
    {
        //Timers for fps counter
        long fpsStart = System.currentTimeMillis();
        long fpsStop;
        windowManager windowManager = new windowManager();
        windowManager.windowCreate(TITLE,WIDTH,HEIGHT);
        tileID tid = new tileID();
        player player = new player();
        player.playerCamera.setResolution(WIDTH,HEIGHT);
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
                if(fpsStop- fpsStart >1000)
                {
                    fpsStart = System.currentTimeMillis();
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
                for(int i = 0; i < worldFileReader.getTileid()[0].length;i++)
                {
                    for(int j= 0;j < worldFileReader.getTileid().length;j++)
                    {
                        tile[j][i].render();
                    }
                }
                player.render();

                glPushMatrix();     //ZAPISUJE POZYCJE PO RUSZENIU
                glLoadIdentity();   //ZERUJE POZYCJE
                //                  //ROBI OBRAZKI NA WYZEROWANEJ POZYCJI
                glPopMatrix();      //WCZYTUJE POZYCJE PO RUSZENIU I OD NOWA
                glfwSwapBuffers(windowManager.getWindow());
        }
        windowManager.windowDelete();
    }
}
