package org.usfirst.frc.team5428.robot.math;

import org.usfirst.frc.team5428.robot.core.C;

public final class MathUtil {

	private MathUtil() {
		C.out("Dont instantiate math class");
	}

	// TODO: still not right
	public static float trilerp(float a, float b, float c, float alpha) {
		float alphaN = 0.5f * alpha + 0.5f;
		float lerpAB = (1 - alphaN) * a + alphaN * b;
		float lerpBC = (1 - alphaN) * b + alphaN * c;
		return (1 - alphaN) * lerpAB + lerpBC * alphaN;
	}

	public static float trilerpv2(float a, float b, float c, float alpha) {
		float alphaN = 0.5f * alpha + 0.5f;
		if (alpha > 0) {
			return alphaN * (b + c) / 2;
		} else if (alpha < 0) {
			return alphaN * (a + b) / 2;
		}

		return b;
	}
	
	public static float zaeem(float a, float b, float c, float alpha){
//		float alphaN = 0.5f * alpha + 0.5f;
//		float alphaAB = alpha + 1;
//		float lerpAB = (1 - alphaAB) * a + alphaAB * b;
//		float lerpBC = (1 - alpha) * b + alpha * c;
//		return (1 - alphaN) * lerpAB + lerpBC * alphaN;
		
		return (alpha * ( a * (alpha - 1) + c * (alpha + 1)) - 2 * b * (alpha * alpha - 1)) * 0.5f;
	}

	public static float lerp(float min, float max, float alpha) {
		return (1 - alpha) * min + alpha * max;
	}

	public static float sam(float a, float b, float c, float alpha) {
		float alphaN = 0.5f * alpha + 0.5f;
		b += 0.0001f;
		
		float f = (a * a - 2 * a * b + b * b) / (a - 2 * b + c);
		float g = ((b * b - 2 * b * c + c * c) / (a * a - 2 * a * b + b * b));
		float k = (a * c - b * b) / (a - 2 * b + c);

		return f * (float) Math.pow(g, alphaN) + k;
	}
	
	@Deprecated
	public static float oldSam(float a, float b, float c, float alpha) {
		
		float f = (a - b) * (b - c) / (a - 2 * b + c);
		float g = (b - c) / (a - b);
		float k = (b * b - a * c) / (-a + 2 * b - c);
		
		return f * (float) Math.pow(g, alpha) + k;
	}
	

}
