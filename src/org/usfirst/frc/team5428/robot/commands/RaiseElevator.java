package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.core.CommandBase;
import org.usfirst.frc.team5428.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Raises elevator
 */
public class RaiseElevator extends CommandBase {

    public RaiseElevator() {
        requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevator.resetSwitch();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elevator.elevate(OI.getSystemMagnitude());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elevator.switchStatus() || isCanceled();
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevator.elevate(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	elevator.elevate(0);
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
