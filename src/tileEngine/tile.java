package tileEngine;

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

        if(!isItAir) {
            texture.bind();


            glBegin(GL_QUADS);

                glTexCoord2f(0, 0);
                glVertex2f((xid +1) * 80 - 80, (yid+1) * 80);

                glTexCoord2f(1, 0);
                glVertex2f((xid +1) * 80, (yid+1)* 80);

                glTexCoord2f(1, 1);
                glVertex2f((xid +1) * 80, (yid+1)* 80 - 80);

                glTexCoord2f(0, 1);
                glVertex2f((xid +1) * 80 - 80, (yid+1) * 80 - 80);

            glEnd();
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
