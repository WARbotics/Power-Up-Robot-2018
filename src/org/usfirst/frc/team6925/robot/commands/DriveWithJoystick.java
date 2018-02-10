
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
	
	

	public DriveWithJoystick()
	{	
		
	}
	
	public static void drive() 
	{
		System.out.println("drive was called");
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
			DriveTrain.m_frontLeftPWM.set((throttle * (power - turn)));
			DriveTrain.m_rearLeftPWM.set((throttle * (power - turn)));
			DriveTrain.m_frontRightPWM.set((throttle * (power + turn)));
			DriveTrain.m_rearRightPWM.set((throttle * (power + turn)));
		}
		else if (controller.getY() < 0)
		{
			DriveTrain.m_frontLeftPWM.set((throttle * (power + turn)));
			DriveTrain.m_rearLeftPWM.set((throttle * (power + turn)));
			DriveTrain.m_frontRightPWM.set((throttle * (power - turn)));
			DriveTrain.m_rearRightPWM.set((throttle * (power - turn)));
		}
	}
	
	public boolean getTriggerPressed() 
	{
		return true;
	}
	
}

