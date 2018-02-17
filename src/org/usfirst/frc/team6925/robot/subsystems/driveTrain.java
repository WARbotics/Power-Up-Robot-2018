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


	//drivetrain
	public driveTrain() 
	{
		System.out.println("We are calling DriveTrain");
		m_frontLeftMotor = new VictorSP(1);
		m_frontRightMotor = new VictorSP(3);
		m_rearLeftMotor = new VictorSP(2);
		m_rearRightMotor = new VictorSP(4);
		
		m_Left = new SpeedControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
		m_Right = new SpeedControllerGroup(m_frontRightMotor, m_rearRightMotor);
		robotDrive = new DifferentialDrive(m_Left, m_Right);
		System.out.println("end of driveTrain method");
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

