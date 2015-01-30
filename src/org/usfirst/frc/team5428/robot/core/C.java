package org.usfirst.frc.team5428.robot.core;

import org.usfirst.frc.team5428.robot.math.MathUtil;


public class C {

	public static void main(String[] args){
		System.out.println("alpha\tx");
			float i = 0.5f;
			int x = 1000000000;
			long timeStart = System.nanoTime();
			for (int counter = 0; counter< x; counter++){

				//System.out.println("a " + timeStart);
				float a = MathUtil.masterEquation(0.3f, 0.80f, 1f, i);
				//System.out.println("a " + timeEnd);
			}
			System.out.println(timeStart);
			System.out.println(System.nanoTime());
			long timeTotal = System.nanoTime()- timeStart;
			System.out.println(timeTotal);
			double answer = timeTotal/x;
			System.out.println("timeTotal " + answer);
		}

	public static void out(Object obj){
		System.out.println("[ELON] <" + obj + ">");
	}
	
	public static void err(Object obj){
		System.err.println("[ERROR] <" + obj + ">");
	}
	
	public static void log(Object obj){
		System.out.println("[LOG] <" + obj + ">");
	}
	
}
