package org.usfirst.frc.team6925.robot.commands;

import org.usfirst.frc.team6925.robot.Robot;
import org.usfirst.frc.team6925.robot.subsystems.basket;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class reload extends Command 
{

    public reload() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.Basket);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    		Robot.Basket.setSpeed(-1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    		Robot.Basket.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    		end();
    }
}
