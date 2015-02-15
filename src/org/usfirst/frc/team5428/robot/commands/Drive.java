package org.usfirst.frc.team5428.robot.commands;

import org.usfirst.frc.team5428.robot.OI;
import org.usfirst.frc.team5428.robot.core.C;
import org.usfirst.frc.team5428.robot.core.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * A general Drive class, for on the fly drive switching
 */
public class Drive extends CommandBase {

	public Drive() {
		requires(driveTrain);
		this.setInterruptible(true);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		update();
		switch (oi.currentState) {
		case OI.X3D:
			driveTrain.enhancedDrive(-oi.subController.getY(),-oi.subController.getX(), -oi.subController.getZ(), OI.getSystemMagnitude());
			break;
		case OI.XGP:
			driveTrain.elonDrive(-oi.driverController.getLY(),-oi.driverController.getRX() , OI.getSystemMagnitude());
			break;
		default:
			C.err("Invalid Control state");
		}
	}

	public void update() {
//		if (oi.subController.B7.get() && currentState != ELN) {
//			SmartDashboard.putString("Drive Type", "ELN");
//			C.out("Elon Drive is go");
//			setCurrentState(Drive.ELN);
//		} else if (oi.subController.B8.get() && currentState != TNK) {
//			C.out("Tank Drive is go");
//			SmartDashboard.putString("Drive Type", "TNK");
//			setCurrentState(Drive.TNK);
//		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected final boolean isFinished() {
		return isCanceled();
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

}