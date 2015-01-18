package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.core.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

/** This basic autonomous command just make the robot push forward at 100%
 * 
 * @author Zaeem
 * @version 1.0
 */
public class AutoBasicRush extends CommandBase {

	protected void initialize() {
		requires(driveTrain);
		
		setInterruptible(true);
		setTimeout(15.0);
	}

	protected void execute() {
		driveTrain.rawDrive(1.0f, 0.0f);
	}

	protected boolean isFinished() {
		return isCanceled() || isTimedOut();
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
