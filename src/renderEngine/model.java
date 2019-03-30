package renderEngine;


import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL15.*;


public class model {
    private int draw_count , v_id , t_id;

    public model(float [] vertices , float[] txtvertices) {
        draw_count = vertices.length / 3;

        v_id = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, v_id);
        glBufferData(GL_ARRAY_BUFFER ,createBuffer(vertices), GL_STATIC_DRAW);

        t_id = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, t_id);
        glBufferData(GL_ARRAY_BUFFER,createBuffer(txtvertices), GL_STATIC_DRAW);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }
    public void render(){
        glEnableClientState(GL_VERTEX_ARRAY);
        glEnableClientState(GL_TEXTURE_COORD_ARRAY);

        glBindBuffer(GL_ARRAY_BUFFER, v_id);
        glVertexPointer(3,GL_FLOAT,0,0);

        glBindBuffer(GL_ARRAY_BUFFER, t_id);
        glTexCoordPointer(2,GL_FLOAT,0,0);

        glDrawArrays(GL_TRIANGLES,0,draw_count);

        glBindBuffer(GL_ARRAY_BUFFER, 0);

        glDisableClientState(GL_TEXTURE_COORD_ARRAY);
        glDisableClientState(GL_VERTEX_ARRAY);
    }
    private FloatBuffer createBuffer(float[] data) {
        FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
        buffer.put(data);
        buffer.flip();
        return buffer;
    }

}
