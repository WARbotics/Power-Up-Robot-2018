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
	Button getBasket;
	Button getBasketReload;
	Button getIntake;
	Button getOuttake;
	Button testMotors;
	Button testUnit;
	Button reverseControls;
	
	public OI() {
		//Constructing the button for the Operator Joystick and drivers joystick
		getBasket = new JoystickButton(operatorJoystick, 1);
		getBasketReload = new JoystickButton(operatorJoystick, 2);
		getIntake = new JoystickButton(operatorJoystick, 3);
		getOuttake= new JoystickButton(operatorJoystick, 4);
		testMotors = new JoystickButton(operatorJoystick, 5);
		testUnit = new JoystickButton(operatorJoystick,6);
		reverseControls = new JoystickButton(driveJoystick, 5);

		System.out.println("OI has been init");
		
	}
}
