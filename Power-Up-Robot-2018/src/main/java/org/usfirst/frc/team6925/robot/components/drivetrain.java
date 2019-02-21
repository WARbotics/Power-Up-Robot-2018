package org.usfirst.frc.team6925.robot.components;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
public class drivetrain{
	//Creating VictorSP motors 
	public VictorSP driveTrainMotor0;
	public VictorSP driveTrainMotor1; 
	public VictorSP driveTrainMotor2;
	public VictorSP driveTrainMotor3;
	//creating the PWM speed controllers 

	public SpeedControllerGroup leftMotorGroup;
	public SpeedControllerGroup rightMotorGroup;
	public DifferentialDrive m_drive;

	public drivetrain(){
		// DriveTrain Motor  
		driveTrainMotor0 = new VictorSP(1);		
		driveTrainMotor1 = new VictorSP(2);
		driveTrainMotor2 = new VictorSP(3);
		driveTrainMotor3 = new VictorSP(4);
		leftMotorGroup = new SpeedControllerGroup(driveTrainMotor0, driveTrainMotor1);
		rightMotorGroup = new SpeedControllerGroup(driveTrainMotor2, driveTrainMotor3);
		
		m_drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
		
		

	}
   public void setSpeedLeft(double inputSpeedLeft){
	   leftMotorGroup.set(inputSpeedLeft);
	
   }
   public void setSpeedRight(double inputSpeedRight){
	   rightMotorGroup.set(inputSpeedRight);
   }
}


