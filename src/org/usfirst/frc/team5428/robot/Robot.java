
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
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	private static final float dSPEED_MINIMUM = 0.30f;
	private static final float dSPEED_DEFAULT = 0.50f;
	private static final float dSPEED_MAXIMUM = 1.00f;
	private static final int dCAM_QUALITY_MIN = 00001;	
	private static final int dCAM_QUALITY_MAX = 00030;
	private static final float dCORNER_TIME_L = 0.20f;
	private static final float dCORNER_TIME_R = 0.20f;
	private static final float dDRIVE_TRAIN_P = 0.03f;
	private static final float dLOWERED_SPEED = 0.20f;
	private static final float dHOLD_POSITION = 0.35f;
	private static final float dELEVATOR_TIME = 1.40f;
	private static final float dDECLINER_TIME = 0.35f;
	public static float SPEED_MINIMUM = dSPEED_MINIMUM;
	public static float SPEED_DEFAULT = dSPEED_DEFAULT;
	public static float SPEED_MAXIMUM = dSPEED_MAXIMUM;
	public static int CAM_QUALITY_MIN = dCAM_QUALITY_MIN;	
	public static int CAM_QUALITY_MAX = dCAM_QUALITY_MAX;
	public static float CORNER_TIME_L = dCORNER_TIME_L;
	public static float CORNER_TIME_R = dCORNER_TIME_R;
	public static float DRIVE_TRAIN_P = dDRIVE_TRAIN_P;
	public static float LOWERED_SPEED = dLOWERED_SPEED;
	public static float HOLD_POSITION = dHOLD_POSITION;
	public static float ELEVATOR_TIME = dELEVATOR_TIME;
	public static float DECLINER_TIME = dDECLINER_TIME;

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
		
        	CAM_QUALITY_MIN = (int) prefs.getInt("CAM_QUALITY_MIN", dCAM_QUALITY_MIN);
        	CAM_QUALITY_MAX = (int) prefs.getInt("CAM_QUALITY_MAX", dCAM_QUALITY_MAX);
		
        	CORNER_TIME_L = (float) prefs.getDouble("CORNER_TIME_L", dCORNER_TIME_L);
        	CORNER_TIME_R = (float) prefs.getDouble("CORNER_TIME_R", dCORNER_TIME_R);
		
        	DRIVE_TRAIN_P = (float) prefs.getDouble("DRIVE_TRAIN_P", dDRIVE_TRAIN_P);
		
        	LOWERED_SPEED = (float) prefs.getDouble("LOWERED_SPEED", dLOWERED_SPEED);
        	HOLD_POSITION = (float) prefs.getDouble("HOLD_POSITION", dHOLD_POSITION);
        	
        	ELEVATOR_TIME = (float) prefs.getDouble("RISE_TIME_STEP", dELEVATOR_TIME);
        	DECLINER_TIME = (float) prefs.getDouble("FALL_TIME_STEP", dDECLINER_TIME);
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
