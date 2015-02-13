package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.CommandBase;

public class FixedElevation extends CommandBase{

	public FixedElevation(){
		requires(elevator);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialize() {
		setTimeout(Robot.ELEVATOR_TIME);
	}

	@Override
	protected void execute() {
		elevator.elevate(1);
	}

	@Override
	protected boolean isFinished() {
		return elevator.switchStatus() || isTimedOut() || isCanceled();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		elevator.elevate(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}
	
}
