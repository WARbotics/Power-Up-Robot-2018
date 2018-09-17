package org.usfirst.frc.team6925.robot.components;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class intake{
    
		public Spark leftIntakeMotor;
		public Spark rightIntakeMotor;
		public SpeedControllerGroup intakeMotorGroup;
	public void intakeComponents(){
		leftIntakeMotor = new Spark(0);
		leftIntakeMotor.setInverted(true);
		rightIntakeMotor = new Spark(1);
		intakeMotorGroup = new SpeedControllerGroup(leftIntakeMotor, rightIntakeMotor);
		
	}
	public void setIntake(double inputIntakeSpeed){
		intakeMotorGroup.set(inputIntakeSpeed);
	}
}