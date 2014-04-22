package com.mordraug.kpmir.gui;

import javax.media.opengl.GL2;

public class SceneProp {
	public DrawableElement drawable;
	private double[] position = new double[3];
	private double[] rotation = new double[3];
	
	public SceneProp(DrawableElement d){
		drawable = d;
	}
	
	public void setPos(double x, double y, double z){
		position[0]=x;
		position[1]=y;
		position[2]=z;
	}
	
	public void setRot(double x, double y, double z){
		rotation[0]=x;
		rotation[1]=y;
		rotation[2]=z;
	}
	
	public void draw(GL2 gl){
		gl.glPushMatrix();
		gl.glTranslated(position[0], position[1], position[2]);
		gl.glRotated(rotation[0], 1, 0, 0);
		gl.glRotated(rotation[1], 0, 1, 0);
		gl.glRotated(rotation[2], 0, 0, 1);
		drawable.draw(gl);
		gl.glPopMatrix();
	}
}
