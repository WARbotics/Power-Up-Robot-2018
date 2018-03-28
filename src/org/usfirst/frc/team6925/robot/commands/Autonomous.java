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
	
	private boolean isRunning = true;
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
		
		
		if (starting_pos.equalsIgnoreCase("middle"))
		{
			if (side.equalsIgnoreCase("left"))
			{
				if (isRunning)
				{
					System.out.println("MIDD LEFT");
					move(.2, 2);
					Timer.delay(1);
					turn("left",.3,.4);
					Timer.delay(1);
					move(.2, 2);
					Timer.delay(1);
					turn("right",.3,.4);
					Timer.delay(1);
					move(.2, 2);
					isRunning = false;
				}
			}
			//
			else if (side.equalsIgnoreCase("right"))
			{
				if (isRunning)
				{
					System.out.println("MIDD RIGHT");
					move(.2, 2);
					Timer.delay(1);
					turn("right",.3,.4);
					Timer.delay(1);
					move(.2, 2);
					Timer.delay(1);
					turn("left",.3,.4);
					Timer.delay(1);
					move(.2, 2);
					isRunning = false;
				}
			}
		}
		else if (starting_pos.equalsIgnoreCase("left"))
		{
			if (side.equalsIgnoreCase("right"))
			{
				if (isRunning)
				{
					System.out.println("LEFT RIGHT");
					Timer.delay(3);
					move(.3,1);
					Timer.delay(1);
					turn("right",.3,.4);
					Timer.delay(1);
					move(.3,2);
					Timer.delay(1);
					turn("left",.3,.4);
					Timer.delay(1);
					move(.3,1);
					isRunning = false;
				}
			}
		}
		else if (starting_pos.equalsIgnoreCase("right"))
		{
			if (side.equalsIgnoreCase("left"))
			{
				if (isRunning)
				{
					System.out.println("right left");
					turn("left",90,.3);
					Timer.delay(1);
					isRunning = false;
				}
			}
		}
		else 
		{
			System.out.println("INVALID STARTING POS!");
		}
	}
	public void run(String starting_pos)
	{
		System.out.println("MOVING FORWARD!");
		//this.move(.5, 10);
		
		if (starting_pos.equalsIgnoreCase("left"))
		{
			//in inches,
			//to cross line requires 168 in
			if (isRunning)
			{
				System.out.println("LEFT LEFT");
				move(.3,1);
				Timer.delay(1);
				turn("right",.3,.4);
				Timer.delay(1);
				move(.2,1);
				Timer.delay(1);
				turn("left",.3,.4);
				Timer.delay(1);
				move(.3,1);
				isRunning = false;
			}
		}
		else if (starting_pos.equalsIgnoreCase("right"))
		{
			if (isRunning)
			{
				
				isRunning = false;
			}
		}
		else 
		{
			System.out.println("RUN PARAM CASE INVALID");
		}
		if (starting_pos.equalsIgnoreCase("fullSpeed"))
		{
			move(1,100);
			isRunning = false;
		}
	}

	public void testTurn()
	{
		this.turn("right", 90, .2);
	}
	
	//TURN BACK NOW
	private void turn(String direction, double speed, double time)
	{
		
		//Comments for the encoders, assuming it counts rotations
		//v is in inches
		
		
		/*v = v * CONVERSION;
		double r = WHEEL_DIAMETER / 2;
		double rad = degrees * (Math.PI / 180);
		double w = (v / r) * 2 * Math.PI;
		
		double speedRight = v;
		double speedLeft = v;
		
		double timeStuff = rad / w;*/
		
		if (direction.equalsIgnoreCase("left"))
		{
			//REVERSE THESE ON REAL ROBOT
			Robot.drivetrain.setSpeedRight(-speed);
			Robot.drivetrain.setSpeedLeft(speed);
			Timer.delay(time);
			Robot.drivetrain.setSpeedRight(0);
			Robot.drivetrain.setSpeedLeft(0);
		}
		else if (direction.equalsIgnoreCase("right"))
		{
			Robot.drivetrain.setSpeedRight(speed);
			Robot.drivetrain.setSpeedLeft(-speed);
			Timer.delay(time);
			Robot.drivetrain.setSpeedRight(0);
			Robot.drivetrain.setSpeedLeft(0);
		}
		else
		{
			System.out.println("ERROR: INVALID DIRECTION (param 1)");
		}
		
		//double radians = degrees * (Math.PI / 180);
		//double omega = v / r;
		
	}
	
	private void move(double speed, double time)
	{
		//So we want to go a certain length
		//
		
		//Vi = 
		//rotations = .3
		/*double Xf = length;
		double Vi = speed * CONVERSION;
		
		double t = Xf / Vi;*/
		
		Robot.drivetrain.setSpeedRight(speed);
		Robot.drivetrain.setSpeedLeft(speed);
		Timer.delay(time);
		//Robot.drivetrain.setSpeedRight(speed);
		//Robot.drivetrain.setSpeedLeft(speed * -1);		
		//Timer.delay(1 / (t + 3));
		Robot.drivetrain.setSpeedRight(0);
		Robot.drivetrain.setSpeedLeft(0);
	}
	
}
