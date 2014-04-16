package com.mordraug.kpmir.math;

public abstract class Arithmetic extends MathElement {
	protected MathElement arg1,arg2;
	public Arithmetic(MathElement arg1, MathElement arg2){
		this.arg1=arg1;
		this.arg2=arg2;
	}
}
