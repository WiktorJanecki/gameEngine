package game.shapes;

import renderEngine.model;
import renderEngine.texture;

public class rectangle {
    texture texture;
    model model;
    int x,y;
    int width,height;
    boolean isTextured;
    float[] vertices;
    float[] txtVertices;
    int[] indices;
    public rectangle(int x, int y, int width, int height,String path) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        texture = new texture(path);
        isTextured = true;
        txtVertices = new float[]{
                0,0,
                0,1,
                1,1,
                1,0
        };
        indices = new int[]{
                0,1,3,
                3,1,2
        };
        refreshModel();
        model = new model(vertices,txtVertices,indices);
    }

    public void setX(int x) {
        this.x = x;
        refreshModel();
        model = new model(vertices,txtVertices,indices);
    }

    public void setY(int y) {
        this.y = y;
        refreshModel();
        model = new model(vertices,txtVertices,indices);
    }

    public void render(){
        if(isTextured){
            texture.bind();
            model.render();
        }else{
            model.render();
        }
    }
    private void refreshModel(){
        vertices = new float[]{
                this.x,this.y+height,0,
                this.x,this.y,0,
                this.x+width,this.y,0,
                this.x+width,this.y+height,0,
        };
    }
}
