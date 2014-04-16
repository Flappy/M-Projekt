package com.mordraug.kpmir.gui;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class GLRender {
	static Cylinder c;
	static Plane p;
	protected static void setup(GL2 gl2, int width, int height) {
		gl2.glClearColor(1f, 1f, 1f, 0f);
		
		gl2.glMatrixMode(GL2.GL_PROJECTION);
		gl2.glLoadIdentity();

		// coordinate system origin at lower left with width and height same as
		// the window
		GLU glu = new GLU();
		gl2.glOrtho(0.0f, 10*((double)width/height), 0.0f, 10, -10, 10);

		gl2.glMatrixMode(GL2.GL_MODELVIEW);
		gl2.glLoadIdentity();

		gl2.glViewport(0, 0, width, height);
		c=new Cylinder(12);
		p=new Plane();
	}

	protected static void render(GL2 gl2, int width, int height) {
		gl2.glClear(GL.GL_COLOR_BUFFER_BIT);
		
		gl2.glClearStencil(0);
		gl2.glClear( GL2.GL_STENCIL_BUFFER_BIT );
		gl2.glEnable( GL2.GL_STENCIL_TEST );
		gl2.glStencilFunc( GL2.GL_ALWAYS, 1, 0xFFFF );
		gl2.glStencilOp( GL2.GL_KEEP, GL2.GL_KEEP, GL2.GL_REPLACE );
		// Draw the object with thick lines
		gl2.glLineWidth( 3.0f );
		gl2.glPolygonMode( GL2.GL_FRONT_AND_BACK, GL2.GL_LINE );
		gl2.glColor3f( 0, 0, 0 );
		// draw a triangle filling the window
		gl2.glLoadIdentity();
		gl2.glTranslatef(5, 5, 0);
		gl2.glRotatef(45, 1, 1, 0);
		//gl2.glRotatef(90, 0, 0, 1);
		c.draw(gl2);
		/*gl2.glBegin(GL.GL_TRIANGLES);
		gl2.glVertex3f(0, 0, 0);
		gl2.glVertex3f(2, 0, 0);
		gl2.glVertex3f(1, 1, 0);
		gl2.glEnd();*/
	}
}
