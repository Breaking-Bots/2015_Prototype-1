package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;
import org.usfirst.frc.team5428.robot.math.MathUtil;

/**
 *
 */
public class NearVision extends CommandBase {

    public NearVision() {
    	requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	camera.setPos(Robot.CAM_NEAR_POSY);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return MathUtil.epsilonEquals(Robot.CAM_NEAR_POSY,(float) camera.getPos(), 0.01f);
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
		// TODO Auto-generated method stub
		
	}
}
