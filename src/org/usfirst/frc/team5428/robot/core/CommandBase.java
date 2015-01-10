package org.usfirst.frc.team5428.robot.core;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.input.Controller;
import org.usfirst.frc.team5428.robot.input.PSGamepad;
import org.usfirst.frc.team5428.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class CommandBase extends Command {

	public final static OI oi;
	
	static{
		oi = OI.getInstance();
	}
	
	protected static DriveTrain driveTrain = new DriveTrain();
	
	public CommandBase() {
		super();
	}

	public CommandBase(String name) {
		super(name);
	}
		
	public static void init(){
		SmartDashboard.putData(driveTrain);
	}
	
	public void update(){
		
	}

}
