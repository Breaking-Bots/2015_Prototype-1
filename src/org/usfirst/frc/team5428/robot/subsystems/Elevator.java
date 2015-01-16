package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Elevator subsystem - 
 * 
 * @author Zaeem Mohamed
 * @version 1.0
 */
public class Elevator extends Subsystem {
    
	Victor victor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Elevator(){
		victor = new Victor(RobotMap.elevator);
	}

	public void elevate(float mgntd){
		victor.set(mgntd);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

