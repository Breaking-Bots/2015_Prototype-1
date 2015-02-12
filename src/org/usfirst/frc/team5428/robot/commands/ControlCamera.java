package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;


/**
 * Controls camera
 */
public class ControlCamera extends CommandBase {

    public ControlCamera() {
        requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(oi.subController.getPOV() == 0)
    		camera.orient(Robot.CAM_PAN_SPEED);
    	else if(oi.subController.getPOV() == 180)
    		camera.orient(-Robot.CAM_PAN_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCanceled();
    }

    // Called once after isFinished returns true
    protected void end() {
    	camera.setPos(camera.START_POS);    	
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
