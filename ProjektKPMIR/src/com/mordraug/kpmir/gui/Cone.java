package com.mordraug.kpmir.gui;

import com.jogamp.common.nio.Buffers;

public class Cone extends DrawableElement {
	
	public Cone(int segments, double height){
		v_array = new double[segments+1][3];
		i_array = new int[3*segments];
		v_array[0][0] = 0;
		v_array[0][1] = 0;
		v_array[0][2] = height;
		for (int i = 0; i < segments; i++) {
			double angle = (Math.PI*2)/segments*i;
			double x = Math.cos(angle);
			double y = Math.sin(angle);
			v_array[1+i][0]=x;
			v_array[1+i][1]=y;
			v_array[1+i][2]=0;
			i_array[i*3]=0;
			i_array[i*3+1]=i+1;
			i_array[i*3+2]=i+2;
		}
		i_array[segments*3-1]=1;
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
