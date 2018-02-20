	package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *
 */
public class basket extends Subsystem 
{

    private Spark basketMotor; 
    SpeedControllerGroup basket;
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public basket() 
	{
		basketMotor = new Spark(RobotMap.basketMotor);
		basket = new SpeedControllerGroup(basketMotor);
	}
	public void setSpeed(double inputSpeed) 
	{
		basket.set(inputSpeed);
		System.out.println("Input speed: " + inputSpeed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

