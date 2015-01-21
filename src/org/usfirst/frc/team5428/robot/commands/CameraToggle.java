package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.core.CommandBase;
import org.usfirst.frc.team5428.robot.vision.Vision;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles camera on and off
 */
public class CameraToggle extends CommandBase {

    public CameraToggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Vision.teleopInit();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Vision.stream();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCanceled();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Vision.teleopTerminate();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
