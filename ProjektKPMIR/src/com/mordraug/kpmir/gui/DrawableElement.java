package com.mordraug.kpmir.gui;

import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class DrawableElement {
	public double[][] v_array;
	public int[] i_array;
	public DoubleBuffer v_buff;
	public IntBuffer i_buff;
	
	public void draw(GL2 gl2){
		gl2.glVertexPointer(3, GL2.GL_DOUBLE, 0, v_buff);
		gl2.glEnableClientState(GL2.GL_VERTEX_ARRAY);
		gl2.glDrawElements(GL2.GL_QUADS, i_array.length, GL.GL_UNSIGNED_INT, i_buff);
		gl2.glDisableClientState(GL2.GL_VERTEX_ARRAY);
	}
}
