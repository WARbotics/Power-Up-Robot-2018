package org.usfirst.frc.team6925.robot.components;
import edu.wpi.first.wpilibj.Spark;

public class basket{
    public Spark basketMotor; 
    
    public basket(){
    	basketMotor = new Spark(9);
    	
    	
    }
    public void setBasket(double inputSpeed){
		basketMotor.set(inputSpeed);
	}
}