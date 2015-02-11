package org.usfirst.frc.team5428.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int DT_FRONTLEFT = 0;
    public static final int DT_BACKLEFT = 1;
    public static final int DT_FRONTRIGHT = 2;
    public static final int DT_BACKRIGHT = 3;
    public static final int DT_GYRO = 0;
    
    public static final int ELEVATOR = 4;
    
    public static final int CAN_PCM = 42; 
    public static final int PN_SOLENOID = -1; //TODO: assign valid port
}
