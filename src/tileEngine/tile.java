package tileEngine;

import renderEngine.model;
import renderEngine.texture;


import static org.lwjgl.opengl.GL11.*;

public class tile {


    private String filename;
    private int id, xid,yid;
    private texture texture;
    private boolean isItAir = false;

    public tile (int id,int xid,int yid)
    {
        this.id = id;
        this.xid = xid;
        this.yid = yid;



        //
        //ALL TILES IDs
        //


        switch (this.id){
            case 0:
                isItAir = true;
                break;
            case 1:
                filename = "testTile.png";
                break;
        }



        if(!isItAir) {
            texture = new texture(filename);
        }
    }
    public void bind(){

        float[] vertices = new float[]{
                (xid +1) * 80 - 80,(yid+1)* 80     ,0,       //top left
                (xid +1) * 80     ,(yid+1)* 80     ,0,       //top right
                (xid +1) * 80     ,(yid+1)* 80 - 80,0,       //bottom right

                (xid +1) * 80     ,(yid+1)* 80 - 80,0,       //bottom right
                (xid +1) * 80 - 80,(yid+1)* 80 - 80,0,       //bottom left
                (xid +1) * 80 - 80,(yid+1)* 80     ,0,       //top left

        };

        float[] txtVertices = new float[]{
                0,0,
                1,0,
                1,1,

                1,1,
                0,1,
                0,0
        };

        model model = new model(vertices ,txtVertices);
        if(!isItAir) {
            texture.bind();
            model.render();

        }
    }







    //getters
    public int getID(){
        return id;

    }
    public int getXID(){
        return xid;

    }
    public int getYID(){
        return yid;

    }
    public String getFilename() {
        return filename;

    }

}
