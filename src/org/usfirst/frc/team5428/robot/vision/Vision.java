package org.usfirst.frc.team5428.robot.vision;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Vision {
	private static Image frame;
	private static int session;
	
	public static void init(){
		 frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

	        // the camera name (ex "cam0") can be found through the roborio web interface
	        session = NIVision.IMAQdxOpenCamera("cam0",
	                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	        NIVision.IMAQdxConfigureGrab(session);
	}
	
	public static void teleopInit(){
		NIVision.IMAQdxStartAcquisition(session);
	}
	
	
	public static void teleopTerminate(){
		 NIVision.IMAQdxStopAcquisition(session);
	}
	
	public static void stream()
	{	        
		NIVision.IMAQdxGrab(session, frame, 1);
		CameraServer.getInstance().setQuality(0);
        CameraServer.getInstance().setImage(frame);
        CameraServer.getInstance().setQuality(0);
	}
}
