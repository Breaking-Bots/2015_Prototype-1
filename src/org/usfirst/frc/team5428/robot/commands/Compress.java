package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.RobotMap;
import org.usfirst.frc.team5428.robot.core.C;
import org.usfirst.frc.team5428.robot.core.CommandBase;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Command that compresses compressor
 */
public class Compress extends CommandBase {

	private final Compressor compressor;
	
    public Compress() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	compressor = new Compressor(RobotMap.CAN_COMPRESSOR);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	compressor.setClosedLoopControl(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	C.out(compressor.getClosedLoopControl());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCanceled();
    }

    // Called once after isFinished returns true
    protected void end() {
    	compressor.setClosedLoopControl(false);
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
