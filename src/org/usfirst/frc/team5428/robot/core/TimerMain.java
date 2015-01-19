package org.usfirst.frc.team5428.robot.core;

import org.usfirst.frc.team5428.robot.OI;

import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Timer.Interface;
import edu.wpi.first.wpilibj.Timer.StaticInterface;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public abstract class TimerMain extends Command {

	public static OI oi;
	protected static Timer timer;
	protected static double seconds;
	
	public void initiate(){
		oi = OI.getInstance();
		timer = new Timer();
		SmartDashboard.putData((NamedSendable) timer);
		C.out("Timer Initialized");
	}
	
	public TimerMain(double seconds) {
		super();
		this.seconds = seconds;
	}
	
	public static double getTimer() {
		return timer.get();
	}

	public static void restart() {
		timer.reset();
	}
	
	public static void stop ()	{
		timer.stop();
	}
	
	public boolean checkTimer()	{
		return timer.hasPeriodPassed(seconds);		
	}
	
	public static void delayTimer () {
		Timer.delay(seconds);
	}
	
	public abstract void update();
}
