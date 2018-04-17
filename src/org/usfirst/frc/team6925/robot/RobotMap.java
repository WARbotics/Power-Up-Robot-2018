package org.usfirst.frc.team6925.robot;


public class RobotMap {
	//RobotMap is here just to allow to change variables easier 
	//Joystick
	public static int joystick_port = 0;
	public static int OP_joystick_Port = 1;
	//Joystick Axis
	public static int Joystick_Move_Axis = 1;
	public static int Joystick_Rotate_Axis = 0; 
	
	//Motors
	public static int m_frontLeftMotor = 1;
	public static int m_frontRightMotor = 3;
	public static int m_rearLeftMotor = 2;
	public static int m_rearRightMotor = 4;
	//Cammera
	public static int frontCamera = 0; 
	public static int backCamera = 1;
	//Intake Motor
	public static int intakeMotor = 6;
	public static int intakeMotor1 = 7;
	//Basket motor
	public static int basketMotor = 9;

	// gyro calibration constant, may need to be adjusted;
	// gyro value of 360 is set to correspond to one full revolution
	public static final double kVoltsPerDegreePerSecond = 0.0128;
	public static final int kGyroPort = 0;
}
