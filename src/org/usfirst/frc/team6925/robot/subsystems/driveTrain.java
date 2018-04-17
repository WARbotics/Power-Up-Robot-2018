package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

public class driveTrain
{
	//Creating VictorSP motors 
	private VictorSP m_frontLeftMotor;
	private VictorSP m_frontRightMotor; 
	private VictorSP m_rearLeftMotor;
	private VictorSP m_rearRightMotor;
	//creating the PWM speed controllers 

	public SpeedControllerGroup m_Left;
	public SpeedControllerGroup m_Right;
    public Spark basketMotor; 
    public SpeedControllerGroup basket;
    
	private Spark intakeLeft;
	private Spark intakeRight;
	SpeedControllerGroup intakeController;	
	
	public driveTrain() 
	{
		m_frontLeftMotor = new VictorSP(RobotMap.m_frontLeftMotor);		
		m_frontRightMotor = new VictorSP(RobotMap.m_frontRightMotor);
		m_rearLeftMotor = new VictorSP(RobotMap.m_rearLeftMotor);
		m_rearRightMotor = new VictorSP(RobotMap.m_rearRightMotor);
		
		
		m_Left = new SpeedControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
		m_Right = new SpeedControllerGroup(m_frontRightMotor, m_rearRightMotor);
		m_Left.setInverted(true);
		
		basketMotor = new Spark(RobotMap.basketMotor);
		
		basket = new SpeedControllerGroup(basketMotor);

		
		intakeLeft = new Spark(RobotMap.intakeMotor);
		intakeLeft.setInverted(true);
		intakeRight = new Spark(RobotMap.intakeMotor1);

		
		
		intakeController = new SpeedControllerGroup(intakeLeft, intakeRight);
		

	}
	public void setBasket(double inputSpeed)
	{
		this.basket.set(inputSpeed);
	}
	public void setIntakeSpeed(double inputIntakeSpeed)
	{
		intakeController.set(inputIntakeSpeed);
	}
   public void setSpeedLeft(double inputSpeedLeft)
   {
	   
	   m_Left.set(inputSpeedLeft);
	
   }
   public void setSpeedRight(double inputSpeedRight)
   {
	   m_Right.set(inputSpeedRight);
   }
}


