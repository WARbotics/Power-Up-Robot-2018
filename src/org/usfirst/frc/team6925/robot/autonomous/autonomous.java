package org.usfirst.frc.team6925.robot.autonomous;

import org.usfirst.frc.team6925.robot.Robot;

import edu.wpi.first.wpilibj.Timer;


public class autonomous {
	
	private boolean isRunning = true;

public autonomous(){
		System.out.println("AUTONOMOUS OBJECT INITIALIZED!");
	}
	
	public void run(String startingPosition, String side) {
		
		
		if (startingPosition.equalsIgnoreCase("middle")){
			if (side.equalsIgnoreCase("left")){
				if (isRunning){
					//THIS CODE IS BETTER THAN MID RIGHT. REPLICATE.
					System.out.println("MIDD LEFT");
					move(.2, 1);
					Timer.delay(1);
					turn("left",.3,.4);
					Timer.delay(1);
					move(.2, 2.25);
					Timer.delay(1);
					turn("right",.3,.4);
					Timer.delay(1);
					move(.2, 3.5);
					Timer.delay(2);
					isRunning = false;
				}
			}
	
			else if (side.equalsIgnoreCase("right")){
				if (isRunning){
					System.out.println("MIDD RIGHT");
					move(.2, 1);
					Timer.delay(1);
					turn("right",.3,.4);
					Timer.delay(1);
					move(.2, 2.25);
					Timer.delay(1);
					turn("left",.3,.4);
					Timer.delay(1);
					move(.2, 3.5);
					Timer.delay(2);
				
					isRunning = false;
				}
			}
		}
		else if (startingPosition.equalsIgnoreCase("left")){
			if (side.equalsIgnoreCase("right")){
				if (isRunning){
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
					move(.2,4);
					Timer.delay(2);

					isRunning = false;
				}
			}
		}
		else if (startingPosition.equalsIgnoreCase("right")){
			if (side.equalsIgnoreCase("left")){
				if (isRunning){
					System.out.println("right left");
					move(.2,1);
					Timer.delay(1);
					turn("left",.3,.4);
					Timer.delay(1);
					move(.3,3);
					Timer.delay(1);
					turn("right",.3,.4);
					Timer.delay(1);
					move(.2,4);
					Timer.delay(2);

					isRunning = false;
				}
			}
		}
		else {
			System.out.println("INVALID STARTING POS!");
		}
	}
	public void run(String startingPosition){
		System.out.println("MOVING FORWARD!");
		//this.move(.5, 10);3e
		
		if (startingPosition.equalsIgnoreCase("left")){
			//in inches,
			//to cross line requires 168 in
			if (isRunning){
				System.out.println("LEFT LEFT");
				move(.3,1);
				Timer.delay(1);
				turn("right",.3,.4);
				Timer.delay(1);
				move(.2,1);
				Timer.delay(1);
				turn("left",.3,.4);
				Timer.delay(1); 
				move(.2,4);
				Timer.delay(2);

				isRunning = false;
			}
		}
		else if (startingPosition.equalsIgnoreCase("right")){
			if (isRunning){
				System.out.println("RIGHT RIGHT");
				move(.3,1);
				Timer.delay(1);
				turn("left",.3,.4);
				Timer.delay(1);
				move(.2,1);
				Timer.delay(1);
				turn("right",.3,.4);
				Timer.delay(1); 
				move(.3,1);
				Timer.delay(2);

				isRunning = false;
			}
		}
		else {
			System.out.println("RUN PARAM CASE INVALID");
		}
		if (startingPosition.equalsIgnoreCase("fullSpeed")){
			move(1,100);
			isRunning = false;
		}
	}

	public void testTurn(){
		this.turn("right", 90, .2);
	}
	
	//TURN BACK NOW
	private void turn(String direction, double speed, double time){ 
		
		//Comments for the encoders, assuming it counts rotations
		//v is in inches
		
		 
		/*v = v * CONVERSION;
		double r = WHEEL_DIAMETER / 2;
		double rad = degrees * (Math.PI / 180);
		double w = (v / r) * 2 * Math.PI;
		
		double speedRight = v;
		double speedLeft = v;
		
		double timeStuff = rad / w;*/
		
		if (direction.equalsIgnoreCase("left")){
			//REVERSE THESE ON REAL ROBOT
			Robot.driveTrain.setSpeedRight(-speed);
			Robot.driveTrain.setSpeedLeft(speed);
			Timer.delay(time);
			Robot.driveTrain.setSpeedRight(0);
			Robot.driveTrain.setSpeedLeft(0);
		}
		else if (direction.equalsIgnoreCase("right"))
		{
			Robot.driveTrain.setSpeedRight(speed);
			Robot.driveTrain.setSpeedLeft(-speed);
			Timer.delay(time);
			Robot.driveTrain.setSpeedRight(0);
			Robot.driveTrain.setSpeedLeft(0);
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
		
		Robot.driveTrain.setSpeedRight(speed);
		Robot.driveTrain.setSpeedLeft(speed);
		Timer.delay(time);
		//Robot.drivetrain.setSpeedRight(speed);
		//Robot.drivetrain.setSpeedLeft(speed * -1);		
		//Timer.delay(1 / (t + 3));
		Robot.driveTrain.setSpeedRight(0);
		Robot.driveTrain.setSpeedLeft(0);
	}
	private void basket() 
	{
		//basket auto
		Robot.basket.basketMotor.set(8);
		Timer.delay(2);
		Robot.basket.basketMotor.set(0);
		// This to allow the cube roll into the switch if the speed is not fast enough
		Timer.delay(2);
		Robot.basket.basketMotor.set(-.7);
		Timer.delay(2);
		Robot.basket.basketMotor.set(0);
	}
}
		 
