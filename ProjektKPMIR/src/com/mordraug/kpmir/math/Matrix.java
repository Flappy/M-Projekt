package com.mordraug.kpmir.math;

public class Matrix {
	public static MathElement[][] multiply(MathElement[][] m1,
			MathElement[][] m2) {
		if (m1[0].length == m2.length) {
			MathElement[][] output = new MathElement[m1.length][m2[0].length];
			for (int y = 0; y < m1.length; y++) {
				for (int x = 0; x < m2[0].length; x++) {
						output[y][x]=new MathVar(0);
					for (int i = 0; i < m2.length; i++) {
						output[y][x] = new Sum(output[y][x], new Mul(m1[y][i], m2[i][x]));
					}
				}
			}
			return output;
		} else {
			return null;
		}
	}
}
