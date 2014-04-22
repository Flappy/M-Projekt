package com.mordraug.kpmir.gui;

import javax.media.opengl.GL2;

public class VerticalJoint extends SceneProp {

	public VerticalJoint(DrawableElement d) {
		super(d);
	}
	
	@Override
	public void draw(GL2 gl){
		gl.glPushMatrix();
		gl.glTranslated(0, this.drawable.height*2+0.1, 0);
		super.draw(gl);
		gl.glTranslated(0, -0.1, 0);
		gl.glRotated(180, 1, 0, 0);
		super.draw(gl);
		gl.glPopMatrix();
	}

}
