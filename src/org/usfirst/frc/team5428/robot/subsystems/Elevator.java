package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.RobotMap;
<<<<<<< HEAD
import org.usfirst.frc.team5428.robot.core.C;
=======
>>>>>>> a328f602f22d08c657bed527dd37d48736e6124c

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

<<<<<<< HEAD
/** This subsystem is the elevator, which moves boxes up and down
=======
/** Elevator subsystem - 
>>>>>>> a328f602f22d08c657bed527dd37d48736e6124c
 * 
 * @author Zaeem Mohamed
 * @version 1.0
 */
public class Elevator extends Subsystem {
    
<<<<<<< HEAD
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
=======
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
>>>>>>> a328f602f22d08c657bed527dd37d48736e6124c
    }
}

