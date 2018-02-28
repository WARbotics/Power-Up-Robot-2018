package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.Robot;

import edu.wpi.first.wpilibj.Timer;

public class Diagnostics {
	
	private double speed = .3;
	private int delay = 5000;
	public void run()
	{
		
		System.out.println("TESTING LEFT MOTORS AT " +speed + " units/sec, for " + delay + " milliseconds.");
		Robot.drivetrain.tankDriveLeft(speed);
		Timer.delay(delay);
		
		System.out.println("RESETTING Robot.drivetrain.tankDriveLeft.");
		Robot.drivetrain.tankDriveLeft(0);
		Timer.delay(3000);
		
		System.out.println("TESTING RIGHT MOTORS AT " +speed + " units/sec, for " + delay + " milliseconds.");
		Robot.drivetrain.tankDriveRight(speed);
		Timer.delay(delay);
		
		System.out.println("RESETTING Robot.drivetrain.tankDriveRight.");
		Robot.drivetrain.tankDriveRight(0);
		Timer.delay(3000);
		
	}

}
