package org.usfirst.frc.team6925.robot.commands;

import org.usfirst.frc.team6925.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

//ALL VALUES ARE IN INCHES

//We need the following functions:
/*
 * 1. A turn function
 * 2. Constructor that takes in values of starting position and side, OR the constructor just takes in "forward"
 * nvm screw this we do this later.
 */
public class Autonomous {
	private final double WHEEL_DIAMETER = 24.25;
	/*
	private String direction = "";
	private double degrees = 0.0;
	private double speed = 0.0;
	*/
	
	//This is what we can access. We just want to create an object and then run it by typing in object.run(param);
	public Autonomous()
	{
		System.out.println("AUTONOMOUS OBJECT INITIALIZED!");
	}
	
	public void run(String starting_pos, String side) {
		
	}
	public void run(String starting_pos)
	{
		System.out.println("MOVING FORWARD!");
		//this.move(.5, 10);
		
		if (starting_pos.equalsIgnoreCase("left"))
		{
			
		}
		else if (starting_pos.equalsIgnoreCase("middle"))
		{
			
		}
		else if (starting_pos.equalsIgnoreCase("right"))
		{
			
		}
		else
		{
			System.out.println("RUN PARAM CASE INVALID");
		}
	}

	
	//TURN BACK NOW
	private void turn(String direction, double degrees, double v)
	{
		//double r = WHEEL_DIAMETER / 2;
		//double radians = degrees * (Math.PI / 180);
		//double omega = v / r;
		
		
		
		//So to make it easy on my brain, lets do this:
		double rightSpeed = v * -1;
		double leftSpeed = v * 1;
		
		double seconds = 0;
		
		//if we're going to turn left, right needs to move forwards, left move backwards
		if (direction.equalsIgnoreCase("left"))
		{
			Robot.drivetrain.tankDriveRight(rightSpeed);
			Robot.drivetrain.tankDriveLeft(leftSpeed * -1);
			Timer.delay(seconds);
			Robot.drivetrain.tankDriveLeft(0);
			Robot.drivetrain.tankDriveRight(0);
		}
		else if (direction.equalsIgnoreCase("right"))
		{
			Robot.drivetrain.tankDriveRight(rightSpeed * -1);
			Robot.drivetrain.tankDriveRight(leftSpeed);
			Timer.delay(seconds);
			Robot.drivetrain.tankDriveLeft(0);
			Robot.drivetrain.tankDriveRight(0);
		}
	}
	
	private static void move(double speed, double time)
	{
		Robot.drivetrain.tankDriveRight(speed * -1);
		Robot.drivetrain.tankDriveLeft(speed);
		Timer.delay(time);
		Robot.drivetrain.tankDriveRight(speed);
		Robot.drivetrain.tankDriveLeft(speed * -1);		
		Timer.delay(.5);
		Robot.drivetrain.tankDriveRight(0);
		Robot.drivetrain.tankDriveLeft(0);
	}
}
