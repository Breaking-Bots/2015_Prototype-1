package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;
import org.usfirst.frc.team5428.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Controls the enabling and disabling of solenoids
 */
public class ControlSolenoid extends CommandBase {
	
	public ControlSolenoid() {
        requires(pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pneumatics.enable();    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCanceled();
    }

    protected void end() {
    	pneumatics.disable(); 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	pneumatics.disable();
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}