package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.core.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

/** This basic autonomous command just make the robot push forward at 50%
 * 
 * @author Zaeem
 * @version 1.0
 */
public final class AutoBasicRush extends CommandBase {

	public final void initialize() {
		requires(driveTrain);
		
		setInterruptible(true);
		setTimeout(15.0);
	}

	public final void execute() {
		driveTrain.rawDrive(0.5f, 0.0f);
	}

	public final boolean isFinished() {
		return isCanceled() || isTimedOut();
	}

	public final void end() {
		// TODO Auto-generated method stub

	}

	public final void interrupted() {
		// TODO Auto-generated method stub

	}

	@Override
	public final void update() {
		// TODO Auto-generated method stub
		
	}

}
