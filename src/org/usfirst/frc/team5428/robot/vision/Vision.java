package org.usfirst.frc.team5428.robot.vision;

import org.usfirst.frc.team5428.robot.Robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Vision {
	public static CameraServer server;
	
	public static void init(){
		server = CameraServer.getInstance();
	}
	
	public static void teleopInit(){
		 server.setQuality(Robot.CAM_QUALITY_MAX);
		 if(!server.isAutoCaptureStarted()) server.startAutomaticCapture("cam1");
	}
	
	
	public static void teleopTerminate(){
	}
	
	public static void stream()
	{	        
	}
}
