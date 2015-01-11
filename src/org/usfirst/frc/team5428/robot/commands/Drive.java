package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.core.CommandBase;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * an Drive class, for on the fly drive switching
 */
public class Drive extends CommandBase {

	private final float defaultMagnitude;
	private float magnitude;
	
	public static final int TNK = 0;
	public static final int ARC = 1;
	public static final int ALT = 2;
	
	private int currentState = TNK;
	
    public Drive(float magnitude) {
    	requires(driveTrain);
        this.magnitude = magnitude;
        defaultMagnitude = magnitude;
        this.setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
    	switch(currentState){
    	case TNK:
    		driveTrain.tankDrive(oi.driverController, magnitude);
    		break;
    	case ARC:
    		driveTrain.arcadeDrive(oi.driverController, magnitude);
    		break;
    	case ALT:
    		driveTrain.altDrive(oi.driverController, magnitude);
    		break;
    	default:
    		SmartDashboard.putString("Error", "Invalid Drive State");	    			
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected final boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected final void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected final void interrupted() {
    }
    
    public float getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(float magnitude) {
		this.magnitude = magnitude;
	}
	
	public void defaultMagnitude(){
		this.magnitude = defaultMagnitude;
	}

	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
    
}
