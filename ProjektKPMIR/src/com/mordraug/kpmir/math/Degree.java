package com.mordraug.kpmir.math;

public class Degree extends MathVar {

	public Degree(double var) {
		super(var);
	}

	@Override
	public double value() {
		return Math.toRadians(var);
	}

	@Override
	public String string() {
		return var+"°";
	}

}
