package com.mordraug.kpmir.dh;

import com.mordraug.kpmir.Main;
import com.mordraug.kpmir.math.Cos;
import com.mordraug.kpmir.math.Degree;
import com.mordraug.kpmir.math.Inv;
import com.mordraug.kpmir.math.MathElement;
import com.mordraug.kpmir.math.MathVar;
import com.mordraug.kpmir.math.Matrix;
import com.mordraug.kpmir.math.Sin;
import com.mordraug.kpmir.math.Sum;

public class Joint {
	MathVar theta,d,a,alfa,trans;
	int type;
	
	public Joint(double theta,double d,double a,double alfa,int type){
		if(Main.radians){
			this.theta=new MathVar("theta", Math.toRadians(theta));
			this.alfa=new MathVar("alfa", Math.toRadians(alfa));
		}else{
			this.theta=new Degree(theta);
			this.alfa=new Degree(alfa);
		}
		this.d=new MathVar("d", d);
		this.a=new MathVar("a", a);
		
		this.type=type;
		this.trans=new MathVar("trans",0,true);
	}
	
	public void setIndex(int i){
		this.theta.setName("theta"+i);
		this.d.setName("d"+i);
		this.a.setName("a"+i);
		this.alfa.setName("alfa"+i);
	}
	
	public void setTrans(double var){
		trans.setVar(var);
	}
	public void setTransName(String name){
		trans.setName(name);
	}
	
	public MathElement[][] tZ(){
		if(type==0){
		MathElement[][] matrix = {{new Cos(theta), new Inv(new Sin(theta)), new MathVar(0), new MathVar(0)},
				{new Sin(theta), new Cos(theta), new MathVar(0), new MathVar(0)},
				{new MathVar(0), new MathVar(0), new MathVar(1), new Sum(d, trans)},
				{new MathVar(0), new MathVar(0), new MathVar(0), new MathVar(1)}};
		return matrix;
		}else if(type==1){
			MathElement[][] matrix = {{new Cos(new Sum(theta,trans)), new Inv(new Sin(new Sum(theta,trans))), new MathVar(0), new MathVar(0)},
					{new Sin(new Sum(theta,trans)), new Cos(new Sum(theta,trans)), new MathVar(0), new MathVar(0)},
					{new MathVar(0), new MathVar(0), new MathVar(1), d},
					{new MathVar(0), new MathVar(0), new MathVar(0), new MathVar(1)}};
			return matrix;
		}else{
			return null;
		}
	}
	
	public MathElement[][] tX(){
		MathElement[][] matrix = {{new MathVar(1), new MathVar(0), new MathVar(0), a},
				{new MathVar(0), new Cos(alfa), new Inv(new Sin(alfa)), new MathVar(0)},
				{new MathVar(0), new Sin(alfa), new Cos(alfa), new MathVar(0)},
				{new MathVar(0), new MathVar(0), new MathVar(0), new MathVar(1)}};
		return matrix;
	}
	
	public MathElement[][] getTransMatrix(){
		return Matrix.multiply(tZ(), tX());
	}

}
