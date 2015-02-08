package org.usfirst.frc.team5428.robot.core;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.input.Controller;
import org.usfirst.frc.team5428.robot.input.PSGamepad;
import org.usfirst.frc.team5428.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5428.robot.subsystems.Elevator;
import org.usfirst.frc.team5428.robot.subsystems.PneumaticComponent;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class CommandBase extends Command {

	public static OI oi;
	
	public static DriveTrain driveTrain;
	public static Elevator elevator;
	public static PneumaticComponent pneumaticComponent;
	
	public static void init(){
		oi = OI.getInstance();
		driveTrain = new DriveTrain();
		elevator = new Elevator();
		pneumaticComponent = new PneumaticComponent();
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(elevator);
		SmartDashboard.putData(pneumaticComponent);
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
