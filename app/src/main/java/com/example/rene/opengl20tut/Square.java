package com.example.rene.opengl20tut;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Square {

    private float[] vertices =
            {
                    -1.0f, 1.0f, 0.0f, //0
                    -1.0f, -1.0f, 0.0f,  // 1
                    1.0f, -1.0f, 0.0f, //2
                    1.0f, 1.0f, 0.0f,  //3

            };
    private short[] indices = {0,1, 2, 0, 2, 3};
    private FloatBuffer vertexBuffer;
    private ShortBuffer indexBuffer;

    public Square()
    {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length *4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        ByteBuffer ibb = ByteBuffer.allocateDirect(vertices.length *4);
        ibb.order(ByteOrder.nativeOrder());
        indexBuffer = ibb.asShortBuffer();
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }

    public void draw(GL10 gl)
    {
        gl.glColor4f(0.5f, 0.5f, 0.5f, 1.0f);
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glCullFace(GL10.GL_BACK);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }
}