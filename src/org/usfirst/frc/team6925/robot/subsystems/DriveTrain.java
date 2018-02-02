package org.usfirst.frc.team6925.robot.subsystems;
//

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMSpeedController;

import org.usfirst.frc.team6925.robot.Robot;
import org.usfirst.frc.team6925.robot.commands.DriveWithJoystick;


import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The DriveTrain subsystem controls the robot's chassis and reads in
 * information about it's speed and position.
 */
public class DriveTrain extends Subsystem 
{
	public static VictorSP m_frontLeftMotor = new VictorSP(0);
	public static VictorSP m_frontRightMotor = new VictorSP(1);
	
	public static VictorSP m_rearLeftMotor = new VictorSP(2);
	public static VictorSP m_rearRightMotor = new VictorSP(3);
	SpeedControllerGroup m_Left = new SpeedControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
	SpeedControllerGroup m_Right = new SpeedControllerGroup(m_rearRightMotor, m_rearRightMotor);
	public DriveTrain()
	{
		
	}

	public void tankDrive(Joystick controller) 
	{
		
	}

	@Override
	protected void initDefaultCommand() 
	{
		setDefaultCommand(new DriveWithJoystick());
		
	}
	public void setMotors(double left, double right) {
    	left = scaleLeft(left);
    	right = scaleRight(right);
    	
    	setMotorsRaw(left, right);
    }
    
    public void setMotorsRaw(double left, double right) 
    {
    	left = safetyTest(left);
    	right = safetyTest(right);
    	
    	m_Left.set(left);
    	m_Right.set(right);		
	}
    
    private double safetyTest(double motorValue) 
    {
        motorValue = (motorValue < -1) ? -1 : motorValue;
        motorValue = (motorValue > 1) ? 1 : motorValue;
        
        return motorValue;
    }
    
    private double scaleLeft(double left) 
    {
    	return 1.0 * left;
    }
    
    private double scaleRight(double right) 
    {
    	return 1.0 * right;
    }

	private void setDefaultCommand(DriveWithJoystick driveWithJoystick) 
	{
		
		
	}

}
		