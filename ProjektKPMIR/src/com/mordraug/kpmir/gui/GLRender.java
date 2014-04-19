package com.mordraug.kpmir.gui;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

public class GLRender {

	protected static void setup(GL2 gl2, int width, int height) {
		gl2.glClearColor(1f, 1f, 1f, 0f);

		gl2.glMatrixMode(GL2.GL_PROJECTION);
		gl2.glLoadIdentity();

		// coordinate system origin at lower left with width and height same as
		// the window
		GLU glu = new GLU();
		gl2.glOrtho(0.0f, 10 * ((double) width / height), 0.0f, 10, -10, 10);

		gl2.glMatrixMode(GL2.GL_MODELVIEW);
		gl2.glLoadIdentity();

		gl2.glViewport(0, 0, width, height);
	}

	protected static void render(GL2 gl2, int width, int height,
			SceneManager scene) {
		gl2.glClear(GL.GL_COLOR_BUFFER_BIT);

		// Rysowanie obrysu - ustawienia
		gl2.glClearStencil(0);
		gl2.glClear(GL2.GL_STENCIL_BUFFER_BIT);
		gl2.glEnable(GL2.GL_STENCIL_TEST);
		gl2.glStencilFunc(GL2.GL_ALWAYS, 1, 0xFFFF);
		gl2.glStencilOp(GL2.GL_KEEP, GL2.GL_KEEP, GL2.GL_REPLACE);
		// Draw the object with thick lines
		gl2.glLineWidth(2.0f);
		gl2.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
		// Koniec kodu obrysu

		gl2.glColor3f(0, 0, 0);

		gl2.glLoadIdentity();
		scene.draw(gl2, width, height);
	}
}
