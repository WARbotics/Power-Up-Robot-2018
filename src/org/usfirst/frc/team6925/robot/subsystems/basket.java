package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.reload;
import org.usfirst.frc.team6925.robot.commands.shoot;

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
    		setDefaultCommand(new shoot());
    		setDefaultCommand(new reload());
    		
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

