package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;
import org.usfirst.frc.team5428.robot.math.MathUtil;

/**
 *
 */
public final class NearVision extends CommandBase {

    public NearVision() {
    	requires(camera);
    }

    // Called just before this Command runs the first time
     public final void initialize() {
    	camera.setPos(Robot.CAM_NEAR_POSY);
    }

    // Called repeatedly when this Command is scheduled to run
     public final void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
     public final boolean isFinished() {
        return MathUtil.epsilonEquals(Robot.CAM_NEAR_POSY,(float) camera.getPos(), 0.01f);
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
