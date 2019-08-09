package game;

import renderEngine.camera;

public class playerCamera {
    camera camera = new camera();
    int cameraX=0,cameraY =0;
    int width,height;
    playerCamera(int width, int height){
        this.width = width;
        this.height = height;
    }
    void use(int playerX,int playerY){
        if(playerX > cameraX + ((width/2) -40)) {
            cameraX += 10;
            camera.move(-10, 0);
            camera.use();
        }
        if(playerX < cameraX + ((width/2) -40)) {
            cameraX -= 10;
            camera.move(+10, 0);
            camera.use();
        }
        if(playerY > cameraY + ((height/2) -40)){
            cameraY+=10;
            camera.move(0,-10);
            camera.use();
        }
        if(playerY < cameraY + ((height/2) -40)){
            cameraY-=10;
            camera.move(0,10);
            camera.use();
        }
    }
    public void setResolution(int width, int height){
        this.width = width;
        this.height = height;
    }
}
