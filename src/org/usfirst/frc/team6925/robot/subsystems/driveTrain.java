package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.driveArcade;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class driveTrain extends Subsystem 
{
	//creating the PWM speed controllers 
	private VictorSP m_frontLeftMotor;
	private VictorSP m_frontRightMotor; 
	private VictorSP m_rearLeftMotor;
	private VictorSP m_rearRightMotor;

	SpeedControllerGroup m_Left;
	SpeedControllerGroup m_Right;
	
	DifferentialDrive robotDrive;



	public driveTrain() 
	{
		m_frontLeftMotor = new VictorSP(RobotMap.m_frontLeftMotor);
		m_frontRightMotor = new VictorSP(RobotMap.m_frontRightMotor);
		m_rearLeftMotor = new VictorSP(RobotMap.m_rearLeftMotor);
		m_rearRightMotor = new VictorSP(RobotMap.m_rearRightMotor);
		
		m_Left = new SpeedControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
		m_Right = new SpeedControllerGroup(m_frontRightMotor, m_rearRightMotor);
		robotDrive = new DifferentialDrive(m_Left, m_Right);
	}

   public void arcadeDrive(double moveSpeed, double rotateSpeed) 
   {
	   robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
   }
	public void initDefaultCommand() 
    {
		setDefaultCommand(new driveArcade());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

