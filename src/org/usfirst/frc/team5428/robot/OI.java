package org.usfirst.frc.team5428.robot;

import org.usfirst.frc.team5428.robot.commands.CameraQualityToggle;
import org.usfirst.frc.team5428.robot.commands.CameraToggle;
import org.usfirst.frc.team5428.robot.commands.CornerLeft;
import org.usfirst.frc.team5428.robot.commands.CornerRight;
import org.usfirst.frc.team5428.robot.commands.LowerElevator;
import org.usfirst.frc.team5428.robot.commands.RaiseElevator;
import org.usfirst.frc.team5428.robot.input.Logitech3D;
import org.usfirst.frc.team5428.robot.input.XGamepad;
import org.usfirst.frc.team5428.robot.math.MathUtil;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public final class OI {
	
	private static OI instance;
	private static float magnitude;
	
			
	public static OI getInstance(){
		return instance == null? new OI(): instance;
	}
	
	public final XGamepad driverController;
	public final Logitech3D subController;
	
	private OI(){
		driverController = new XGamepad(0);
		subController = new Logitech3D(1);
		magnitude = Robot.SPEED_DEFAULT;
	}
	
	public void init(){
		driverController.LB.held(new RaiseElevator());				
		driverController.RB.held(new LowerElevator());
		driverController.L3.tapped(new CornerLeft());				
		driverController.R3.tapped(new CornerRight());	
		//driverController.A.toggleWhenPressed(new CameraToggle());
		//driverController.X.toggleWhenPressed(new CameraQualityToggle());
	}
	
	public void update(){
		
		Robot.SPEED_MINIMUM = (float) SmartDashboard.getNumber("MIN_SPEED", Robot.SPEED_MINIMUM);
		Robot.SPEED_DEFAULT = (float) SmartDashboard.getNumber("DEF_SPEED", Robot.SPEED_DEFAULT);
		Robot.SPEED_MAXIMUM = (float) SmartDashboard.getNumber("MAX_SPEED", Robot.SPEED_MAXIMUM);
		
		Robot.CAM_QUALITY_MIN = (int) SmartDashboard.getNumber("CAM_QUALITY_MIN", Robot.CAM_QUALITY_MIN);
		Robot.CAM_QUALITY_MAX = (int) SmartDashboard.getNumber("CAM_QUALITY_MAX", Robot.CAM_QUALITY_MAX);
		
		Robot.CORNER_TIME_L = (float) SmartDashboard.getNumber("CORNER_TIME_L", Robot.CORNER_TIME_L);
		Robot.CORNER_TIME_R = (float) SmartDashboard.getNumber("CORNER_TIME_R", Robot.CORNER_TIME_R);
		
		Robot.DRIVE_TRAIN_P = (float) SmartDashboard.getNumber("DRIVE_TRAIN_P", Robot.DRIVE_TRAIN_P);
		
		Robot.LOWERED_SPEED = (float) SmartDashboard.getNumber("LOWERED_SPEED", Robot.LOWERED_SPEED);
		Robot.HOLD_POSITION = (float) SmartDashboard.getNumber("HOLD_POSITION", Robot.HOLD_POSITION);
		
			//TODO: test the lerp by using speed contollers
		setSystemMagnitude(MathUtil.trilerp(Robot.SPEED_MINIMUM,Robot.SPEED_DEFAULT, Robot.SPEED_MAXIMUM, (float) driverController.getT()));
			
		
		Scheduler.getInstance().run();
	}
	
    public static float getSystemMagnitude() {
		return magnitude;
	}

	public static void setSystemMagnitude(float mgntd) {
		magnitude = mgntd;
	}
	
	public static  void defaultSystemMagnitude(){
		magnitude = Robot.SPEED_DEFAULT;
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

