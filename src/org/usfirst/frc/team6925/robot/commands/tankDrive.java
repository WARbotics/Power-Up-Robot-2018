package org.usfirst.frc.team6925.robot.commands;

import org.usfirst.frc.team6925.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class tankDrive extends Command 
{

    public tankDrive() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double inputSpeed = Robot.oi.drive_Joystick.getRawAxis(2);
    	double inputSpeedRight = Robot.oi.drive_Joystick.getRawAxis(5);
    	Robot.drivetrain.tankDriveLeft(inputSpeed);
    	Robot.drivetrain.tankDriveRight(inputSpeedRight);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.drivetrain.tankDriveLeft(0);
    	Robot.drivetrain.tankDriveRight(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    }
}
