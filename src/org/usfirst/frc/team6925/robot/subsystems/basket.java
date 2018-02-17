	package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class basket extends Subsystem 
{

    private Spark basketMotor; 
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	public basket() 
	{
		Spark basketMotor = new Spark(RobotMap.basketMotor);
	}
	public void setSpeed(double inputSpeed) 
	{
		basketMotor.set(inputSpeed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

