package org.usfirst.frc.team5428.robot;

import org.usfirst.frc.team5428.robot.commands.Drive;
import org.usfirst.frc.team5428.robot.input.Controller;
import org.usfirst.frc.team5428.robot.input.Logitech3D;
import org.usfirst.frc.team5428.robot.input.PSGamepad;

import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public final class OI {
	
	private static final OI instance = new OI();
			
	public static OI getInstance(){
		return instance;
	}
	
	public final PSGamepad driverController;
	public final Logitech3D subController;
	
	public final Drive drive;
	
	private OI(){
		driverController = new PSGamepad(0);
		subController = new Logitech3D(1);
		
		drive = new Drive(0.5f);
	}
	
	public void init(){
		drive.start();
	}
	
	public void update(){
		
		if(driverController.getPOV(0) == 270){
			drive.setCurrentState(drive.TNK);
		}else if(driverController.getPOV(0) == 180){
			drive.setCurrentState(drive.ARC);
		}else if(driverController.getPOV(0) == 90){
			drive.setCurrentState(drive.ALT);
		}
		
		if(driverController.getTrigger(Controller.LEFT_HAND)){
			drive.setMagnitude(0.05f);
		}else if(driverController.getTrigger(Controller.RIGHT_HAND)){
			drive.setMagnitude(1.0f);
		}else{
			drive.defaultMagnitude();
		}
		Scheduler.getInstance().run();
	}
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	
	
}

