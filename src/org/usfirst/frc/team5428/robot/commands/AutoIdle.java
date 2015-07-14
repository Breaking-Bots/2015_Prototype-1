package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.core.CommandBase;

public class AutoIdle extends CommandBase{

	public AutoIdle(){
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public final void initialize() {
		setTimeout(0);
	}

	@Override
	public final void execute() {
	}

	@Override
	public final boolean isFinished() {
		return isCanceled() || isTimedOut();
	}

	@Override
	public final void end() {
	}

	@Override
	public final void interrupted() {
		end();
	}

}
