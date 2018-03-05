package org.usfirst.frc.team6925.robot.commands;

import org.usfirst.frc.team6925.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

//ALL VALUES ARE INCHES

//We need the following functions:
/*
 * 1. A turn function
 * 2. Constructor that takes in values of starting position and side, OR the constructor just takes in "forward"
 * nvm screw this we do this later.
 */
public class Autonomous {
	private final double WHEEL_DIAMETER = 24.25;
	
	//(88/2) / .3 = 146.6667
	
	//because really our test went 44 inches/second, we tested it for two seconds to get .88;
	private final double CONVERSION = 146.6667;
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
		//Field width is 324
		// / 2 = 162
		// / 2 = 81
		
		//This should serve four cases:
		/*
		 * 1. Left right
		 * 2. Right left
		 * 3. Middle left
		 * 4. Middle right
		 */
		
		if (starting_pos.equalsIgnoreCase("test")) 
		{
			if (starting_pos.equalsIgnoreCase("right"))
			{
				Robot.drivetrain.tankDriveLeft(.3);
				Robot.drivetrain.tankDriveRight(.3 * -1);
				System.out.println("MOVING!");
				Timer.delay(2.5);
				Robot.drivetrain.tankDriveLeft(0);
				Robot.drivetrain.tankDriveLeft(0);
				System.out.println("STOPPED!");
			}
		}
		if (starting_pos.equalsIgnoreCase("middle"))
		{
			if (side.equalsIgnoreCase("left"))
			{
				move(100);
				Timer.delay(1);
				turn("left",90,.3);
				Timer.delay(1);
				move(81);
				Timer.delay(1);
				turn("right",90,.3);
				Timer.delay(1);
				move(100);
			}
			//
			else if (side.equalsIgnoreCase("right"))
			{
				move(100);
				Timer.delay(1);
				turn("right",90,.3);
				Timer.delay(1);
				move(81);
				Timer.delay(1);
				turn("left",90,.3);
				Timer.delay(1);
				move(100);
			}
		}
		else if (starting_pos.equalsIgnoreCase("left"))
		{
			if (side.equalsIgnoreCase("right"))
			{
				move(100);
				Timer.delay(1);
				turn("right",90,.3);
				Timer.delay(1);
				//added it to move 8 more inches
				move(170);
				Timer.delay(1);
				turn("left",90,.3);
				Timer.delay(1);
				move(100);
			}
		}
		else if (starting_pos.equalsIgnoreCase("right"))
		{
			if (side.equalsIgnoreCase("left"))
			{
				move(100);
				Timer.delay(1);
				turn("left",90,.3);
				Timer.delay(1);
				move(170);
				Timer.delay(1);
				turn("right",90,.3);
				Timer.delay(1);
				move(100);
			}
		}
		else 
		{
			System.out.println("INVALID STARTING POS!");
		}
	}
	public boolean running = true;
	public void run(String starting_pos)
	{
		System.out.println("MOVING FORWARD!");
		//this.move(.5, 10);
		
		if (starting_pos.equalsIgnoreCase("left") || starting_pos.equalsIgnoreCase("right"))
		{	
			//in inches,
			//to cross line requires 168 in
			if (running)
			{
			Robot.drivetrain.tankDriveLeft(.3);
			Robot.drivetrain.tankDriveRight(.3 * -1);
			System.out.println("Drive Train is going");
			Timer.delay(2.5);
			Robot.drivetrain.tankDriveLeft(0);
			Robot.drivetrain.tankDriveRight(0);
			running = false;
			}
		}
		else 
		{
			System.out.println("RUN PARAM CASE INVALID");
		}
	}

	public void testTurn()
	{
		this.turn("right", 90, .2);
	}
	
	//TURN BACK NOW
	private void turn(String direction, double degrees, double v)
	{
		v = v * CONVERSION;
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
	
	private void move(double length, double speed)
	{
		//So we want to go a certain length
		//
		double Xf = length;
		double Vi = speed * CONVERSION;
		
		double t = Xf / Vi;
		
		Robot.drivetrain.tankDriveRight(speed * -1);
		Robot.drivetrain.tankDriveLeft(speed);
		Timer.delay(t);
		//Robot.drivetrain.tankDriveRight(speed);
		//Robot.drivetrain.tankDriveLeft(speed * -1);		
		//Timer.delay(1 / (t + 3));
		Robot.drivetrain.tankDriveRight(0);
		Robot.drivetrain.tankDriveLeft(0);
	}
	
	
	//length = 30
	private void move(double length)
	{
		//So we want to go a certain length
		/*
		double Xf = length;
		//We're setting the motors to go .3 because that was our tested speed value
		double Vi = .3 * CONVERSION;
		
		double t = Xf / Vi;
		
		Robot.drivetrain.tankDriveRight(Vi * -1);
		Robot.drivetrain.tankDriveLeft(Vi);
		Timer.delay(t);
		//Robot.drivetrain.tankDriveRight(Vi);
		//Robot.drivetrain.tankDriveLeft(Vi * -1);		
		//Timer.delay(1 / (t + 3));
		Robot.drivetrain.tankDriveRight(0);
		Robot.drivetrain.tankDriveLeft(0);
		*/
	}
}
