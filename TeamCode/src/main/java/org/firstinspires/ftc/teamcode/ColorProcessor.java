package org.firstinspires.ftc.teamcode;

import android.graphics.Canvas;
import android.graphics.Point;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;


public class ColorProcessor implements VisionProcessor {

    Rect Center_Rectangle;
     Mat hsvMat = new Mat();
     Mat lowMat = new Mat ();
     Mat highMat = new Mat ();
     Mat detectedMat = new Mat ();

     Scalar lowerRedThresholdlow = new Scalar (0, 125, 125);
     Scalar lowerRedThresholdHigh = new Scalar (0, 255, 255);
     Scalar higherRedThresholdlow = new Scalar (165, 125, 125);
     Scalar higherRedThresholdHigh = new Scalar (180, 255, 255);

     double middleThreshold = 0.1;
     int objPos = 0;

    @Override
    public void init(int width, int height, CameraCalibration calibration) {
        Center_Rectangle = new Rect();
        new Point (0,0);
        new Point(0,0);
    }

    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {

        Imgproc.cvtColor(frame, hsvMat, Imgproc.COLOR_RGB2HSV);
        Core.inRange(hsvMat, lowerRedThresholdlow, lowerRedThresholdHigh, lowMat);
        Core.inRange(hsvMat, higherRedThresholdlow, higherRedThresholdHigh, highMat);

        Core.bitwise_or(lowMat, highMat, detectedMat);

        double middlePercent = (Core.sumElems(detectedMat.submat(Center_Rectangle)).val[0]/255/Center_Rectangle.area());
        if (middlePercent > middleThreshold) {
            objPos = 1;
        }
        else objPos = 0;
        return null;
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {

        // Red Left Side: 0-20
        //Red Right Side: 340-360
        //Value Red Right Side: 100-50
        //Saturation Red Right Side: 100-65

    
    }
}


