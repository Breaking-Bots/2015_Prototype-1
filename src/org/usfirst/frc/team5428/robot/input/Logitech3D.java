package org.usfirst.frc.team5428.robot.input;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;

public class Logitech3D extends GenericHID {

	public final ControllerButton B1;
	public final ControllerButton B2;
	public final ControllerButton B3;
	public final ControllerButton B4;
	public final ControllerButton B5;
	public final ControllerButton B6;
	public final ControllerButton B7;
	public final ControllerButton B8;
	public final ControllerButton B9;
	public final ControllerButton B10;
	public final ControllerButton B11;
	public final ControllerButton B12;
	
	protected DriverStation ds;
	protected final int port;
	
	private float deadzone;
	
	public Logitech3D(int port) {
		this.port = port;
		ds = DriverStation.getInstance();
		
		B1 = new ControllerButton(this, 0);
		B2 = new ControllerButton(this, 1);
		B3 = new ControllerButton(this, 2);
		B4 = new ControllerButton(this, 3);
		B5 = new ControllerButton(this, 4);
		B6 = new ControllerButton(this, 5);
		B7 = new ControllerButton(this, 6);
		B8 = new ControllerButton(this, 7);
		B9 = new ControllerButton(this, 8);
		B10 = new ControllerButton(this, 9);
		B11 = new ControllerButton(this, 10);
		B12 = new ControllerButton(this, 11);
		
		deadzone = 0.30f;
	}
	
	public static final class AxisType{
		
		private final int enumerator;
		protected AxisType(int enumerator){
			this.enumerator = enumerator;
		}
		
		public int get(){return enumerator;}
		
		public static final AxisType X = new AxisType(0);
		public static final AxisType Y = new AxisType(1);
		public static final AxisType Z = new AxisType(2);
		public static final AxisType S = new AxisType(3);
		
	}

	public static Hand LEFT_HAND = Hand.kLeft;
	public static Hand RIGHT_HAND = Hand.kRight;
	
	public final double checkDeadzone(double value) {
		int sign = (int) Math.signum(value); 
		return (sign*value > deadzone)? (value - deadzone*sign)/(1 - deadzone):0;
	}
	
	@Override
	public double getX(Hand hand) {
		return checkDeadzone(getAxis(AxisType.X));
	}

	@Override
	public double getY(Hand hand) {
		return checkDeadzone(getAxis(AxisType.Y));
	}

	@Override
	public double getZ(Hand hand) {
		return checkDeadzone(getAxis(AxisType.Z));
	}

	@Override
	public double getTwist() {
		return getZ();
	}

	@Override
	public double getThrottle() {
		return getAxis(AxisType.S);
	}

	@Override
	public double getRawAxis(int axis) {
		return ds.getStickAxis(port, axis);
	}

	public final double getAxis(AxisType axis){
		return getRawAxis(axis.get());
	}
	
	@Override
	public boolean getTrigger(Hand hand) {
		return B1.get();
	}

	@Override
	public boolean getTop(Hand hand) {
		return B2.get();
	}

	//Not supported on Logitach 3D joysticks
	@Override
	public boolean getBumper(Hand hand) {
		return false;
	}

	@Override
	public boolean getRawButton(int button) {
	        return ((0x1 << (button)) & ds.getStickButtons(port)) != 0;
	}
	

	@Override
	public int getPOV(int pov) {
		return ds.getStickPOV(port, pov);
	}

	public double getDeadzone() {
		return deadzone;
	}

	public void setDeadZone(float deadzone) {
		this.deadzone = deadzone;
	}
	
}
