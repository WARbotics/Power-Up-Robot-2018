
package org.usfirst.frc.team6925.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6925.robot.Robot;
import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.PWMSpeedController;


public class DriveWithJoystick
{
	
	public static Joystick controller = new Joystick(RobotMap.joystick_port);
	public static int port;
	public boolean triggerPressed = false;
	
	

	public DriveWithJoystick()
	{	
		
	}
	
	public static void drive() 
	{
	}
	
	public boolean getTriggerPressed() 
	{
		return true;
	}
	
}

