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
        requires(pneumaticComponent);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pneumaticComponent.setSolenoidStatus(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pneumaticComponent.solenoidStatus();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCanceled();
    }

    protected void end() {
    	pneumaticComponent.setSolenoidStatus(false);
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