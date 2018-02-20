package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.tankDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class driveTrain extends Subsystem 
{
	//Creating VictorSP motors 
	private VictorSP m_frontLeftMotor;
	private VictorSP m_frontRightMotor; 
	private VictorSP m_rearLeftMotor;
	private VictorSP m_rearRightMotor;
	//creating the PWM speed controllers 

	SpeedControllerGroup m_Left;
	SpeedControllerGroup m_Right;
	
	//drivetrain
	public driveTrain() 
	{
		System.out.println("We are calling DriveTrain");
		m_frontLeftMotor = new VictorSP(RobotMap.m_frontLeftMotor);
		m_frontRightMotor = new VictorSP(RobotMap.m_frontRightMotor);
		m_rearLeftMotor = new VictorSP(RobotMap.m_rearLeftMotor);
		m_rearRightMotor = new VictorSP(RobotMap.m_rearRightMotor);
		
		m_Left = new SpeedControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
		m_Right = new SpeedControllerGroup(m_frontRightMotor, m_rearRightMotor);
		System.out.println("end of driveTrain method");
	}

   public void tankDriveLeft(double inputSpeedLeft)
   {
	   m_Left.set(inputSpeedLeft);
   }
   public void tankDriveRight(double inputSpeedRight)
   {
	   m_Right.set(inputSpeedRight);
   }
   public void initDefaultCommand() 
    {
		setDefaultCommand(new tankDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

