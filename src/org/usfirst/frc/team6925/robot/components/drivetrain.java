package org.usfirst.frc.team6925.robot.components;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

public class drivetrain{
	//Creating VictorSP motors 
	public VictorSP driveTrainMotor0;
	public VictorSP driveTrainMotor1; 
	public VictorSP driveTrainMotor2;
	public VictorSP driveTrainMotor3;
	//creating the PWM speed controllers 

	public SpeedControllerGroup leftMotorGroup;
	public SpeedControllerGroup rightMotorGroup;	
	
	public void driveTrainComponents(){
		// DriveTrain Motor  
		VictorSP driveTrainMotor0 = new VictorSP(0);		
		VictorSP driveTrainMotor1 = new VictorSP(1);
		VictorSP driveTrainMotor2 = new VictorSP(2);
		VictorSP driveTrainMotor3 = new VictorSP(3);
		SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(driveTrainMotor0, driveTrainMotor1);
		SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(driveTrainMotor2, driveTrainMotor3);
		leftMotorGroup.setInverted(true);
		

	}
   public void setSpeedLeft(double inputSpeedLeft){
	   leftMotorGroup.set(inputSpeedLeft);
	
   }
   public void setSpeedRight(double inputSpeedRight){
	   rightMotorGroup.set(inputSpeedRight);
   }
}


