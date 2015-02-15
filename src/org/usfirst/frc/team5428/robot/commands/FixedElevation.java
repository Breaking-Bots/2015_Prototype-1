package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;

public final class FixedElevation extends CommandBase{

	public FixedElevation(){
		requires(elevator);
	}
	
	@Override
	public final void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	 public final void initialize() {
		setTimeout(Robot.ELEVATOR_TIME);
	}

	@Override
	 public final void execute() {
		elevator.elevate(1);
	}

	@Override
	 public final boolean isFinished() {
		return elevator.switchStatus() || isTimedOut() || isCanceled();
	}

	@Override
	 public final void end() {
		// TODO Auto-generated method stub
		elevator.elevate(0);
	}

	@Override
	 public final void interrupted() {
		// TODO Auto-generated method stub
		end();
	}
	
}
