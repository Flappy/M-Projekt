package com.mordraug.kpmir.dh;

import java.util.ArrayList;

import com.mordraug.kpmir.math.MathElement;
import com.mordraug.kpmir.math.Matrix;

public class Manipulator {
	//private MathVar basex,basey,basez; //Do pozniejszej rozbudowy - uklad poczatkowy.
	private ArrayList<Joint> joints = new ArrayList<Joint>();
	
	public Manipulator(){
		
	}
	
	public void setTrans(int joint, double trans){
		joints.get(joint).setTrans(trans);
	}
	
	public void setTransName(int joint, String name){
		joints.get(joint).setTransName(name);
	}
	
	public void addJoint(Joint j){
		joints.add(j);
		j.setIndex(joints.indexOf(j)+1);
	}
	
	public void removeLast(){
		joints.remove(joints.size()-1);
	}
	
	public MathElement[][] getEffectorPos(){
		MathElement[][] output = new MathElement[4][4];
		for(Joint j: joints){
			if(output[0][0]==null)
				output=j.getTransMatrix();
			else
			output=Matrix.multiply(output, j.getTransMatrix());
		}
		return output;
	}

}
