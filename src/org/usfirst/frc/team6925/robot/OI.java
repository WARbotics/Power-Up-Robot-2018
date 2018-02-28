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
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	
	public OI() 
	{
		//Constructing the button for the Operator Joystick
		button1 = new JoystickButton(OP_Joystick, 1);
		button2 = new JoystickButton(OP_Joystick, 2);
		button3 = new JoystickButton(OP_Joystick, 3);
		button4 = new JoystickButton(OP_Joystick, 4);
		//placing buttons to there commands  
		button1.whenPressed(new shoot());
		button2.whenPressed(new reload());
		button3.whenPressed(new Intake());
		button4.whenPressed(new IntakeOut());
		System.out.println("When through Button");
	}
}



