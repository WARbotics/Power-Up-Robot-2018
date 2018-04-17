/*
 * Welcome to Diagnostics.java!
 * I hope you enjoy your stay.
 * 
 * This function is used to test the basic autonomy of the robot and to see if the robot itself has problems.
 */
package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
public class Diagnostics {
	
	private static double speed = .3;
	private static int delay = 5;
	private static double driveSpeed = .3;
	
	
	//Boolean tells event listener if function currently running.
	private static boolean running = false;
	
	public static boolean isRunning()
	{
		return running;
	}
	
	public static int testSpeedGroups()
	{
		//sets running to true
		running = true;
		
		System.out.println("TESTING LEFT MOTORS AT " + speed + " units/sec, for " + delay + " milliseconds.");
		Robot.drivetrain.setSpeedLeft(speed);
		Timer.delay(delay);
		
		System.out.println("RESETTING Robot.drivetrain.setSpeedLeft.");
		Robot.drivetrain.setSpeedLeft(0);
		Timer.delay(3);
		
		System.out.println("TESTING RIGHT MOTORS AT " + speed + " units/sec, for " + delay + " milliseconds.");
		Robot.drivetrain.setSpeedRight(speed * -1);
		Timer.delay(delay);
		
		System.out.println("RESETTING Robot.drivetrain.setSpeedRight.");
		Robot.drivetrain.setSpeedRight(0);
		Timer.delay(3);
		
		//sets running to false
		running = false;
		return 0;
	}

	public static int testUnit()
	{
		//sets running to true
		running = true;
		
		
		System.out.println("TESTING FOR UNIT AT SPEED: " + driveSpeed+ ". STAND BACK!");
		Robot.drivetrain.setSpeedRight(driveSpeed * -1);
		Robot.drivetrain.setSpeedLeft(driveSpeed);
		Timer.delay(2);
		
		System.out.println("STOPPING");
		Robot.drivetrain.setSpeedRight(0);
		Robot.drivetrain.setSpeedLeft(0);
		Timer.delay(2);
		
		
		//sets running to false;
		running = false;
		
		return 0;
	}
	
}
