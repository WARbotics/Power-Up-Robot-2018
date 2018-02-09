package org.usfirst.frc.team6925.robot.subsystems;
//

import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 * The DriveTrain subsystem controls the robot's chassis and reads in
 * information about it's speed and position.
 */
public class DriveTrain extends Subsystem 
{
	//creating the PWM speed controllers 
	private VictorSP m_frontLeftPWM;
	private VictorSP m_frontRightPWM; 
	private VictorSP m_rearLeftPWM;
	private VictorSP m_rearRightPWM;
	
	//creating the motors(victorSP) 
	public static VictorSP m_frontLeftMotor = new VictorSP(RobotMap.m_frontLeftMotor);
	public static VictorSP m_frontRightMotor = new VictorSP(RobotMap.m_frontRightMotor);
	
	public static VictorSP m_rearLeftMotor = new VictorSP(RobotMap.m_rearLeftMotor);
	public static VictorSP m_rearRightMotor = new VictorSP(RobotMap.m_rearRightMotor);
	//place the the motor into speed control based on left or right
	SpeedControllerGroup m_Left = new SpeedControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
	SpeedControllerGroup m_Right = new SpeedControllerGroup(m_rearRightMotor, m_rearRightMotor);
	
	public DriveTrain() 
	{
		System.out.println("The wrong driveTrain was called ;(");
	}

	@Override
	protected void initDefaultCommand() 
	{
		//When robot init happens it calls this 
		DriveWithJoystick.drive(); //this calls the joystick
		System.out.println("init of defualt command");
		
	}
	public void driveTrainJoystick(Joystick controller) 
	{
		DriveWithJoystick.drive();//calls the joystick
		//constructs the VictorSP PWM speed controllers 
		m_frontLeftPWM = new VictorSP(RobotMap.m_frontLeftPWM);
		m_frontRightPWM = new VictorSP(RobotMap.m_frontRightPWM);
		m_rearLeftPWM = new VictorSP(RobotMap.m_rearLeftPWM);
		m_rearRightPWM = new VictorSP(RobotMap.m_rearRightPWM);
		System.out.println("driveTrain was called");
		
	}

}
