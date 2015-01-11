package org.usfirst.frc.team5428.robot.vision;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Vision {
	private static Image frame;
	private static AxisCamera camera;
	
	public static void init(){
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB,  0);
		camera = new AxisCamera("10.54.28.100"); //TODO: .100 may not be right
	}
	
	public static void stream()
	{	        
        camera.getImage(frame);
		NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
        NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
        CameraServer.getInstance().setImage(frame);
	}
}
