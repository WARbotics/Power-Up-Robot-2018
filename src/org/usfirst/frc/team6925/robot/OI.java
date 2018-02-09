package org.usfirst.frc.team6925.robot;

//import
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI 
{
	Joystick leftJoy = new Joystick(RobotMap.joystick_port);
	Button button1 = new JoystickButton(leftJoy, 1),
	button2 = new JoystickButton(leftJoy, 2),
	button3 = new JoystickButton(leftJoy, 3),
	button4 = new JoystickButton(leftJoy, 4),
	button5 = new JoystickButton(leftJoy, 5),
	button6 = new JoystickButton(leftJoy, 6),
	button7 = new JoystickButton(leftJoy, 7),
	button8 = new JoystickButton(leftJoy, 8);
	
	public OI() 
	{
		
	}
}



