package com.mordraug.kpmir.gui;

import com.jogamp.common.nio.Buffers;

public class Plane extends DrawableElement {
	public Plane() {
		v_array=new double[4][3];
		i_array=new int[4];
		
		v_array[0][0] = 0;
		v_array[0][1] = 0;
		v_array[0][2] = 0;
		v_array[1][0] = 1;
		v_array[1][1] = 0;
		v_array[1][2] = 0;
		v_array[2][0] = 1;
		v_array[2][1] = 1;
		v_array[2][2] = 0;
		v_array[3][0] = 0;
		v_array[3][1] = 1;
		v_array[3][2] = 0;

		i_array[0] = 0;
		i_array[1] = 1;
		i_array[2] = 2;
		i_array[3] = 3;
		v_buff = Buffers.newDirectDoubleBuffer(12);
		i_buff = Buffers.newDirectIntBuffer(i_array);
		for (double v[] : v_array) {
			v_buff.put(v[0]);
			v_buff.put(v[1]);
			v_buff.put(v[2]);
		}
		v_buff.rewind();
	}
}
