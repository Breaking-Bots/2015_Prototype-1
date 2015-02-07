package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Controls the enabling and disabling of solenoids
 */
public class ControlSolenoid extends CommandBase {

    public ControlSolenoid() {
        //requires(solenoid);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	solenoid.set(true);    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCanceled();
    }

    protected void end() {
    	solenoid.set(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	solenoid.set(false);
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}