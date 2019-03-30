package tileEngine;

public class tile {


    public int id;
    public String filename;
    public int x,y;

    public tile (int id, String filename,int xpos,int ypos)
    {
        this.id = id;
        this.filename = filename;
        x = (xpos * 40 )-40;
        y = (ypos * 40)-40;
    }










    //getters
    public int getID(){
        return id;

    }
    public int getX(){
        return x;

    }
    public int getY(){
        return y;

    }
    public String getFilename() {
        return filename;

    }

}
