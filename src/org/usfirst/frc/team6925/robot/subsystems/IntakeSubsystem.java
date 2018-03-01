package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.Intake;
import org.usfirst.frc.team6925.robot.commands.IntakeOut;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem 
{
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Spark intakeLeft;
	private Spark intakeRight;
	SpeedControllerGroup intakeController;

	public IntakeSubsystem() 
	{
		intakeLeft = new Spark(RobotMap.intakeMotor);
		intakeRight = new Spark(RobotMap.intakeMotor1);
		
		intakeController = new SpeedControllerGroup(intakeLeft, intakeRight);
	}
	public void setIntakeSpeed(double inputIntakeSpeed)
	{
		System.out.println("setIntakeSpeed accessed! inputIntakeSpeed = " + inputIntakeSpeed + ", setting to intakeController.");
		intakeController.set(inputIntakeSpeed);
	}
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
    		setDefaultCommand(new Intake());
    		setDefaultCommand(new IntakeOut());
        //setDefaultCommand(new MySpecialCommand());
    }


}

