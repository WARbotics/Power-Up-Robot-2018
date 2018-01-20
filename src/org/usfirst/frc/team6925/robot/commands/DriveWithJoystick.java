
package org.usfirst.frc.team6925.robot.commands;

import edu.wpi.first.wpilibj.Joystick;

public class DriveWithJoystick {
	
	public Joystick controller;
	public int port;
	
	public void Joystick(int port) {
		this.port = port;
		this.controller = new Joystick(port);
		// When the Controller is initialized, it will automatically set the controller object and port value
	}

	// Configuration

	double DEAD_ZONE = 0.08;
		// This is a sensitivity buffer for the joysticks. (Recommended 0.05 or higher)
		// Prevents the robot from going nuts at the slightest movement.
	
}
