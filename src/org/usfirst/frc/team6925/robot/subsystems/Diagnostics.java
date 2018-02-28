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
	private static int delay = 5000;
	private static double driveSpeed = .5;
	
	
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
		Robot.drivetrain.tankDriveLeft(speed);
		Timer.delay(delay);
		
		System.out.println("RESETTING Robot.drivetrain.tankDriveLeft.");
		Robot.drivetrain.tankDriveLeft(0);
		Timer.delay(3000);
		
		System.out.println("TESTING RIGHT MOTORS AT " + speed + " units/sec, for " + delay + " milliseconds.");
		Robot.drivetrain.tankDriveRight(speed);
		Timer.delay(delay);
		
		System.out.println("RESETTING Robot.drivetrain.tankDriveRight.");
		Robot.drivetrain.tankDriveRight(0);
		Timer.delay(3000);
		
		//sets running to false
		running = false;
		return 0;
	}

	public static int testUnit()
	{
		//sets running to true
		running = true;
		
		
		System.out.println("TESTING FOR UNIT AT SPEED: " + driveSpeed+ ". STAND BACK!");
		Robot.drivetrain.tankDriveRight(driveSpeed);
		Robot.drivetrain.tankDriveLeft(driveSpeed);
		Timer.delay(1000);
		
		System.out.println("STOPPING");
		Robot.drivetrain.tankDriveRight(0);
		Robot.drivetrain.tankDriveLeft(0);
		Timer.delay(1000);
		
		
		//sets running to false;
		running = false;
		
		return 0;
	}
	
}
