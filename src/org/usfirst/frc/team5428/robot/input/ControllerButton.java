package org.usfirst.frc.team5428.robot.input;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

public final class ControllerButton extends Button {

	private GenericHID controller;
	private int mappedNumber;

	public ControllerButton(GenericHID controller, int mappedNumber) {
		this.controller = controller;
		this.mappedNumber = mappedNumber;
	}

	public final boolean get() {
		return controller.getRawButton(mappedNumber);
	}
	
	public final void tapped(final Command command){
		whenPressed(command);
	}
	
	public final void held(final Command command){
		whileHeld(command);
	}
	
	public final void released(final Command command){
		whenReleased(command);
	}
	
	public final int iterative(){
		return mappedNumber;
	}
	
}
