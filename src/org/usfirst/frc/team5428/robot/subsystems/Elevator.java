package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.RobotMap;
import org.usfirst.frc.team5428.robot.core.C;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/** This subsystem is the elevator, which moves boxes up and down
 * 
 * @author Zaeem Mohamed
 * @version 1.0
 */
public class Elevator extends Subsystem {
    
	private Victor victor;
	
	public Elevator(){
		super();
		victor = new Victor(RobotMap.elevator);
		
		C.out(getName() + " Initialized");		
	}
	
	public void elevate(float mgntd){
		victor.set(mgntd);
	}

	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ());
    }
}

