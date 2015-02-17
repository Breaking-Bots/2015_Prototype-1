package org.usfirst.frc.team5428.robot.input;

public final class XGamepad extends Controller {

	public final ControllerButton A;
	public final ControllerButton B;
	public final ControllerButton X;
	public final ControllerButton Y;
	public final ControllerButton LB;
	public final ControllerButton RB;
	public final ControllerButton BACK;
	public final ControllerButton START;
	public final ControllerButton L3;
	public final ControllerButton R3;
	
	public XGamepad(int port) {
		super(port);
		A = new ControllerButton(this, 1);
		B = new ControllerButton(this, 2);
		X = new ControllerButton(this, 3);
		Y = new ControllerButton(this, 4);
		LB = new ControllerButton(this, 5);
		RB = new ControllerButton(this, 6);
		BACK = new ControllerButton(this, 7);
		START = new ControllerButton(this, 8);
		L3 = new ControllerButton(this, 9);
		R3 = new ControllerButton(this, 10);
	}


	@Override
	public boolean getTop(Hand hand) {
		
		if (hand == Hand.kLeft)	return  L3.get();
		else if (hand == Hand.kRight) return  R3.get();		
		
		return false;
	}

	@Override
	public boolean getBumper(Hand hand) {
		
		if (hand == Hand.kLeft) return LB.get();
		else if (hand == Hand.kRight) return RB.get();		
		
		return false;
	}

	@Override
	public boolean getRawButton(int button) {
	        return ds.getStickButton(port, (byte) button); //((0x1 << (button)) & ds.getStickButtons(port)) != 0;
	}
	
	
}
