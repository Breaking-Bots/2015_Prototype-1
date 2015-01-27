package org.usfirst.frc.team5428.robot.core;

import org.usfirst.frc.team5428.robot.math.MathUtil;


public class C {

	public static void main(String[] args){
		for(float i = -1; i <= 1; i+= 0.25f){
			System.out.println(i + "\t" + MathUtil.trilerp(0.3f, 0.65f, 1f, i));
		}
	}

	public static void out(Object obj){
		System.out.println("[ELON] " +obj);
	}
	
	public static void err(Object obj){
		System.err.println("[ERROR] " + obj);
	}
	
	public static void log(Object obj){
		System.out.println("[LOG] " + obj);
	}
	
}
