package org.usfirst.frc.team5428.robot.input;

public class PSGamepad extends Controller {

	public final ControllerButton X;
	public final ControllerButton O;
	public final ControllerButton S;
	public final ControllerButton T;
	public final ControllerButton L1;
	public final ControllerButton R1;
	public final ControllerButton SELECT;
	public final ControllerButton START;
	public final ControllerButton L3;
	public final ControllerButton R3;
	
	public PSGamepad(int port) {
		super(port);
		X = new ControllerButton(this, 1);
		O = new ControllerButton(this, 2);
		S = new ControllerButton(this, 3);
		T = new ControllerButton(this, 4);
		L1 = new ControllerButton(this, 5);
		R1 = new ControllerButton(this, 6);
		SELECT = new ControllerButton(this, 7);
		START = new ControllerButton(this, 8);
		L3 = new ControllerButton(this, 9);
		R3 = new ControllerButton(this, 10);
	}

	// Unfortunately we only have two axis of rotation
	@Override
	public double getZ(Hand hand) {
		return 0;
	}

	@Override
	public boolean getTop(Hand hand) {
		if (hand == LEFT_HAND)	return  L3.get();
		else if (hand == RIGHT_HAND) return  R3.get();		
		
		return false;
	}

	@Override
	public boolean getBumper(Hand hand) {
		if (hand == LEFT_HAND) return L1.get();
		else if (hand == RIGHT_HAND) return R1.get();		
		
		return false;
	}

	@Override
	public boolean getRawButton(int button) {
		return ((0x1 << (button - 1)) & ds.getStickButtons(port)) != 0;
	}

}
