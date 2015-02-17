package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.C;
import org.usfirst.frc.team5428.robot.core.CommandBase;


/**
 * Controls camera
 */
public final class ControlCamera extends CommandBase {

	
    public ControlCamera() {
        requires(camera);
    }

    // Called just before this Command runs the first time
    public final void initialize() { 
    }

    // Called repeatedly when this Command is scheduled to run
    public final void execute() {
//    	switch (oi.currentState) {
//		case OI.X3D:
//			if(oi.subController.getPOV() == 0)
//				camera.orient(Robot.CAM_PAN_SPEED);
//			else if(oi.subController.getPOV() == 180)
//				camera.orient(-Robot.CAM_PAN_SPEED);
////			break;
////		case OI.XGP:
			if(oi.driverController.getPOV() == 0)
				camera.orient(Robot.CAM_PAN_SPEED);
			else if(oi.driverController.getPOV() == 180)
				camera.orient(-Robot.CAM_PAN_SPEED);
//			break;
//		default:
//			C.err("Invalid Control state");
//		}
    }

    // Make this return true when this Command no longer needs to run execute()
    public final boolean isFinished() {
        return isCanceled();
    }

    // Called once after isFinished returns true
    public final void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    public final void interrupted() {
    	end();
    }

	@Override
	public final void update() {
		// TODO Auto-generated method stub
		
	}
}
