package org.usfirst.frc.team5428.robot.core;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5428.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

	public static OI oi;
	
	public static DriveTrain driveTrain;
	public static Elevator elevator;
	
	public final static void init(){
		oi = OI.getInstance();
		driveTrain = new DriveTrain();
		elevator = new Elevator();
		C.out("CommandBase Initialized");
	}
	
	public CommandBase() {
		super();
	}

	public CommandBase(String name) {
		super(name);
	}
		
	
	public abstract void update();

}
