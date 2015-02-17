package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

/** This basic autonomous command just make the robot push forward at 50%
 * 
 * @author Zaeem
 * @version 1.0
 */
public final class AutoBasicRush extends CommandBase {

	public AutoBasicRush(){		
		requires(driveTrain);
		
		setInterruptible(true);
	}
	
	public final void initialize() {
		setTimeout(Robot.CORNER_TIME_L);
	}

	public final void execute() {
		driveTrain.rawDrive(0.3f, 0.0f);
	}

	public final boolean isFinished() {
		return isCanceled() || isTimedOut();
	}

	public final void end() {
		driveTrain.rawDrive(0.0f, 0.0f);
	}

	public final void interrupted() {

		end();

	}

	@Override
	public final void update() {
		// TODO Auto-generated method stub
		
	}

}
