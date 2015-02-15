package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.C;
import org.usfirst.frc.team5428.robot.core.CommandBase;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Toggles quality of camera between two values
 */
public class CameraQualityToggle extends CommandBase {

    public CameraQualityToggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	C.out("Camera Quality HIGH");
    	CameraServer.getInstance().setQuality(Robot.CVIEWING_QUALITY);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isCanceled();
    }

    // Called once after isFinished returns true
    protected void end() {
    	C.out("Camera Quality LOW");
    	CameraServer.getInstance().setQuality(Robot.CVIEWING_QUALITY);
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
