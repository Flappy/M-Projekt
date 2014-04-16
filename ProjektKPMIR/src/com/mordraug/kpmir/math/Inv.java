package com.mordraug.kpmir.math;

public class Inv extends MathElement{
	MathElement var;
	
	public Inv(MathElement var){
		this.var=var;
	}

	@Override
	public double value() {
		return 0-var.value();
	}

	@Override
	public String string() {
		if(var.string().startsWith("-")){
			return "(-("+var.string()+"))";
		}else{
			return "(-"+var.string()+")";
		}
	}

}
