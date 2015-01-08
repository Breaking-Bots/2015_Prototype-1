package org.usfirst.frc.team5428.robot.input;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Command;

public class ControllerButton extends Button {

	private Controller controller;
	private int mappedNumber;

	public ControllerButton(Controller controller, int mappedNumber) {
		this.controller = controller;
		this.mappedNumber = mappedNumber;
	}

	public boolean get() {
		return controller.getRawButton(mappedNumber);
	}
	
	public void tapped(final Command command){
		whenPressed(command);
	}
	
	public void held(final Command command){
		whileHeld(command);
	}
	
	public void released(final Command command){
		whenReleased(command);
	}
	
	public int iterative(){
		return mappedNumber;
	}
	
}
