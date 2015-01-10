package org.usfirst.frc.team5428.robot.core;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.input.Controller;
import org.usfirst.frc.team5428.robot.input.PSGamepad;
import org.usfirst.frc.team5428.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class CommandBase extends Command {

	public static OI oi;
	protected static DriveTrain driveTrain;
	
	public static void init(){
		oi = OI.getInstance();
		driveTrain = new DriveTrain();
		SmartDashboard.putData(driveTrain);
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
