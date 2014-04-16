package com.mordraug.kpmir.math;

public class Ctg extends Trygonometric {

	public Ctg(MathElement a) {
		super(a);
	}

	@Override
	public double value() {
		return 1/Math.tan(arg.value());
	}

	@Override
	public String string() {
		return "ctg("+arg.string()+")";
	}

}
