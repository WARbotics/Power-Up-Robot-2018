
package org.usfirst.frc.team6925.robot.commands;

import edu.wpi.first.wpilibj.Joystick;

public class DriveWithJoystick
{
	
	public Joystick controller;
	public int port;
	public boolean triggerPressed = false;
	public double getAxis;
	public double getX; 
	public void Joystick(int port) 
	{
		this.port = port;
		this.controller = new Joystick(port);
		if (this.getX == -1) 
		{
			System.out.println(this.getX);
		}
		//test git
		
			
		
		
			
		
		
			
		
		
		// When the Controller is initialized, it will automatically set the controller object and port value
	}
	
	public boolean getTriggerPressed() 
	{
		return true;
	}
	// Configuration

	double DEAD_ZONE = 0.08;
		// This is a sensitivity buffer for the joysticks. (Recommended 0.05 or higher)
		// Prevents the robot from going nuts at the slightest movement.
	
}

