package org.usfirst.frc.team5428.robot.input;

public class XGamepad extends Controller {

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
		A = new ControllerButton(this, 0);
		B = new ControllerButton(this, 1);
		X = new ControllerButton(this, 2);
		Y = new ControllerButton(this, 3);
		LB = new ControllerButton(this, 4);
		RB = new ControllerButton(this, 5);
		BACK = new ControllerButton(this, 6);
		START = new ControllerButton(this, 7);
		L3 = new ControllerButton(this, 8);
		R3 = new ControllerButton(this, 9);
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
	        return ((0x1 << (button)) & ds.getStickButtons(port)) != 0;
	}
	
	
}
