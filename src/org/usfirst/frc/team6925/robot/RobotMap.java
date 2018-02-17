package org.usfirst.frc.team6925.robot;

public class RobotMap {
	//RobotMap is here just to allow to change variables easier 
	
	public static int joystick_port = 0;
	public static int m_driveController = 1; 
	public static int m_frontLeftMotor = 1;
	public static int m_frontRightMotor = 3;
	public static int m_rearLeftMotor = 2;
	public static int m_rearRightMotor = 4;
	public static int frontCamera = 0; 
	public static int intakeMotor = 0;
	public static int intakeMotor1 = 1;
	public static int Joystick_Move_Axis = 1;
	public static int Joystick_Rotate_Axis = 0; 
	
	public static final double kAngleSetpoint = 0.0;
	public static final double kP = 0.005; // propotional turning constant

	// gyro calibration constant, may need to be adjusted;
	// gyro value of 360 is set to correspond to one full revolution
	public static final double kVoltsPerDegreePerSecond = 0.0128;
	public static final int kGyroPort = 0;
}
