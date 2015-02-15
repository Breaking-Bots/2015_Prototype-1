package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;

/**
 * Holds elevator at a steady position
 */
public final class HoldElevation extends CommandBase {

    public HoldElevation() {
        requires(elevator);
    }

    // Called just before this Command runs the first time
     public final void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
     public final void execute() {
    	elevator.elevate(Robot.HOLD_POSITION);
    }

    // Make this return true when this Command no longer needs to run execute()
     public final boolean isFinished() {
        return isCanceled();
    }

    // Called once after isFinished returns true
     public final void end() {
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
