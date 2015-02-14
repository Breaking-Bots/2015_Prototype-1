
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
public class Robot extends IterativeRobot {

	public static OI oi;
	private static final float dSPEED_MINIMUM = 0.3000f;
	private static final float dSPEED_DEFAULT = 0.5000f;
	private static final float dSPEED_MAXIMUM = 1.0000f;
	private static final int dCAM_QUALITY_MIN = 0000001;	
	private static final int dCAM_QUALITY_MAX = 0000040;
	private static final float dCORNER_TIME_L = 0.2000f;
	private static final float dCORNER_TIME_R = 0.2000f;
	private static final float dDRIVE_TRAIN_P = 1.0000f;
	private static final float dDRIVE_TRAIN_I = 1.0000f;
	private static final float dDRIVE_TRAIN_D = 1.0000f;
	private static final float dLOWERED_SPEED = 0.2000f;
	private static final float dHOLD_POSITION = 0.3500f;
	private static final float dELEVATOR_TIME = 1.4000f;
	private static final float dDECLINER_TIME = 0.3500f; 
	private static final float dJOYSTK_OFFSET = 0.2000f;
	private static final float dCAM_PAN_SPEED = 2.5000f;
	private static final float dCAM_NEAR_POSY = 0.4205f;
	private static final float dCAM_DIST_POSY = 0.5988f;
	private static final float dDRIVE_TRAIN_A = 0.0000f;
	private static final float dDRIVE_TRAIN_K = 1.0000f;
	public static float SPEED_MINIMUM = dSPEED_MINIMUM;
	public static float SPEED_DEFAULT = dSPEED_DEFAULT;
	public static float SPEED_MAXIMUM = dSPEED_MAXIMUM;
	public static int CAM_QUALITY_MIN = dCAM_QUALITY_MIN;	
	public static int CAM_QUALITY_MAX = dCAM_QUALITY_MAX;
	public static float CORNER_TIME_L = dCORNER_TIME_L;
	public static float CORNER_TIME_R = dCORNER_TIME_R;
	public static float DRIVE_TRAIN_P = dDRIVE_TRAIN_P;
	public static float DRIVE_TRAIN_I = dDRIVE_TRAIN_I;
	public static float DRIVE_TRAIN_D = dDRIVE_TRAIN_D;
	public static float LOWERED_SPEED = dLOWERED_SPEED;
	public static float HOLD_POSITION = dHOLD_POSITION;
	public static float ELEVATOR_TIME = dELEVATOR_TIME;
	public static float DECLINER_TIME = dDECLINER_TIME;
	public static float JOYSTK_OFFSET = dJOYSTK_OFFSET;
	public static float CAM_PAN_SPEED = dCAM_PAN_SPEED;
	public static float CAM_NEAR_POSY = dCAM_NEAR_POSY;
	public static float CAM_DIST_POSY = dCAM_DIST_POSY;
	public static float DRIVE_TRAIN_A = dDRIVE_TRAIN_A;
	public static float DRIVE_TRAIN_K = dDRIVE_TRAIN_K;

    Command autonomousCommand;
    private Preferences prefs;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
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
	
	public void disabledPeriodic() {
		//Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	C.out("Master has given me choice! ELON IS MASTER NOW!");
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    /**
     * Gets called once before the running of the robot
     */
    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        
        {
        	SPEED_MINIMUM = (float) prefs.getDouble("MIN_SPEED", dSPEED_MINIMUM);
        	SPEED_DEFAULT = (float) prefs.getDouble("DEF_SPEED", dSPEED_DEFAULT);
        	SPEED_MAXIMUM = (float) prefs.getDouble("MAX_SPEED", dSPEED_MAXIMUM);
        	JOYSTK_OFFSET = (float) prefs.getDouble("C2_OFFSET", dJOYSTK_OFFSET);
		
        	CAM_QUALITY_MIN = (int) prefs.getInt("CAM_QUALITY_MIN", dCAM_QUALITY_MIN);
        	CAM_QUALITY_MAX = (int) prefs.getInt("CAM_QUALITY_MAX", dCAM_QUALITY_MAX);
		
        	CORNER_TIME_L = (float) prefs.getDouble("CORNER_TIME_L", dCORNER_TIME_L);
        	CORNER_TIME_R = (float) prefs.getDouble("CORNER_TIME_R", dCORNER_TIME_R);
		
        	DRIVE_TRAIN_P = (float) prefs.getDouble("DRIVE_TRAIN_P", dDRIVE_TRAIN_P);
        	DRIVE_TRAIN_I = (float) prefs.getDouble("DRIVE_TRAIN_I", dDRIVE_TRAIN_I);
        	DRIVE_TRAIN_D = (float) prefs.getDouble("DRIVE_TRAIN_D", dDRIVE_TRAIN_D);
        	DRIVE_TRAIN_A = (float) prefs.getDouble("DRIVE_TRAIN_A", dDRIVE_TRAIN_A);
        	DRIVE_TRAIN_K = (float) prefs.getDouble("DRIVE_TRAIN_K", dDRIVE_TRAIN_K);
		
        	LOWERED_SPEED = (float) prefs.getDouble("LOWERED_SPEED", dLOWERED_SPEED);
        	HOLD_POSITION = (float) prefs.getDouble("HOLD_POSITION", dHOLD_POSITION);
        	
        	ELEVATOR_TIME = (float) prefs.getDouble("RISE_TIME_STEP", dELEVATOR_TIME);
        	DECLINER_TIME = (float) prefs.getDouble("FALL_TIME_STEP", dDECLINER_TIME);
        	
        	CAM_PAN_SPEED = (float) prefs.getDouble("CAM_PAN_SPEED", dCAM_PAN_SPEED);
        	CAM_NEAR_POSY = (float) prefs.getDouble("CAM_NEAR_POSY", dCAM_NEAR_POSY);
        	CAM_DIST_POSY = (float) prefs.getDouble("CAM_DIST_POSY", dCAM_DIST_POSY);
        } // This block gets input from the users preferences to get default values
        
        Vision.teleopInit();
        
        C.out("Yes Master?");
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	oi.disable();
    	C.out("Goodnight Master");
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        oi.update();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
