package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.Robot;
import org.usfirst.frc.team5428.robot.core.C;
import org.usfirst.frc.team5428.robot.core.CommandBase;
import org.usfirst.frc.team5428.robot.input.Controller;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * an Drive class, for on the fly drive switching
 */
public class Drive extends CommandBase {

<<<<<<< HEAD
	private final float defaultMagnitude;
	private float magnitude;
	private boolean disable = true;

=======
>>>>>>> a328f602f22d08c657bed527dd37d48736e6124c
	public static final int TNK = 0;
	public static final int ARC = 1;
	public static final int ELN = 2;

	private int currentState = TNK;
<<<<<<< HEAD

	public Drive() {
		requires(driveTrain);
		this.magnitude = Robot.SPEED_DEFAULT;
		defaultMagnitude = Robot.SPEED_DEFAULT;
		this.setInterruptible(true);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		update();
		if (!disable) {
			switch (currentState) {
			case TNK:
				driveTrain.tankDrive(oi.driverController, magnitude);
				break;
			case ARC:
				driveTrain.arcadeDrive(oi.driverController, magnitude);
				break;
			case ELN:
				driveTrain.elonDrive(oi.driverController, magnitude);
				break;
			default:
				C.err("Invalid Drive state");
			}
		}
	}

	public void update() {

		if (oi.driverController.START.get() && !disable) {
			C.out("Drive is diabled");
			SmartDashboard.putString("Drive", "DSB");
			disable = true;
		} else if (oi.driverController.START.get() && disable) {
			C.out("Drive is enabled");
			SmartDashboard.putString("Drive", "ENB");
			disable = false;
		}

		if (oi.driverController.getPOV(0) == 270 && currentState != TNK) {
			C.out("Tank Drive is go");
			SmartDashboard.putString("Drive Type", "TNK");
=======
	
    public Drive() {
    	requires(driveTrain);
        this.setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
    	update();    	
    	switch(currentState){
    	case TNK:
    		driveTrain.tankDrive(oi.driverController, OI.getSystemMagnitude());
    		break;
    	case ARC:
    		driveTrain.arcadeDrive(oi.driverController, OI.getSystemMagnitude());
    		break;
    	case ELN:
    		driveTrain.elonDrive(oi.driverController, OI.getSystemMagnitude());
    		break;
    	default:
    		C.err("Invalid Drive state");    			
    	}
    }
    
    public void update(){
    	if(oi.driverController.getPOV(0) == 270 && currentState != TNK){
    		C.out("Tank Drive is go");
    		SmartDashboard.putString("Drive Type", "TNK");
>>>>>>> a328f602f22d08c657bed527dd37d48736e6124c
			setCurrentState(Drive.TNK);
		} else if (oi.driverController.getPOV(0) == 180 && currentState != ARC) {
			SmartDashboard.putString("Drive Type", "ARC");
			C.out("Arcade Drive is go");
			setCurrentState(Drive.ARC);
		} else if (oi.driverController.getPOV(0) == 90 && currentState != ELN) {
			SmartDashboard.putString("Drive Type", "ELN");
			C.out("Elon Drive is go");
			setCurrentState(Drive.ELN);
		}
<<<<<<< HEAD
		// C.out("Drive Update");
		// C.out(oi.driverController.getTrigger(GenericHID.Hand.kLeft));
		if (oi.driverController.getTrigger(GenericHID.Hand.kLeft)) {
			setMagnitude(Robot.SPEED_MINIMUM);
		} else if (oi.driverController.getTrigger(GenericHID.Hand.kRight)) {
			setMagnitude(Robot.SPEED_MAXIMUM);
		} else {
			defaultMagnitude();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected final boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected final void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected final void interrupted() {
		defaultMagnitude();
	}

	public float getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(float magnitude) {
		this.magnitude = magnitude;
	}

	public void defaultMagnitude() {
		this.magnitude = defaultMagnitude;
	}

=======
    }

    // Make this return true when this Command no longer needs to run execute()
    protected final boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected final void end() {
    	driveTrain.rawDrive(0.0f, 0.0f);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected final void interrupted() {
    	end();
    }
    
>>>>>>> a328f602f22d08c657bed527dd37d48736e6124c
	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	public boolean isDiabled() {
		return disable;
	}

	public void cancel(boolean disable) {
		this.disable = disable;
	}

}
