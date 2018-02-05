package org.usfirst.frc.team6925.robot.subsystems;
//

import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.DriveWithJoystick;

//import edu.wpi.first.wpilibj.CounterBase.EncodingType;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PIDSourceType;
//import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.PWMSpeedController;

//import org.usfirst.frc.team6925.robot.Robot;
//import org.usfirst.frc.team6925.robot.commands.DriveWithJoystick;


//import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The DriveTrain subsystem controls the robot's chassis and reads in
 * information about it's speed and position.
 */
public class DriveTrain extends Subsystem 
{
	//creating the motors(victorSP) 
	public static VictorSP m_frontLeftMotor = new VictorSP(RobotMap.m_frontLeftMotor);
	public static VictorSP m_frontRightMotor = new VictorSP(RobotMap.m_frontRightMotor);
	
	public static VictorSP m_rearLeftMotor = new VictorSP(RobotMap.m_rearLeftMotor);
	public static VictorSP m_rearRightMotor = new VictorSP(RobotMap.m_rearRightMotor);
	SpeedControllerGroup m_Left = new SpeedControllerGroup(m_frontLeftMotor, m_rearLeftMotor);
	SpeedControllerGroup m_Right = new SpeedControllerGroup(m_rearRightMotor, m_rearRightMotor);
	
	public DriveTrain() 
	{
		
	}

	
	@Override
	protected void initDefaultCommand() 
	{
		setDefaultCommand(new DriveWithJoystick());
		
	}
	public void setMotors(double left, double right) 
	{
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

	public void DriveTrain(Joystick controller) 
	{
		DriveWithJoystick.drive();
		
	}

}
