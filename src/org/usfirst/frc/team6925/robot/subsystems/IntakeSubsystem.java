package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.Intake;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

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
		Spark intakeLeft = new Spark(0);
		Spark intakeRight = new Spark(1);
		
		SpeedControllerGroup intakeController = new SpeedControllerGroup(intakeLeft, intakeRight);
	}
	public void setIntakeSpeed(double inputIntakeSpeed)
	{
		intakeController.set(inputIntakeSpeed);
	}
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
    		setDefaultCommand(new Intake());
        //setDefaultCommand(new MySpecialCommand());
    }


}

