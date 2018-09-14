package org.usfirst.frc.team6925.robot;

//import
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {
	//Constructing the joystick and and placing it with its port number  
	public Joystick driveJoystick = new Joystick(0);
	public Joystick operatorJoystick = new Joystick(1);
	//Constructing the button for the Operator Joystick
	JoystickButton getBasket = new JoystickButton(operatorJoystick, 1);
	JoystickButton getBasketReload = new JoystickButton(operatorJoystick, 2);
	JoystickButton getIntake = new JoystickButton(operatorJoystick, 3);
	JoystickButton getOuttake= new JoystickButton(operatorJoystick, 4);
	JoystickButton testMotors = new JoystickButton(operatorJoystick, 5);
	JoystickButton testUnit = new JoystickButton(operatorJoystick,6);
	JoystickButton reverseControls = new JoystickButton(driveJoystick, 5);
	
	public void oi() {
		//Constructing the button for the Operator Joystick
		JoystickButton getBasket = new JoystickButton(operatorJoystick, 1);
		JoystickButton getBasketReload = new JoystickButton(operatorJoystick, 2);
		JoystickButton getIntake = new JoystickButton(operatorJoystick, 3);
		JoystickButton getOuttake= new JoystickButton(operatorJoystick, 4);
		JoystickButton testMotors = new JoystickButton(operatorJoystick, 5);
		JoystickButton testUnit = new JoystickButton(operatorJoystick,6);
		JoystickButton reverseControls = new JoystickButton(driveJoystick, 5);

		System.out.println("OI has been init");
		
	}
}
