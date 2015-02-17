package org.usfirst.frc.team5428.robot;

import org.usfirst.frc.team5428.robot.commands.DistVision;
import org.usfirst.frc.team5428.robot.commands.FixedDeclination;
import org.usfirst.frc.team5428.robot.commands.FixedElevation;
import org.usfirst.frc.team5428.robot.commands.LowerElevator;
import org.usfirst.frc.team5428.robot.commands.NearVision;
import org.usfirst.frc.team5428.robot.commands.RaiseElevator;
import org.usfirst.frc.team5428.robot.core.C;
import org.usfirst.frc.team5428.robot.core.CommandBase;
import org.usfirst.frc.team5428.robot.input.Logitech3D;
import org.usfirst.frc.team5428.robot.input.XGamepad;
import org.usfirst.frc.team5428.robot.math.MathUtil;

import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public final class OI {

	private static OI instance;
	private static double magnitude;
	private static double elevatorRate;

	public static final int XGP = 0;
	public static final int X3D = 1;

	public int currentState = XGP;

	public final static OI getInstance() {
		if (instance == null)
			instance = new OI();
		return instance;
	}

	public final XGamepad driverController;
	public final Logitech3D subController;
	private boolean disable;

	private OI() {
		driverController = new XGamepad(XGP);
		subController = new Logitech3D(X3D);

		magnitude = Robot.SPEED_DEFAULT;
		disable = true;
	}

	public final void init() {
//		switch (currentState) {
//		case X3D:
//			subController.B2.held(new LowerElevator());
//			subController.B1.held(new RaiseElevator());
//			subController.B3.tapped(new FixedElevation());
//			subController.B4.tapped(new FixedDeclination());
//			subController.B5.tapped(new NearVision());
//			subController.B6.tapped(new DistVision());
//			break;
//		case XGP:
			driverController.LB.held(new LowerElevator());
			driverController.RB.held(new RaiseElevator());
			driverController.R3.tapped(new FixedElevation());
			driverController.L3.tapped(new FixedDeclination());
			driverController.A.tapped(new NearVision());
			driverController.Y.tapped(new DistVision());
//			break;
//		default:
//			C.err("Invalid Control state");
//		}
	}

	public final void update() {
		// C.out(CommandBase.driveTrain.getGyro());
		// C.out(CommandBase.camera.getPos());
		// C.out(CommandBase.elevator.getCount());
		// C.out(subController.getX() + "|" + subController.getY() + "|" +
		// subController.getZ());
		C.out(driverController.Y.get());

//		switch (currentState) {
//		case X3D:
//			if (subController.B11.get() && !disable) {
//				C.out("Control Disabled");
//				disable();
//			} else if (subController.B9.get() && disable) {
//				C.out("Control Enabled");
//				enable();
//			}
//			setSystemMagnitude(MathUtil.lerp(Robot.SPEED_MINIMUM,
//					Robot.SPEED_MAXIMUM, -subController.getThrottle()));
//			setElevatorRate(MathUtil.lerp(Robot.SPEED_DEFAULT,
//					Robot.SPEED_MAXIMUM,
//					MathUtil.normalizeAlpha(-subController.getThrottle())));
//			break;
//		case XGP:
			if (driverController.BACK.get() && !disable) {
				C.out("Control Disabled");
				disable();
			} else if (driverController.START.get() && disable) {
				C.out("Control Enabled");
				enable();
			}
			setSystemMagnitude(MathUtil.zaeem(Robot.SPEED_MINIMUM,
					Robot.SPEED_DEFAULT, Robot.SPEED_MAXIMUM,
					driverController.getT()));
			setElevatorRate(MathUtil.lerp(Robot.SPEED_DEFAULT,
					Robot.SPEED_MAXIMUM,
					MathUtil.normalizeAlpha(driverController.getT())));
//			break;
//		default:
//			C.err("Invalid Control state");
//		}

		Scheduler.getInstance().run();
		if (!disable) {
			CommandBase.driveTrain.update();
		} else {
			CommandBase.driveTrain.rawDrive(0, 0);
		}
	}

	public final static double getSystemMagnitude() {
		return magnitude;
	}

	public final static void setSystemMagnitude(double mgntd) {
		magnitude = mgntd;
	}

	public final static void defaultSystemMagnitude() {
		magnitude = Robot.SPEED_DEFAULT;
	}

	public final static double getElevatorRate() {
		return elevatorRate;
	}

	public static void setElevatorRate(double mgntd) {
		elevatorRate = mgntd;
	}

	public static void defaultElevatorRate() {
		magnitude = Robot.SPEED_DEFAULT;
	}

	public void disable() {
		disable = true;
	}

	public void enable() {
		disable = false;
	}
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

}
