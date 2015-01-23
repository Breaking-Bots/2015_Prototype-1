package org.usfirst.frc.team5428.robot.input;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;

public abstract class Controller extends GenericHID{
	
	protected DriverStation ds;
	protected final int port;
	
	private float deadzone;
	private float triggerDeadzone;
	
	protected Controller(int port) {
		super();
		this.port = port;
		ds = DriverStation.getInstance();
		
		deadzone = 0.15f;
		triggerDeadzone = 0.15f;
		
	}
	
	public static final class AxisType{
		
		private final int enumerator;
		protected AxisType(int enumerator){
			this.enumerator = enumerator;
		}
		
		public int get(){return enumerator;}
		
		public static final AxisType LX = new AxisType(0);
		public static final AxisType LY = new AxisType(1);
		public static final AxisType LT = new AxisType(2);
		public static final AxisType RT = new AxisType(3);
		public static final AxisType RX = new AxisType(4);
		public static final AxisType RY = new AxisType(5);
		
	}
	
	public final double checkDeadzone(double value) {
            return (Math.abs(value) >= deadzone? value : 0);
	}
	
	public final boolean checkTriggerDeadzone(double value) {
        return Math.abs(value) >= triggerDeadzone;
	}
	
	public final double getLX(){
		return checkDeadzone(getAxis(AxisType.LX));
	}
	public final double getLY(){
		return checkDeadzone(getAxis(AxisType.LY));
	}
	public final double getRX(){
		return checkDeadzone(getAxis(AxisType.RX));
	}
	public final double getRY(){
		return checkDeadzone(getAxis(AxisType.RY));
	}
	
	public final double getX(Hand hand) {
		if(hand == Hand.kLeft) return checkDeadzone(getAxis(AxisType.LX));
        else if(hand == Hand.kRight) return checkDeadzone(getAxis(AxisType.RX));        
		
		return 0;
	}

	public final double getY(Hand hand) {
		if(hand == Hand.kLeft) return checkDeadzone(getAxis(AxisType.LY));
        else if(hand == Hand.kRight) return checkDeadzone(getAxis(AxisType.RY));        
		
		return 0;
	}

	/** 
	 */
	@Override
	public double getZ(Hand hand) {
		return 0;
	}

	@Override
	public final boolean getTrigger(Hand hand) {
		if(hand == Hand.kLeft) return checkTriggerDeadzone(getAxis(AxisType.LT));
        else if(hand == Hand.kRight) return checkTriggerDeadzone(getAxis(AxisType.RT));        
		
		return false;
	}
	
	@Override
	public final double getTwist() {
		return getAxis(AxisType.LT);
	}

	@Override
	public final double getThrottle() {
		return getAxis(AxisType.RT);
	}

	public final double getLT() {
		return getAxis(AxisType.LT);
	}
	
	public final double getRT() {
		return getAxis(AxisType.RT);
	}
	
	@Override
	public final double getRawAxis(int axis) {
		return ds.getStickAxis(port, axis);
	}

	public final double getAxis(AxisType axis){
		return getRawAxis(axis.get());
	}
	
	@Override
	public final int getPOV(int pov){
		return ds.getStickPOV(port, pov);		
	}
	
	@Override
	public abstract boolean getTop(Hand hand);
	
	@Override
	public abstract boolean getBumper(Hand hand);

	@Override
	public abstract boolean getRawButton(int button);

	public double getDeadzone() {
		return deadzone;
	}

	public void setDeadZone(float deadzone) {
		this.deadzone = deadzone;
	}

	public double getTriggerDeadzone() {
		return triggerDeadzone;
	}

	public void setTriggerDeadzone(float triggerDeadzone) {
		this.triggerDeadzone = triggerDeadzone;
	}
	
}
