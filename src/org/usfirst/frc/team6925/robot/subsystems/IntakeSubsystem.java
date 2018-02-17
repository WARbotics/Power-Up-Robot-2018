package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.Intake;

import edu.wpi.first.wpilibj.Spark;
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
	Spark intakeLeft = new Spark(RobotMap.intakeMotor);
	Spark intakeRight = new Spark(RobotMap.intakeMotor1);
	SpeedControllerGroup intakeLeftController = new SpeedControllerGroup(intakeLeft);
	SpeedControllerGroup intakeRightController = new SpeedControllerGroup(intakeRight);
	DifferentialDrive intakeIN = new DifferentialDrive(intakeLeftController, intakeRightController);

	public void tankDrive(double leftSpeed, double rightSpeed)
	{
		intakeIN.tankDrive(leftSpeed, rightSpeed);
	}
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
    		setDefaultCommand(new Intake());
        //setDefaultCommand(new MySpecialCommand());
    }


}

