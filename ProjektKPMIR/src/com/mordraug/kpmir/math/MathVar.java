package com.mordraug.kpmir.math;

public class MathVar extends MathElement {
	private String name;
	protected double var;
	private boolean pres_name = false;
	
	public MathVar(double var){
		this.name=Double.toString(var);
		this.var=var;
	}
	
	public MathVar(String name, double var){
		this.name=name;
		this.var=var;
	}
	
	public MathVar(String name, double var, boolean p){
		this(name, var);
		pres_name=p;
	}
	
	public boolean preserve(){
		return pres_name;
	}
	
	public void setVar(double var){
		this.var=var;
	}
	
	public void setName(String name){
		this.name=name;
	}

	@Override
	public double value() {
		return var;
	}

	@Override
	public String string() {
		return name;
	}

}
