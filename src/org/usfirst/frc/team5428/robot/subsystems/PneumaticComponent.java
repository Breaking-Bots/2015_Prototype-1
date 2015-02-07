package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.RobotMap;
import org.usfirst.frc.team5428.robot.core.C;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticComponent extends Subsystem {

	private final Solenoid solenoid;
	private final Compressor compressor;
	
	public PneumaticComponent(){
		super();
		solenoid = new Solenoid(RobotMap.CAN_PCM, RobotMap.PN_SOLENOID);
		compressor = new Compressor(RobotMap.CAN_PCM);
		
		C.out(getName() + " Initialized");		
	}
	
	public void setSolenoidStatus(boolean on){
		solenoid.set(on);
	}
	
	public void setCompressorStatus(boolean on){
		compressor.setClosedLoopControl(on);
	}
	
	public String solenoidStatus(){
		return "SOLENOID ENABLED: " + solenoid.get();
	}
	
	public String compressorStatus(){
		return "COMPRESSOR ENABLED: " + compressor.enabled() + "\nSWITCH: " + compressor.getPressureSwitchValue();
	}
	
	protected void initDefaultCommand() {
		//NOTE: No default command
	}

}
