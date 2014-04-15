package com.mordraug.kpmir.math;

import com.mordraug.kpmir.Main;

public class Sub extends Arithmetic {

	public Sub(MathElement arg1, MathElement arg2) {
		super(arg1, arg2);
	}

	@Override
	public double value() {
		return arg1.value() - arg2.value();
	}

	@Override
	public String string() {
		if (Main.shorten) {
			if (arg2.value() == 0) {
				return arg1.string();
			}
		}
		return arg1.string() + "-" + arg2.string();
	}

}
