package com.mordraug.kpmir.gui;

import javax.media.opengl.GL2;

public class Line extends DrawableElement {
	
	public Line(double length){
		this.length=length;
		this.height=0;
		this.width=0;
	}

	@Override
	public void draw(GL2 gl){
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex3f(0f, 0f, 0f);
		gl.glVertex3f((float)length, 0f, 0f);
		gl.glEnd();
	}
}
