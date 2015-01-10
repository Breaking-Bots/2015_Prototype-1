package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.core.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drive via arcade drive
 */
public class ArcadeDrive extends CommandBase {

	private final float defaultMagnitude;
	private float magnitude;
	
    public ArcadeDrive(float magnitude) {
    	requires(driveTrain);
        this.magnitude = magnitude;
        defaultMagnitude = magnitude;
        this.setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.arcadeDrive(oi.driverController, magnitude);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
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
    
}
