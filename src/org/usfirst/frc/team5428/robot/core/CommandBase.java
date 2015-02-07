package org.usfirst.frc.team5428.robot.core;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.input.Controller;
import org.usfirst.frc.team5428.robot.input.PSGamepad;
import org.usfirst.frc.team5428.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5428.robot.subsystems.Elevator;
<<<<<<< HEAD
import org.usfirst.frc.team5428.robot.subsystems.PneumaticComponent;
=======
import org.usfirst.frc.team5428.robot.subsystems.Pneumatics;
>>>>>>> 05d2fb39f82f01e46a1d8919e10aa1780d65008a

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class CommandBase extends Command {

	public static OI oi;
<<<<<<< HEAD
	protected static DriveTrain driveTrain;
	protected static Elevator elevator;
	protected static Pneumatics pneumatics;
=======
	public static DriveTrain driveTrain;
	public static Elevator elevator;
<<<<<<< HEAD
	public static PneumaticComponent pneumaticComponent;
=======
>>>>>>> origin/master
>>>>>>> 05d2fb39f82f01e46a1d8919e10aa1780d65008a
	
	public static void init(){
		oi = OI.getInstance();
		driveTrain = new DriveTrain();
		elevator = new Elevator();
<<<<<<< HEAD
		pneumaticComponent = new PneumaticComponent();
=======
		pneumatics = new Pneumatics();
>>>>>>> 05d2fb39f82f01e46a1d8919e10aa1780d65008a
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
