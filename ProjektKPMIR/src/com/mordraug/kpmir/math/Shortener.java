package com.mordraug.kpmir.math;

public class Shortener {
	public static MathElement shorten(MathElement m) {
		if (m instanceof Sum) {
			((Sum) m).arg1 = shorten(((Sum) m).arg1);
			((Sum) m).arg2 = shorten(((Sum) m).arg2);
			if (((Sum) m).arg1.value() != 0 || ((Sum) m).arg2.value() != 0) {
				if (((Sum) m).arg1.value() == 0)
					m = ((Sum) m).arg2;
				else if (((Sum) m).arg2.value() == 0)
					m = ((Sum) m).arg1;
				else if (((Sum) m).arg1 instanceof MathVar
						&& ((Sum) m).arg2 instanceof MathVar) {
					if (!((MathVar) ((Sum) m).arg1).preserve()
							&& !((MathVar) ((Sum) m).arg2).preserve()) {
						m = new MathVar(m.value());
					}
				}
			} else {
				m = new MathVar(0);
			}
		} else if (m instanceof Mul) {
			((Mul) m).arg1 = shorten(((Mul) m).arg1);
			((Mul) m).arg2 = shorten(((Mul) m).arg2);
			if (((Mul) m).arg1.value() != 0 && ((Mul) m).arg2.value() != 0) {
				if (((Mul) m).arg1.value() == 1)
					m = ((Mul) m).arg2;
				else if (((Mul) m).arg2.value() == 1)
					m = ((Mul) m).arg1;
				else if (((Mul) m).arg1 instanceof MathVar
						&& ((Mul) m).arg2 instanceof MathVar
						&& !((MathVar) ((Mul) m).arg1).preserve()
						&& !((MathVar) ((Mul) m).arg2).preserve()) {
					m = new MathVar(m.value());
				}else if(((Mul) m).arg1 instanceof MathVar && ((Mul) m).arg1.value() == -1){
					m=new Inv(((Mul) m).arg2);
				}else if(((Mul) m).arg2 instanceof MathVar && ((Mul) m).arg2.value() == -1){
					m=new Inv(((Mul) m).arg1);
				}
			} else {
				m = new MathVar(0);
			}
		} else if (m instanceof MathVar) {
			if (!((MathVar) m).preserve() && !(m instanceof Degree))
				m = new MathVar(m.value());
		} else if (m instanceof Inv) {
			((Inv) m).var = shorten(((Inv) m).var);
			if (((Inv) m).var instanceof MathVar) {
				if (!((MathVar) ((Inv) m).var).preserve())
					m = new MathVar(m.value());
			}
		} else if (m instanceof Trygonometric) {
			((Trygonometric) m).arg = shorten(((Trygonometric) m).arg);
			if (((Trygonometric) m).arg instanceof MathVar) {
				if (!((MathVar) ((Trygonometric) m).arg).preserve()) {
					m = new MathVar(m.value());
				}
			}
		}
		return m;
	}

	public static boolean checkTryg(MathElement m) {
		if (m instanceof Trygonometric) {
			if (((Trygonometric) m).arg instanceof MathVar) {
				if (!((MathVar) ((Trygonometric) m).arg).preserve()) {
					return true;
				}
			}
		}
		return false;
	}
}
