package org.usfirst.frc.team6925.robot;

//import
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6925.robot.RobotMap;


public class OI 
{
	public Joystick drive_Joystick = new Joystick(RobotMap.joystick_port);
	public Joystick OP_Joystick = new Joystick(1);//RobotMap is freaking out about it (figure out later)
	
	
	
	public OI() 
	{
		
	}
}



