package com.mordraug.kpmir.dh;

import java.util.ArrayList;

import com.mordraug.kpmir.gui.Cone;
import com.mordraug.kpmir.gui.Cylinder;
import com.mordraug.kpmir.gui.Line;
import com.mordraug.kpmir.gui.SceneManager;
import com.mordraug.kpmir.gui.SceneProp;
import com.mordraug.kpmir.gui.VerticalJoint;
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
	
	public MathElement[][] getJointPos(int index){
		MathElement[][] output = new MathElement[4][4];
		for(int i = 0; i<index; i++){
			if(output[0][0]==null)
				output=joints.get(i).getTransMatrix();
			else
			output=Matrix.multiply(output, joints.get(i).getTransMatrix());
		}
		return output;
	}
	
	public SceneManager createScene(){
		SceneManager scene = new SceneManager();
		SceneProp base = new SceneProp(new Line(1));
		SceneProp first = new VerticalJoint(new Cone(15,1,0.5,0.5));
		base.setRot(0, 0, 90);
		first.setPos(0, base.drawable.height, 0);
		scene.add(base);
		scene.add(first);
		double offset_x=0;
		double offset_y=3.4;
		double offset_z=0;
		
		for(int i = 0; i < joints.size(); i++){
			double x = offset_x+joints.get(i).d.value();
			double y = offset_y;
			double z = offset_z;
			SceneProp j = new SceneProp(new Cylinder(15,1,0.3,0.3));
			SceneProp l = new SceneProp(new Line(1));
			l.setPos(offset_x, offset_y, offset_z);
			j.setRot(90, 0, 0);
			j.setPos(x, y, z);
			scene.add(j);
			scene.add(l);
			offset_x=x;
			offset_y=y;
			offset_z=z;
		}
		return scene;
	}

}
