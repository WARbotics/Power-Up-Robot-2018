/*
 * This constructs and identifies the buttons located on the joystick
 */

package org.usfirst.frc.team6925.robot;

//import
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.Intake;
import org.usfirst.frc.team6925.robot.commands.IntakeOut;
import org.usfirst.frc.team6925.robot.commands.reload;
import org.usfirst.frc.team6925.robot.commands.shoot;


public class OI 
{
	//Constructing the joystick and and placing it with it port number  
	public Joystick drive_Joystick = new Joystick(RobotMap.joystick_port);
	public Joystick OP_Joystick = new Joystick(RobotMap.OP_joystick_Port);
	//Constructing the button for the Operator Joystick
	Button basket;
	Button basketReload;
	Button intakeIN;
	Button intakeOUT;
	
	public OI() 
	{
		//Constructing the button for the Operator Joystick
		basket = new JoystickButton(OP_Joystick, 1);
		basketReload = new JoystickButton(OP_Joystick, 2);
		intakeIN = new JoystickButton(OP_Joystick, 3);
		intakeOUT = new JoystickButton(OP_Joystick, 4);
		//placing buttons to there commands  
		System.out.println("When through Button");
	}
}
//test 


