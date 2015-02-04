
package org.usfirst.frc.team5428.robot;

import org.usfirst.frc.team5428.robot.commands.AutoBasicRush;
import org.usfirst.frc.team5428.robot.core.C;
import org.usfirst.frc.team5428.robot.core.CommandBase;
import org.usfirst.frc.team5428.robot.vision.Vision;

import edu.wpi.first.wpilibj.IterativeRobot;
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
	public static float SPEED_MINIMUM = 0.30f;
	public static float SPEED_DEFAULT = 0.50f;
	public static float SPEED_MAXIMUM = 1.00f;
	public static int CAM_QUALITY_MIN = 00001;	
	public static int CAM_QUALITY_MAX = 00030;
	public static float CORNER_TIME_L = 0.20f;
	public static float CORNER_TIME_R = 0.20f;
	public static float DRIVE_TRAIN_P = 0.03f;
	public static float LOWERED_SPEED = 0.20f;
	public static float HOLD_POSITION = 0.35f;

    Command autonomousCommand;

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
		//Vision.init();
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

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        C.out("Yes Master?");
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
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
