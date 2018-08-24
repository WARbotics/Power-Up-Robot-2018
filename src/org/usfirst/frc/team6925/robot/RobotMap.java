package org.usfirst.frc.team6925.robot;


public class RobotMap {
	//RobotMap is here just to allow to change variables easier 
	//Joystick
	public static int driverJoystick = 0;
	public static int operatorJoystick = 1;
	//Joystick Axis
	public static int joystickMoveAxis = 1;
	public static int joystickRotateAxis = 0; 
	
	//Motors
	public static int frontDrivertrainMotor0 = 1;
	public static int frontDrivertrainMotor1 = 3;
	public static int rearDrivetrainMotor0 = 2;
	public static int rearDrivetrainMotor1 = 4;
	//Cammera
	public static int frontCamera = 0; 
	public static int rearCamera = 1;
	//Intake Motor
	public static int inTakeMotor = 6;
	public static int outTakeMotor = 7;
	//Basket motor
	public static int basketMotor = 9;

	// gyro calibration constant, may need to be adjusted;
	// gyro value of 360 is set to correspond to one full revolution
	public static final double kVoltsPerDegreePerSecond = 0.0128;
	public static final int GyroPort = 0;
}
