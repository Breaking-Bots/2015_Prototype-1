package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.RobotMap;
import org.usfirst.frc.team5428.robot.commands.Drive;
import org.usfirst.frc.team5428.robot.core.C;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

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
	private Gyro gyro;

	private boolean squaredInput;

	public DriveTrain() {
		super();

		squaredInput = false;

		frontLeft = new Talon(RobotMap.DT_FRONTLEFT);
		backLeft = new Talon(RobotMap.DT_BACKLEFT);
		frontRight = new Talon(RobotMap.DT_FRONTRIGHT);
		backRight = new Talon(RobotMap.DT_BACKRIGHT);
		gyro = new Gyro(0);
		gyro.setSensitivity(0.006);
		gyro.startLiveWindowMode();

		drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

		C.out(getName() + " Initialized");
	}

	public void arcadeDrive(double fwd, double turn, float mgntd) {
		//C.out(c.getY(GenericHID.Hand.kLeft) * mgntd);
		drive.arcadeDrive(mgntd * -fwd,
				mgntd * -turn + Robot.DRIVE_TRAIN_P, squaredInput);
	}

	public void tankDrive(double lft, double rgt, float mgntd) {
		drive.tankDrive(mgntd * -lft + Robot.DRIVE_TRAIN_P,
				mgntd * -rgt, squaredInput);
	}
	
	public void elonDrive(double fwd, double turn, float mgntd){
		drive.arcadeDrive(mgntd * -fwd,
				mgntd * -turn + Robot.DRIVE_TRAIN_P, squaredInput);
	}
	
	public void enhancedDrive(double fwd, double gturn, double lturn, float mgntd){
		//float offset = (gturn < 0)? -Robot.JOYSTK_OFFSET: Robot.JOYSTK_OFFSET;
		double gturnAbs = Math.abs (gturn);
		int signGturn = (int)(gturn/Math.abs(gturn));
		float offset = Robot.JOYSTK_OFFSET;
		
		drive.arcadeDrive(fwd * mgntd, mgntd * ((gturn*(1-offset)) + (lturn * offset)), squaredInput);
	}
	
	public void rawDrive(float speed, float curve){
        drive.arcadeDrive(-speed, -curve  + Robot.DRIVE_TRAIN_P);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}

	public void setSquaredInput(boolean squaredInput) {
		this.squaredInput = squaredInput;
	}

	public double getGyro(){
		return gyro.getAngle();
	}
	
}
