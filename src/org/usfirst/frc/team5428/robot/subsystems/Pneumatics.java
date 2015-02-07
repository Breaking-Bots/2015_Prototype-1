package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.RobotMap;
import org.usfirst.frc.team5428.robot.core.C;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SolenoidBase;

/**
 *
 */
public class Pneumatics extends Subsystem {
	
	private Solenoid solenoid1;
	
	public Pneumatics() {
		super();
		
		//depends on how many solenoid channels there are
		solenoid1 = new Solenoid (1);
		
		C.out(getName() + " Initialized");
	}

	public void enable ()
	{
		solenoid1.set(true);
	}
	
	public void disable ()
	{
		solenoid1.set(false);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub		
	}
	
	
}
