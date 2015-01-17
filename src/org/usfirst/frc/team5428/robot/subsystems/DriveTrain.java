package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.RobotMap;
import org.usfirst.frc.team5428.robot.commands.Drive;
import org.usfirst.frc.team5428.robot.core.C;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * @author Zaeem Mohamed
 * @version 1.0 
 * This is the subsystem that controls the chassis of the robot,
 *          including its driving
 */
public class DriveTrain extends Subsystem {

	private Talon frontLeft;
	private Talon backLeft;
	private Talon frontRight;
	private Talon backRight;
	private RobotDrive drive;

	private boolean squaredInput;

	public DriveTrain() {
		super();

		squaredInput = false;

		frontLeft = new Talon(RobotMap.dt_frontLeft);
		backLeft = new Talon(RobotMap.dt_backLeft);
		frontRight = new Talon(RobotMap.dt_frontRight);
		backRight = new Talon(RobotMap.dt_backRight);

		drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

		C.out(getName() + " Initialized");
	}

	public void arcadeDrive(GenericHID c, float mgntd) {
		//C.out(c.getY(GenericHID.Hand.kLeft) * mgntd);
		drive.arcadeDrive(mgntd * -c.getY(GenericHID.Hand.kLeft),
				mgntd * -c.getX(GenericHID.Hand.kLeft), squaredInput);
	}

	public void tankDrive(GenericHID c, float mgntd) {
		drive.tankDrive(mgntd * -c.getY(GenericHID.Hand.kLeft),
				mgntd * -c.getY(GenericHID.Hand.kRight), squaredInput);
	}
	
	public void elonDrive(GenericHID c, float mgntd){
		drive.arcadeDrive(mgntd * -c.getY(GenericHID.Hand.kLeft),
				mgntd * -c.getX(GenericHID.Hand.kRight), squaredInput);
	}
	
	public void rawDrive(float speed, float curve){
        drive.drive(-speed, -curve);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}

	public void setSquaredInput(boolean squaredInput) {
		this.squaredInput = squaredInput;
	}

}
