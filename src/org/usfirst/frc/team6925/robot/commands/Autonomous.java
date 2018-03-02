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
		//This should serve four cases:
		/*
		 * 1. Left right
		 * 2. Right left
		 * 3. Middle left
		 * 4. Middle right
		 */
	}
	public void run(String starting_pos)
	{
		System.out.println("MOVING FORWARD!");
		//this.move(.5, 10);
		
		if (starting_pos.equalsIgnoreCase("left"))
		{
			//in inches,
			//to cross line requires 168 in
			move(200);
		}
		else if (starting_pos.equalsIgnoreCase("right"))
		{
			move(200);
		}
		else 
		{
			System.out.println("RUN PARAM CASE INVALID");
		}
	}

	
	//TURN BACK NOW
	private void turn(String direction, double degrees, double v)
	{
		double r = WHEEL_DIAMETER / 2;
		double rad = degrees * (Math.PI / 180);
		double w = (v / r) * 2 * Math.PI;
		
		double speedRight = v*-1;
		double speedLeft = v;
		
		double timeStuff = rad / w;
		
		if (direction.equalsIgnoreCase("left"))
		{
			Robot.drivetrain.tankDriveRight(speedRight);
			Robot.drivetrain.tankDriveLeft(speedLeft * -1);
			Timer.delay(timeStuff);
			Robot.drivetrain.tankDriveRight(0);
			Robot.drivetrain.tankDriveLeft(0);
		}
		else if (direction.equalsIgnoreCase("right"))
		{
			Robot.drivetrain.tankDriveRight(-speedRight);
			Robot.drivetrain.tankDriveLeft(speedLeft);
			Timer.delay(timeStuff);
			Robot.drivetrain.tankDriveRight(0);
			Robot.drivetrain.tankDriveLeft(0);
		}
		else
		{
			System.out.println("ERROR: INVALID DIRECTION (param 1)");
		}
		
		//double radians = degrees * (Math.PI / 180);
		//double omega = v / r;
		
	}
	
	private static void move(double length, double speed)
	{
		//So we want to go a certain length
		//
		double Xf = length;
		double Vi = speed;
		double k = .0075;
		
		double t = (k * Xf) / Vi;
		
		Robot.drivetrain.tankDriveRight(speed * -1);
		Robot.drivetrain.tankDriveLeft(speed);
		Timer.delay(t);
		Robot.drivetrain.tankDriveRight(speed);
		Robot.drivetrain.tankDriveLeft(speed * -1);		
		Timer.delay(1 / (t + 3));
		Robot.drivetrain.tankDriveRight(0);
		Robot.drivetrain.tankDriveLeft(0);
	}
	private static void move(double length)
	{
		//So we want to go a certain length
		
		double Xf = length;
		//We're setting the motors to go .3 because that was our tested speed value
		double Vi = .3;
		double k = .0075;
		
		double t = (k * Xf) / Vi;
		
		Robot.drivetrain.tankDriveRight(Vi * -1);
		Robot.drivetrain.tankDriveLeft(Vi);
		Timer.delay(t);
		Robot.drivetrain.tankDriveRight(Vi);
		Robot.drivetrain.tankDriveLeft(Vi * -1);		
		Timer.delay(1 / (t + 3));
		Robot.drivetrain.tankDriveRight(0);
		Robot.drivetrain.tankDriveLeft(0);
	}
}
