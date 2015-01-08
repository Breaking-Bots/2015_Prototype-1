package org.usfirst.frc.team5428.robot.core;

import org.usfirst.frc.team5428.robot.input.PSGamepad;

public class Console {

	public static void main(String[] args){
		PSGamepad controller = new PSGamepad(0);
		System.out.println(controller.getLX());
		System.out.println(controller.getLY());
	}

}
