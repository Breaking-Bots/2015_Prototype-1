package org.usfirst.frc.team5428.robot.vision;

import org.usfirst.frc.team5428.robot.Robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public final class Vision {
	public static CameraServer server;
	
	public final static void init(){
		server = CameraServer.getInstance();
	}
	
	public final static void teleopInit(){
		 server.setQuality(Robot.CVIEWING_QUALITY);
		 if(!server.isAutoCaptureStarted()) server.startAutomaticCapture("cam1");
	}
	
	
	public final static void teleopTerminate(){
	}
	
	public final static void stream()
	{	        
	}
}
