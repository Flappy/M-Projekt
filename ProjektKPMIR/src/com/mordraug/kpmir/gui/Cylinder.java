package com.mordraug.kpmir.gui;

import java.nio.FloatBuffer;
import java.util.Arrays;

import com.jogamp.common.nio.Buffers;

public class Cylinder extends DrawableElement {

	public Cylinder(int segments, double height) {
		quads = true;
		v_array = new double[segments * 2][3];
		i_array = new int[4 * segments];
		for (int i = 0; i < segments; i++) {
			double angle = (Math.PI*2)/segments*i;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			v_array[i*2][0]=x;
			v_array[i*2][1]=y;
			v_array[i*2][2]=0;
			v_array[i*2+1][0]=x;
			v_array[i*2+1][1]=y;
			v_array[i*2+1][2]=height;
			i_array[i*4]=i*2;
			i_array[i*4+1]=i*2+1;
			i_array[i*4+2]=i*2+3;
			i_array[i*4+3]=i*2+2;
		}
		i_array[segments*4-1]=0;
		i_array[segments*4-2]=1;
		v_buff = Buffers.newDirectDoubleBuffer(v_array.length*3);
		for(double[] v : v_array){
			v_buff.put(v[0]);
			v_buff.put(v[1]);
			v_buff.put(v[2]);
		}
		i_buff = Buffers.newDirectIntBuffer(i_array);
		v_buff.rewind();
		i_buff.rewind();
	}
	
}
