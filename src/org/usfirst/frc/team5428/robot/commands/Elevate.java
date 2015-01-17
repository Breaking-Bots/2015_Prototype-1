package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.core.C;
import org.usfirst.frc.team5428.robot.core.CommandBase;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevate extends CommandBase {

	private float magnitude;
	
    public Elevate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(elevator);
    	magnitude = 0.0f;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	magnitude = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	update();
    	elevator.elevate(magnitude);
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

	@Override
	public void update() {
		if (oi.driverController.LB.get()) {
			magnitude = 1.0f;
		} else if (oi.driverController.RB.get()) {
			magnitude = -1.0f;
		}else{
			magnitude = 0.0f;
		}
		
	}
}
