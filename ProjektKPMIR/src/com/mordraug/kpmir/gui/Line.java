package com.mordraug.kpmir.gui;

import javax.media.opengl.GL2;

public class Line extends DrawableElement {

	@Override
	public void draw(GL2 gl){
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(0f, 0f, 0f);
		gl.glVertex3f(1f, 0f, 0f);
		gl.glEnd();
	}
}
