package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.core.CommandBase;

public class AutoLift extends CommandBase{

	public AutoLift(){
		requires(elevator);
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public final void initialize() {
		setTimeout(1.5);
	}

	@Override
	public final void execute() {
		elevator.elevate(1);
	}

	@Override
	public final boolean isFinished() {
		return isCanceled() || isTimedOut();
	}

	@Override
	public final void end() {
		elevator.elevate(0);
	}

	@Override
	public final void interrupted() {
		end();
	}

}
