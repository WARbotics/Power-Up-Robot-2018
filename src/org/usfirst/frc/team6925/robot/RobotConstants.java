package org.usfirst.frc.team6925.robot;


public class RobotMap {
	//RobotMap is here just to allow to change variables easier 
	//Joystick
	public static int JOYSTICK_PORT = 0;
	public static int OP_JOYSTICK_PORT = 1;
	//Joystick Axis
	public static int JOYSTICK_MOVE_AXIS= 1;
	public static int JOYSTICK_ROTATE_AXIS = 0; 
	
	//Motors
	public static int MOTOR_FRONT_LEFT = 1;
	public static int MOTOR_FRONT_RIGHT = 3;
	public static int REAR_LEFT_MOTOR = 2;
	public static int REAR_RIGHT_MOTOR = 4;
	//Cammera
	public static int FRONT_CAMERA = 0; 
	public static int BACK_CAMERA = 1;
	//Intake Motor
	public static int INTAKE_MOTOR = 6;
	public static int INTAKE_MOTOR_1 = 7;
	//Basket motor
	public static int BASKET_MOTOR = 9;

	// gyro calibration constant, may need to be adjusted;
	// gyro value of 360 is set to correspond to one full revolution
	public static final double kVoltsPerDegreePerSecond = 0.0128;
	public static final int kGyroPort = 0;
}
