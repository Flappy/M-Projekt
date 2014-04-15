package com.mordraug.kpmir.math;

public class Sum extends Arithmetic {

	public Sum(MathElement arg1, MathElement arg2) {
		super(arg1, arg2);
	}

	@Override
	public double value() {
		return arg1.value() + arg2.value();
	}

	@Override
	public String string() {
		return arg1.string() + "+" + arg2.string();
	}

}
