package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;

/**
 *
 */
public class CornerRight extends CommandBase {

    public CornerRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(Robot.CORNER_TIME_R);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.rawDrive(0, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCanceled() || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.rawDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
