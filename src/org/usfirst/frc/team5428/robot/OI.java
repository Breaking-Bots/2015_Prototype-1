package org.usfirst.frc.team5428.robot;

import org.usfirst.frc.team5428.robot.commands.ControlCompressor;
import org.usfirst.frc.team5428.robot.commands.FixedDeclination;
import org.usfirst.frc.team5428.robot.commands.FixedElevation;
import org.usfirst.frc.team5428.robot.commands.LowerElevator;
import org.usfirst.frc.team5428.robot.commands.RaiseElevator;
import org.usfirst.frc.team5428.robot.core.C;
import org.usfirst.frc.team5428.robot.core.CommandBase;
import org.usfirst.frc.team5428.robot.input.Logitech3D;
import org.usfirst.frc.team5428.robot.input.XGamepad;
import org.usfirst.frc.team5428.robot.math.MathUtil;

import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public final class OI {
	
	private static OI instance;
	private static float magnitude;
			
	public static OI getInstance(){
		if(instance == null) instance = new OI();
		return instance;
	}
	
	
	public final XGamepad driverController;
	public final Logitech3D subController;
	private boolean disable;
	
	private OI(){
		driverController = new XGamepad(0);
		subController = new Logitech3D(1);
		
		magnitude = Robot.SPEED_DEFAULT;
		disable = true;
	}
	
	public void init(){
		subController.B2.held(new LowerElevator());				
		subController.B1.held(new RaiseElevator());
		subController.B3.tapped(new FixedElevation());
		subController.B4.tapped(new FixedDeclination());
		//driverController.B.toggleWhenPressed(new ControlCompressor());
		//driverController.L3.tapped(new CornerLeft());				
		//driverController.R3.tapped(new CornerRight());	
		//driverController.X.toggleWhenPressed(new CameraQualityToggle());
	}
	
	public void update(){
		
		if (subController.B11.get() && !disable) {
			C.out("Control Disabled");
			disable();
		}else if (subController.B12.get() && disable) {
			C.out("Control Enabled");
			enable();
		}
		
		setSystemMagnitude(MathUtil.zaeem(Robot.SPEED_MINIMUM, Robot.SPEED_DEFAULT, Robot.SPEED_MAXIMUM, (float) -subController.getThrottle()));
		if (!disable) {
			Scheduler.getInstance().run();
		}else{
			CommandBase.driveTrain.rawDrive(0,0);
		}
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
	
	public void disable(){disable = true;}
	public void enable(){disable = false;}
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

