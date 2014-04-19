package com.mordraug.kpmir.gui;

import java.util.HashSet;

import javax.media.opengl.GL2;

public class SceneManager {
	private HashSet<SceneProp> props = new HashSet<SceneProp>();
	
	public void add(SceneProp prop){
		props.add(prop);
	}
	
	public void remove(SceneProp prop){
		props.remove(prop);
	}
	
	public void clear(){
		props.clear();
	}
	
	public void draw(GL2 gl, int width, int height){
		//gl.glTranslatef(5, 5, 0);
		for(SceneProp prop: props){
			prop.draw(gl);
		}
	}
}
