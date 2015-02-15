package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;

/**
 *
 */
public final class CornerRight extends CommandBase {

    public CornerRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    public final void initialize() {
    	setTimeout(Robot.CORNER_TIME_R);
    }

    // Called repeatedly when this Command is scheduled to run
    public final void execute() {
    	driveTrain.rawDrive(0, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    public final boolean isFinished() {
        return isCanceled() || isTimedOut();
    }

    // Called once after isFinished returns true
    public final void end() {
    	driveTrain.rawDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    public final void interrupted() {
    }

	@Override
	public final void update() {
		// TODO Auto-generated method stub
		
	}
}
