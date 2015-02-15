package org.usfirst.frc.team5428.robot.core;

import org.usfirst.frc.team5428.robot.math.MathUtil;

public final class C {

	public final static void main(String[] args){
		for(float i = -1.0f; i <= 1.0f; i+= 0.25f){
			System.out.println(i + "\t" + MathUtil.sam(0.3f, 0.65f, 1.0f, i));
		}
	}

	public final static void out(Object obj){
		System.out.println("[ELON] <" + obj + ">");
	}
	
	public final static void err(Object obj){
		System.err.println("[ERROR] <" + obj + ">");
	}
	
	public final static void log(Object obj){
		System.out.println("[LOG] <" + obj + ">");
	}
	
}
