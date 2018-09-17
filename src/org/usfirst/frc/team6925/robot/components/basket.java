package org.usfirst.frc.team6925.robot.components;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class basket{
    public Spark basketMotor; 
    public SpeedControllerGroup basketMotorGroup;
    
    public void basketComponents(){
    	basketMotor = new Spark(0);
		basketMotorGroup = new SpeedControllerGroup(basketMotor);
    }
    public void setBasket(double inputSpeed){
		basketMotor.set(inputSpeed);
	}
}