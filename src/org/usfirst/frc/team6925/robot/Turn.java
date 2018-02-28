package org.usfirst.frc.team6925.robot;
/*
Example Code
Robot.drivetrain.tankDriveLeft(.5); 
Robot.drivetrain.tankDriveRight(.5); // This is drive straight
timer.delay(1); // In seconds
Robot.drivetrain.tankDriveLeft(0); 
Robot.drivetrain.tankDriveRight(0);
Robot.intake.setIntakeSpeed(1);
timer.delay(1);
 */
public class Turn {
	public static void run(String direction, double degree, double speed)
	{
		if (direction.equals("LEFT"))
		{
			Robot.drivetrain.tankDriveLeft(speed * -1);
			Robot.drivetrain.tankDriveRight(speed);
		}
		else if (direction.equals("RIGHT"))
		{
			Robot.drivetrain.tankDriveLeft(speed);
			Robot.drivetrain.tankDriveRight(speed * -1);
		}
		else
		{
			System.out.println("ERROR: DIRECTION NOT LEFT OR RIGHT.");
		}

	}
}
