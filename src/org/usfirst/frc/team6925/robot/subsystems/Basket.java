package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *
 */
public class Basket extends Subsystem 
{

    private Spark basketMotor; 
    SpeedControllerGroup basket;
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Basket() 
	{
		basketMotor = new Spark(RobotMap.basketMotor);
		basket = new SpeedControllerGroup(basketMotor);
	}
	public void setSpeed(double inputSpeed) 
	{
		System.out.println("Input speed: " + inputSpeed + ", setting basketMotor to " +inputSpeed);
		//Decided to 
		this.basket.set(inputSpeed);
		System.out.println("VALUE OF SPARK: " + basketMotor.get());
	}
	
    public void initDefaultCommand() {
    		
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

