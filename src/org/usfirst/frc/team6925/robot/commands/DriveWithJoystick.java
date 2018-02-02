
package org.usfirst.frc.team6925.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6925.robot.Robot;
import org.usfirst.frc.team6925.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.PWMSpeedController;


public class DriveWithJoystick
{
	
	public static Joystick controller = new Joystick(0);
	public static int port;
	public boolean triggerPressed = false;
	
	
	public void DriveWithJoystick(int port) 
	{
		this.port = port;
	}
	public static void Joystick()
	{
		double throttle = Math.abs(controller.getThrottle()-1)/1.5;
		double speed = controller.getY();
		double power = (Math.sin(Math.PI*(speed - 0.5)) + 1 ) /2; 
	 
		if(speed < 0)
		{
			speed = speed*-1; 
		}
		double turnPower = ((controller.getTwist()));
		double turn = (Math.sin(Math.PI*(turnPower - 0.5)) +1) /2;;
		
		if(controller.getY() > 0 ) 
		{
			DriveTrain.m_frontLeftMotor.set((throttle * (power - turn)));
			DriveTrain.m_rearLeftMotor.set((throttle * (power - turn)));
			DriveTrain.m_frontRightMotor.set((throttle * (power + turn)));
			DriveTrain.m_rearRightMotor.set((throttle * (power + turn)));
		}
		else if (controller.getY() < 0)
		{
			DriveTrain.m_frontLeftMotor.set((throttle * (power + turn)));
			DriveTrain.m_rearLeftMotor.set((throttle * (power + turn)));
			DriveTrain.m_frontRightMotor.set((throttle * (power - turn)));
			DriveTrain.m_rearRightMotor.set((throttle * (power - turn)));
		}
	}
	//test even more 
	
	public boolean getTriggerPressed() 
	{
		return true;
	}
	
}

