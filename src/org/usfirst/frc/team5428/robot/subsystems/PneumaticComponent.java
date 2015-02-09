package org.usfirst.frc.team5428.robot.subsystems;

import org.usfirst.frc.team5428.robot.RobotMap;
import org.usfirst.frc.team5428.robot.core.C;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PneumaticComponent extends Subsystem {

	private final DoubleSolenoid solenoid;
	private final Compressor compressor;
	
	public PneumaticComponent(){
		super();
		solenoid = new DoubleSolenoid(0, 1);
		compressor = new Compressor(RobotMap.CAN_PCM);
		
		C.out(getName() + " Initialized");		
	}
	
	public void setSolenoidStatus(Value on){
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
