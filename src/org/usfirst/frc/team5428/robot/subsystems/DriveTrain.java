package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.RobotMap;
import org.usfirst.frc.team5428.robot.commands.Drive;
import org.usfirst.frc.team5428.robot.core.C;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Zaeem Mohamed
 * @version 1.0 
 * This is the subsystem that controls the chassis of the robot,
 *          including its driving
 */
public class DriveTrain extends PIDSubsystem {

	private Talon frontLeft;
	private Talon backLeft;
	private Talon frontRight;
	private Talon backRight;
	private RobotDrive drive;
	private Gyro gyro;

	private boolean squaredInput;
	private double zLinear;
	private double xLinear;

	public DriveTrain() {
		super(Robot.DRIVE_TRAIN_P, Robot.DRIVE_TRAIN_I, Robot.DRIVE_TRAIN_D);
		setAbsoluteTolerance(0.05);
		getPIDController().setContinuous(true);
		getPIDController();
		squaredInput = false;

		frontLeft = new Talon(RobotMap.DT_FRONTLEFT);
		backLeft = new Talon(RobotMap.DT_BACKLEFT);
		frontRight = new Talon(RobotMap.DT_FRONTRIGHT);
		backRight = new Talon(RobotMap.DT_BACKRIGHT);
		gyro = new Gyro(0);
		gyro.setSensitivity(0.006);
		gyro.startLiveWindowMode();

		drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		
		zLinear = 0;
		xLinear = 0;
		
		C.out(getName() + " Initialized");
	}

	public void elonDrive(double fwd, double turn, double mgntd){
		zLinear = mgntd * fwd;
		xLinear = mgntd * turn;
	}
	
	public void enhancedDrive(double fwd, double gturn, double lturn, double mgntd){
		zLinear = fwd * mgntd;
		xLinear = mgntd * ((gturn*(1-Robot.JOYSTK_OFFSET)) + (lturn * Robot.JOYSTK_OFFSET));
	}
	
	public void rawDrive(double speed, double curve){
		drive.arcadeDrive(speed, curve, squaredInput);
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

	public void update(){
		drive.arcadeDrive(zLinear, xLinear - (Robot.DRIVE_TRAIN_A/Robot.DRIVE_TRAIN_K) * zLinear, squaredInput);
	}
	
	@Override
	protected double returnPIDInput() {
		return gyro.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		xLinear = output;
		update();
	}
	
}
