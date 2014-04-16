package com.mordraug.kpmir;

import com.mordraug.kpmir.dh.Joint;
import com.mordraug.kpmir.dh.Manipulator;
import com.mordraug.kpmir.gui.GUI;
import com.mordraug.kpmir.math.MathElement;
import com.mordraug.kpmir.math.Shortener;

public class Main {
	public static boolean shorten = false;
	public static boolean radians = false;
	
	public static void main(String[] args){
		Manipulator manip = new Manipulator();
		manip.addJoint(new Joint(90,0.30,0,-90, 1));
		manip.addJoint(new Joint(0,0,5,0, 1));
		manip.addJoint(new Joint(0,0,5,0, 1));
		//manip.addJoint(new Joint(0,0,0,Math.toRadians(-90),1));
		//manip.addJoint(new Joint(0,0,0,0,1));
		manip.setTrans(0, Math.toRadians(1));
		manip.setTransName(0, "r1");
		manip.setTrans(1, Math.toRadians(1));
		manip.setTransName(1, "r2");
		manip.setTrans(2, Math.toRadians(1));
		manip.setTransName(2, "r3");
		/*manip.setTrans(3,Math.toRadians(1));
		manip.setTransName(3,"r4");
		manip.setTrans(4,Math.toRadians(1));
		manip.setTransName(4,"r5");*/
		
		MathElement[][] m=manip.getEffectorPos();
		//System.out.println(Math.cos(Math.toRadians(90)));
		//printMatrix(m,true);
		//MathElement[][] m1 = {{new MathVar(1),new MathVar(0),new MathVar(2)},{new MathVar(-1),new MathVar(3),new MathVar(1)}};
		//MathElement[][] m2 = {{new MathVar(3),new MathVar(1)},{new MathVar(2),new MathVar(1)},{new MathVar(1),new MathVar(0)}};
		//printMatrix(Matrix.multiply(m1,m2));
		new GUI();
	}
	
	public static void printMatrix(MathElement[][] matrix){
		printMatrix(matrix, false);
	}
	
	public static void printMatrix(MathElement[][] matrix, boolean eq){
		for(MathElement[] row : matrix){
			String r="";
			for(MathElement e : row){
				e=Shortener.shorten(e);
				if(eq)
					r+=e.string()+"="+(double)Math.round(e.value()*1000000)/1000000+"|";
				else
					r+=(double)Math.round(e.value()*1000000)/1000000+"|";
			}
			System.out.println(r);
		}
	}

}
