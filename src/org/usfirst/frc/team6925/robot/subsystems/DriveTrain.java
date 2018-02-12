package org.usfirst.frc.team6925.robot.subsystems;
//

import org.usfirst.frc.team6925.robot.Robot;
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
	public static VictorSP m_frontLeftPWM;
	public static VictorSP m_frontRightPWM; 
	public static VictorSP m_rearLeftPWM;
	public static VictorSP m_rearRightPWM;
	
	public DriveTrain() 
	{

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
		System.out.println("driveTrain was called");
		
	}

		
	}


