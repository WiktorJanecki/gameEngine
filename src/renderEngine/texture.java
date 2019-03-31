package renderEngine;

import org.lwjgl.BufferUtils;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.stb.STBImage.stbi_image_free;
import static org.lwjgl.stb.STBImage.stbi_load;

public class texture {

    private int id;

    public texture(String filename){


        int width2;
        int height2;

        IntBuffer width = BufferUtils.createIntBuffer(1);
        IntBuffer height = BufferUtils.createIntBuffer(1);
        IntBuffer comp = BufferUtils.createIntBuffer(1);

        try
        {
            ByteBuffer data = stbi_load(filename, width , height, comp , 4);
            id = glGenTextures();
            width2 = width.get();
            height2 = height.get();

            glBindTexture(GL_TEXTURE_2D, id);

            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width2, height2, 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
            stbi_image_free(data);
        }catch (NullPointerException e)
        {
            System.out.println("Can't load texture!");
            System.exit(1);
        }




    }
    public void bind() {glBindTexture(GL_TEXTURE_2D, id);
    }
}
