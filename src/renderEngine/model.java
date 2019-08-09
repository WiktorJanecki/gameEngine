package renderEngine;

import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL15.*;

public class model {
    private int drawCount,vID,tID,iID;
    public model(float[] vertices,float[] textureVertices, int[] indices){
        drawCount = indices.length;

        IntBuffer indicesBuffer = BufferUtils.createIntBuffer(indices.length);
        indicesBuffer.put(indices);
        indicesBuffer.flip();

        vID = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vID);
        glBufferData(GL_ARRAY_BUFFER,createFBuffer(vertices),GL_STATIC_DRAW);

        tID = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,tID);
        glBufferData(GL_ARRAY_BUFFER,createFBuffer(textureVertices),GL_STATIC_DRAW);

        iID = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,iID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,indicesBuffer,GL_STATIC_DRAW);

        glBindBuffer(GL_ARRAY_BUFFER,0);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,0);
    }
    public void render(){
        glEnableClientState(GL_VERTEX_ARRAY);
        glEnableClientState(GL_TEXTURE_COORD_ARRAY);

        glBindBuffer(GL_ARRAY_BUFFER,vID);
        glVertexPointer(3,GL_FLOAT,0,0);

        glBindBuffer(GL_ARRAY_BUFFER,tID);
        glTexCoordPointer(2,GL_FLOAT,0,0);

        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,iID);
        glDrawElements(GL_TRIANGLES,drawCount,GL_UNSIGNED_INT,0);

        glBindBuffer(GL_ARRAY_BUFFER,0);
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,0);

        glDisableClientState(GL_VERTEX_ARRAY);
        glDisableClientState(GL_TEXTURE_COORD_ARRAY);
    }
    FloatBuffer createFBuffer(float[]data){
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }
}
