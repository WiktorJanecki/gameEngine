package renderEngine;

import renderEngine.model;
import renderEngine.texture;


public class tile {


    private String filename;
    private int xid,yid;
    private texture texture;
    public int tileSize = 80;
    public model model;


    public tile (String filename ,int xid,int yid)
    {
        this.filename = filename;
        this.xid = xid;
        this.yid = yid;
        texture = new texture(this.filename);
        float[] vertices = new float[]{
                (xid +1) * tileSize - tileSize, (yid+1)* tileSize           ,0,       //top left
                (xid +1) * tileSize - tileSize, (yid+1)* tileSize - tileSize,0,       //bottom left
                (xid +1) * tileSize           , (yid+1)* tileSize - tileSize,0,       //bottom right
                (xid +1) * tileSize           , (yid+1)* tileSize           ,0,       //top right
        };

        float[] txtVertices = new float[]{
                0,0,
                0,1,
                1,1,
                1,0
        };
        int[] indices = {
                0,1,3,//top left triangle (v0, v1, v3)
                3,1,2//bottom right triangle (v3, v1, v2)
        };
        model = new model(vertices ,txtVertices,indices);

    }
    public void render(){

            texture.bind();
            model.render();
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
    public void setTileSize(int tileSize){this.tileSize = tileSize;
    }

}
