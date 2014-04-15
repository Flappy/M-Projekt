package com.mordraug.kpmir.math;

public abstract class Trygonometric extends MathElement {
	protected MathElement arg;
	
	public Trygonometric(MathElement a){
		arg=a;
	}
	
	public void setArg(MathElement a){
		arg=a;
	}
	
	public MathElement getArg(){
		return arg;
	}
}
