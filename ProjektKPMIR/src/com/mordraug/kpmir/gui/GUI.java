package com.mordraug.kpmir.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	private final GLCanvas glcanvas;
	private final Frame frame;
	public SceneManager scene = new SceneManager();
	
	public GUI(){
		frame = new Frame("M-Project");

		GLProfile glprofile = GLProfile.getDefault();
        GLCapabilities glcapabilities = new GLCapabilities( glprofile );
		glcanvas = new GLCanvas(glcapabilities);
		glcanvas.addGLEventListener( new GLEventListener() {
            @Override
            public void reshape( GLAutoDrawable glautodrawable, int x, int y, int width, int height ) {
                GLRender.setup( glautodrawable.getGL().getGL2(), width, height );
            }
            
            @Override
            public void init( GLAutoDrawable glautodrawable ) {
            }
            
            @Override
            public void dispose( GLAutoDrawable glautodrawable ) {
            }
            
            @Override
            public void display( GLAutoDrawable glautodrawable ) {
                GLRender.render( glautodrawable.getGL().getGL2(), glautodrawable.getWidth(), glautodrawable.getHeight(), scene );
            }
        });
		
		frame.add(glcanvas);
		frame.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent windowevent ) {
                frame.remove( glcanvas );
                frame.dispose();
                System.exit( 0 );
            }
        });
		frame.setSize(640,480);
		frame.setVisible(true);
	}

}
