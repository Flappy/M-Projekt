package com.mordraug.kpmir.math;

public class Tg extends Trygonometric {

	public Tg(MathElement a) {
		super(a);
	}

	@Override
	public double value() {
		return Math.tan(arg.value());
	}

	@Override
	public String string() {
		return "tg("+arg.string()+")";
	}

}
