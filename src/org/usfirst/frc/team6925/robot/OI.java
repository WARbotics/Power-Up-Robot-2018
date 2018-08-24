/*
 * This constructs and identifies the buttons located on the joystick
 */

package org.usfirst.frc.team6925.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6925.robot.RobotMap;


public class OI 
{
	//Constructing the joystick and and placing it with it port number  
	public Joystick driverJoystick = new Joystick(RobotMap.driverJoystick);
	public Joystick operatorJoystick = new Joystick(RobotMap.operatorJoystick);
	//Constructing the button for the Operator Joystick
	Button basketActive;
	Button basketReload;
	Button inTakeButton;
	Button outTakeButton;
	Button testMotors;
	Button testUnit;
	Button reverseDriversControl;
	public OI() 
	{
		//Constructing the button for the Operator Joystick
		basketActive = new JoystickButton(operatorJoystick, 1);
		basketReload = new JoystickButton(operatorJoystick, 2);
		inTakeButton = new JoystickButton(operatorJoystick, 3);
		outTakeButton = new JoystickButton(operatorJoystick, 4);
		
		
		testMotors = new JoystickButton(operatorJoystick, 5);
		testUnit = new JoystickButton(operatorJoystick,6);
		reverseControl = new JoystickButton(driverJoystick, 5);
		//placing buttons to there commands  
		System.out.println("OI has been init");
		
		
	}
}


