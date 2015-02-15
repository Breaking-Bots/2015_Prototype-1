package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.RobotMap;
import org.usfirst.frc.team5428.robot.commands.ControlCamera;
import org.usfirst.frc.team5428.robot.commands.HoldElevation;
import org.usfirst.frc.team5428.robot.core.C;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/** This subsystem is the camera, which moves camera up and down
 */
public class Camera extends Subsystem {
    
	private Servo servo;
	
	public Camera(){
		super();
		servo = new Servo(RobotMap.CAM_SERVO);
		C.out(getName() + " Initialized");		
	}

	public void orient(double angle){
		servo.setAngle(servo.getAngle() + angle);
	}
	
	public void setPos(double pos){
		servo.setPosition(pos);
	}
	
	public double getPos(){
		return servo.getPosition();
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ControlCamera());
    }
}

