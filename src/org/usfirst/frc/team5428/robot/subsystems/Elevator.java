package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.RobotMap;
import org.usfirst.frc.team5428.robot.commands.HoldElevation;
import org.usfirst.frc.team5428.robot.core.C;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/** This subsystem is the elevator, which moves boxes up and down
 * 
 * @author Zaeem Mohamed
 * @version 1.0
 */
public final class Elevator extends Subsystem {
    
	private final Victor victor;
	private final DigitalInput limitSwitch;
	private final Counter counter;
	
	public Elevator(){
		super();
		victor = new Victor(RobotMap.ELEVATOR);
		limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH);
		counter = new Counter(limitSwitch);
		counter.reset();
		C.out(getName() + " Initialized");		
	}

	public final void resetSwitch(){
		counter.reset();
	}
	
	public final int getCount(){
		return counter.get();
	}
	
	public final boolean switchStatus(){
		return counter.get() > 0;
	}
	
	public final void elevate(double mgntd){
		victor.set(mgntd);
	}
	
    public final void initDefaultCommand() {
        //setDefaultCommand(new HoldElevation());
    }
}

