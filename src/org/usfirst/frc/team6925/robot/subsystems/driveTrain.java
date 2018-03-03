package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.Robot;
import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.tankDrive;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
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
    public Spark basketMotor; 
    public SpeedControllerGroup basket;
    
	private Spark intakeLeft;
	private Spark intakeRight;
	SpeedControllerGroup intakeController;	
	//drivetrain
	public driveTrain() 
	{
		m_frontLeftMotor = new VictorSP(RobotMap.m_frontLeftMotor);
		m_frontRightMotor = new VictorSP(RobotMap.m_frontRightMotor);
		m_rearLeftMotor = new VictorSP(RobotMap.m_rearLeftMotor);
		m_rearRightMotor = new VictorSP(RobotMap.m_rearRightMotor);
		
		//cool motor = new Spark(4);
		
		m_Left = new SpeedControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
		m_Right = new SpeedControllerGroup(m_frontRightMotor, m_rearRightMotor);
		
		
		basketMotor = new Spark(RobotMap.basketMotor);
		
		basket = new SpeedControllerGroup(basketMotor);
		
		intakeLeft = new Spark(RobotMap.intakeMotor);
		intakeRight = new Spark(RobotMap.intakeMotor);

		intakeController = new SpeedControllerGroup(intakeLeft, intakeRight);
		//intakeLeft = new Spark(RobotMap.intakeMotor);
		//intakeRight = new Spark(RobotMap.intakeMotor1);
		
		//intakeController = new SpeedControllerGroup(intakeLeft, intakeRight);
		
	}
	public void setBasket(double inputSpeed)
	{
		System.out.println("Input speed: " + inputSpeed + ", setting basketMotor to " +inputSpeed);
		//Decided to 
		this.basket.set(inputSpeed);
		System.out.println("VALUE OF SPARK: " + basketMotor.get());
	}
	public void setIntakeSpeed(double inputIntakeSpeed)
	{
		System.out.println("setIntakeSpeed accessed! inputIntakeSpeed = " + inputIntakeSpeed + ", setting to intakeController.");
		intakeController.set(inputIntakeSpeed);
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

