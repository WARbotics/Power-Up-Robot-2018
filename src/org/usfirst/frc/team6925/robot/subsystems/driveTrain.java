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
		// Motor in the front and to the left of the robot 
		DriveTrainMotor0 = new VictorSP(RobotContants.MOTOR_FRONT_LEFT);		
		frontRightMotor = new VictorSP(RobotMap.m_frontRightMotor);
		rearLeftMotor = new VictorSP(RobotMap.m_rearLeftMotor);
		rearRightMotor = new VictorSP(RobotMap.m_rearRightMotor);
		
		
		leftMotorGroup = new SpeedControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
		rightMotorGroup = new SpeedControllerGroup(m_frontRightMotor, m_rearRightMotor);

		leftMotorGroup.setInverted(true);
		
		basketMotor = new Spark(RobotMap.basketMotor);
		basketMotorGroup = new SpeedControllerGroup(basketMotor);

		
		leftIntakeMotor = new Spark(RobotMap.);
		leftIntakeMotor.setInverted(true);
		rightIntakeMotor = new Spark(RobotMap.intakeMotor1);

		
		
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


