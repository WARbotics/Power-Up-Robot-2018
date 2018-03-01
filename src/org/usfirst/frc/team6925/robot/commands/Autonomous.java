package org.usfirst.frc.team6925.robot.commands;


//ALL VALUES ARE IN INCHES

//We need the following functions:
/*
 * 1. A turn function
 * 2. Constructor that takes in values of starting position and side, OR the constructor just takes in "forward"
 * nvm screw this we do this later.
 */
public class Autonomous {
	private final double WHEEL_RADIUS = 24.25;
	
	private String direction = "";
	private double degrees = 0.0;
	private double speed = 0.0;
	
	
	
	public Autonomous(String starting_pos, String side)
	{
		System.out.println("AUTONOMOUS OBJECT INITIALIZED!");
	}
	
	public Autonomous(String movement)
	{
		
	}
	
	public void run()
	{
		this.direction = direction;
		this.degrees = degrees;
		this.speed = speed;
	}
	
	
}
