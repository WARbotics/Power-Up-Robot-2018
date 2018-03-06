package org.usfirst.frc.team6925.robot;
/*
Example Code
Robot.drivetrain.setSpeedLeft(.5); 
Robot.drivetrain.setSpeedRight(.5); // This is drive straight
timer.delay(1); // In seconds
Robot.drivetrain.setSpeedLeft(0); 
Robot.drivetrain.setSpeedRight(0);
Robot.intake.setIntakeSpeed(1);
timer.delay(1);
 */
public class Turn {
	public static void run(String direction, double degree, double speed)
	{
		if (direction.equals("LEFT"))
		{
			Robot.drivetrain.setSpeedLeft(speed * -1);
			Robot.drivetrain.setSpeedRight(speed);
		}
		else if (direction.equals("RIGHT"))
		{
			Robot.drivetrain.setSpeedLeft(speed);
			Robot.drivetrain.setSpeedRight(speed * -1);
		}
		else
		{
			System.out.println("ERROR: DIRECTION NOT LEFT OR RIGHT.");
		}

	}
}
