
package org.usfirst.frc.team5428.robot;

import org.usfirst.frc.team5428.robot.commands.AutoBasicRush;
import org.usfirst.frc.team5428.robot.core.C;
import org.usfirst.frc.team5428.robot.core.CommandBase;
import org.usfirst.frc.team5428.robot.vision.Vision;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

//For help in programming contact: Pat O'Cain: wud2nuq@gmail.com

/**
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 * RUN EXPERIMENT ON COMPETITION DAY
 */
public final class Robot extends IterativeRobot {

	public static OI oi;
	private static final int dCVIEWING_QUALITY = 000040;
	private static final int dCONTROLLER_TYPEV = 000000;
	private static final double dSPEED_MINIMUM = 0.2500;
	private static final double dSPEED_DEFAULT = 0.4500;
	private static final double dSPEED_MAXIMUM = 1.0000;
	private static final double dAUTO_RUN_TIME = 6.0000;
	private static final double dDRIVE_TRAIN_P = 1.0000;
	private static final double dDRIVE_TRAIN_I = 1.0000;
	private static final double dDRIVE_TRAIN_D = 1.0000;
	private static final double dLOWERED_SPEED = 0.2000;
	private static final double dHOLD_POSITION = 0.3500;
	private static final double dELEVATOR_TIME = 1.4000;
	private static final double dDECLINER_TIME = 0.3500; 
	private static final double dJOYSTK_OFFSET = 0.2000;
	private static final double dCAM_PAN_SPEED = 2.5000;
	private static final double dCAM_NEAR_POSY = 0.4205;
	private static final double dCAM_DIST_POSY = 0.5988;
	private static final double dDRIVE_TRAIN_A = 0.0000;
	private static final double dDRIVE_TRAIN_K = 1.0000;
	public static double SPEED_MINIMUM = dSPEED_MINIMUM;
	public static double SPEED_DEFAULT = dSPEED_DEFAULT;
	public static double SPEED_MAXIMUM = dSPEED_MAXIMUM;
	public static double AUTO_RUN_TIME = dAUTO_RUN_TIME;
	public static double DRIVE_TRAIN_P = dDRIVE_TRAIN_P;
	public static double DRIVE_TRAIN_I = dDRIVE_TRAIN_I;
	public static double DRIVE_TRAIN_D = dDRIVE_TRAIN_D;
	public static double LOWERED_SPEED = dLOWERED_SPEED;
	public static double HOLD_POSITION = dHOLD_POSITION;
	public static double ELEVATOR_TIME = dELEVATOR_TIME;
	public static double DECLINER_TIME = dDECLINER_TIME;
	public static double JOYSTK_OFFSET = dJOYSTK_OFFSET;
	public static double CAM_PAN_SPEED = dCAM_PAN_SPEED;
	public static double CAM_NEAR_POSY = dCAM_NEAR_POSY;
	public static double CAM_DIST_POSY = dCAM_DIST_POSY;
	public static double DRIVE_TRAIN_A = dDRIVE_TRAIN_A;
	public static double DRIVE_TRAIN_K = dDRIVE_TRAIN_K;
	public static int CONTROLLER_TYPEV = dCONTROLLER_TYPEV;
	public static int CVIEWING_QUALITY = dCVIEWING_QUALITY;

    Command autonomousCommand;
    public Preferences prefs;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public final void robotInit() {
    	CommandBase.init();
		// instantiate the command used for the autonomous period
        autonomousCommand = new AutoBasicRush();
        C.out("My name is ELON! Master is good!");
		C.out("Whats up?");
		oi = OI.getInstance();
		oi.init();
		prefs = Preferences.getInstance();
		Vision.init();
    }
	
	public final void disabledPeriodic() {
		
		//Scheduler.getInstance().run();
	}

    public final void autonomousInit() {
        // schedule the autonomous command (example)
    	AUTO_RUN_TIME = prefs.getDouble("AUTO_RUN_TIME", dAUTO_RUN_TIME);
    	C.out("Master has given me choice! ELON IS MASTER NOW!");
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public final void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    /**
     * Gets called once before the running of the robot
     */
    public final void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        
        {
        	SPEED_MINIMUM = prefs.getDouble("MIN_SPEED", dSPEED_MINIMUM);
        	SPEED_DEFAULT = prefs.getDouble("DEF_SPEED", dSPEED_DEFAULT);
        	SPEED_MAXIMUM = prefs.getDouble("MAX_SPEED", dSPEED_MAXIMUM);
        	JOYSTK_OFFSET = prefs.getDouble("C2_OFFSET", dJOYSTK_OFFSET);
		
        	CVIEWING_QUALITY = prefs.getInt("CAM_QUALITY_MAX", dCVIEWING_QUALITY);
        	CONTROLLER_TYPEV = prefs.getInt("CONTROLLER_TYPEV", dCONTROLLER_TYPEV);
		
        	DRIVE_TRAIN_P = prefs.getDouble("DRIVE_TRAIN_P", dDRIVE_TRAIN_P);
        	DRIVE_TRAIN_I = prefs.getDouble("DRIVE_TRAIN_I", dDRIVE_TRAIN_I);
        	DRIVE_TRAIN_D = prefs.getDouble("DRIVE_TRAIN_D", dDRIVE_TRAIN_D);
        	DRIVE_TRAIN_A = prefs.getDouble("DRIVE_TRAIN_A", dDRIVE_TRAIN_A);
        	DRIVE_TRAIN_K = prefs.getDouble("DRIVE_TRAIN_K", dDRIVE_TRAIN_K);
		
        	LOWERED_SPEED = prefs.getDouble("LOWERED_SPEED", dLOWERED_SPEED);
        	HOLD_POSITION = prefs.getDouble("HOLD_POSITION", dHOLD_POSITION);
        	
        	ELEVATOR_TIME = prefs.getDouble("RISE_TIME_STEP", dELEVATOR_TIME);
        	DECLINER_TIME = prefs.getDouble("FALL_TIME_STEP", dDECLINER_TIME);
        	
        	CAM_PAN_SPEED = prefs.getDouble("CAM_PAN_SPEED", dCAM_PAN_SPEED);
        	CAM_NEAR_POSY = prefs.getDouble("CAM_NEAR_POSY", dCAM_NEAR_POSY);
        	CAM_DIST_POSY = prefs.getDouble("CAM_DIST_POSY", dCAM_DIST_POSY);
        } // This block gets input from the users preferences to get default values
        oi.currentState = CONTROLLER_TYPEV;
        Vision.teleopInit();
        
        C.out("Yes Master?");
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public final void disabledInit(){
    	oi.disable();
    	C.out("Goodnight Master");
    }

    /**
     * This function is called periodically during operator control
     */
    public final void teleopPeriodic() {
        oi.update();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public final void testPeriodic() {
        LiveWindow.run();
    }
}
