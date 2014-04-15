package com.mordraug.kpmir.math;

public class Cos extends Trygonometric {

	public Cos(MathElement a) {
		super(a);
	}

	@Override
	public double value() {
		return (double)Math.round(Math.cos(arg.value())*1000000000)/1000000000;
	}

	@Override
	public String string() {
		return "cos("+arg.string()+")";
	}

}
