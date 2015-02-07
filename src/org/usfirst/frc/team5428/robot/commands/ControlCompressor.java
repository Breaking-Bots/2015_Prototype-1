package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.core.CommandBase;

/**
 * Command that compresses compressor
 */
public class ControlCompressor extends CommandBase {

    public ControlCompressor() {
    	requires(pneumaticComponent);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pneumaticComponent.setCompressorStatus(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pneumaticComponent.compressorStatus();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCanceled();
    }

    protected void end() {
    	pneumaticComponent.setCompressorStatus(false);
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
