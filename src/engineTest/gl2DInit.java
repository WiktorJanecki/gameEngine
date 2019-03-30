package engineTest;

import static org.lwjgl.opengl.GL11.*;

class gl2DInit {
    gl2DInit(int width , int height){
        glViewport(0,0,width,height);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, 0, height, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
    }
}
