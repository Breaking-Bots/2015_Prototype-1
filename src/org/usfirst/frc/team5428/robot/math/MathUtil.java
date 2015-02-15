package org.usfirst.frc.team5428.robot.math;

import org.usfirst.frc.team5428.robot.core.C;

public final class MathUtil {

	private MathUtil() {
		C.out("Dont instantiate math class");
	}

	// TODO: still not right
	public final static double trilerp(double a, double b, double c, double alpha) {
		double alphaN = 0.5f * alpha + 0.5f;
		double lerpAB = (1 - alphaN) * a + alphaN * b;
		double lerpBC = (1 - alphaN) * b + alphaN * c;
		return (1 - alphaN) * lerpAB + lerpBC * alphaN;
	}

	public final static double trilerpv2(double a, double b, double c, double alpha) {
		double alphaN = 0.5f * alpha + 0.5f;
		if (alpha > 0) {
			return alphaN * (b + c) / 2;
		} else if (alpha < 0) {
			return alphaN * (a + b) / 2;
		}

		return b;
	}
	
	public static final double normalizeAlpha(double alpha){
		return 0.5f * alpha + 0.5f;
	}
	
	public final static double zaeem(double a, double b, double c, double alpha){
//		double alphaN = 0.5f * alpha + 0.5f;
//		double alphaAB = alpha + 1;
//		double lerpAB = (1 - alphaAB) * a + alphaAB * b;
//		double lerpBC = (1 - alpha) * b + alpha * c;
//		return (1 - alphaN) * lerpAB + lerpBC * alphaN;
		
		return (alpha * ( a * (alpha - 1) + c * (alpha + 1)) - 2 * b * (alpha * alpha - 1)) * 0.5f;
	}
	
	public final static double lerp(double min, double max, double alpha) {
		return (1 - alpha) * min + alpha * max;
	}

	public final static double sam(double a, double b, double c, double alpha) {
		double alphaN = 0.5f * alpha + 0.5f;
		b += 0.0001f;
		
		double f = (a * a - 2 * a * b + b * b) / (a - 2 * b + c);
		double g = ((b * b - 2 * b * c + c * c) / (a * a - 2 * a * b + b * b));
		double k = (a * c - b * b) / (a - 2 * b + c);

		return f * Math.pow(g, alphaN) + k;
	}
	
	public final static boolean epsilonEquals(double a, double b, double epsilon){
		return (a - b) * (a - b) < (epsilon * epsilon);
	}
	
	public final static double hanzhenA(double theta0, double theta, double mgntd, double time){
		return (theta - theta0)/ (mgntd * time);
	}
	
	public final static double hanzhenR(double theta0, double theta, double mgntd, double time){
		return (theta - theta0)/ (mgntd * time);
	}
}
