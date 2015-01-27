package org.usfirst.frc.team5428.robot.math;

import org.usfirst.frc.team5428.robot.core.C;

public final class MathUtil {
	
	private MathUtil(){
		C.out("Dont instantiate math class");
	}
	
	//TODO: still not right
	public static float trilerp(float a, float b, float c, float alpha){
		float alphaN = 0.5f * alpha + 0.5f;
		float lerpAB = (1 - alphaN) * a +  alphaN * b;
		float lerpBC = (1 - alphaN) * b +  alphaN * c;
		return (1 - alphaN) * lerpAB + lerpBC * alphaN;
	}
	
}
