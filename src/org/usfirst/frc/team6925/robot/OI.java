package org.usfirst.frc.team6925.robot;

import org.usfirst.frc.team6925.robot.commands.DriveForward;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class OI {
	public Joystick m_joystick = new Joystick(0);

	public OI() {
		
		
		// SmartDashboard Buttons
		SmartDashboard.putData("Drive Forward", new DriveForward(2.25));
		SmartDashboard.putData("Drive Backward", new DriveForward(-2.25));
	}

	public Joystick getJoystick() {
		return m_joystick;
	}
}

