/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6925.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot 
{
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	public static String gameData;
	public VictorSP m_rearLeftMotor = new VictorSP(RobotMap.m_rearLeftMotor);
	public SpeedControllerGroup m_Left = 
			new SpeedControllerGroup(new VictorSP(RobotMap.m_frontLeftMotor), 
			new VictorSP(RobotMap.m_rearLeftMotor));
	public SpeedControllerGroup m_Right =
			new SpeedControllerGroup(new VictorSP(RobotMap.m_frontRightMotor), 
			new VictorSP(RobotMap.m_rearRightMotor));
	private DifferentialDrive m_myRobot = new DifferentialDrive(m_Left, m_Right);
	private AnalogGyro m_gyro = new AnalogGyro(RobotMap.kGyroPort);
	private Joystick m_joystick = new Joystick(RobotMap.joystick_port);
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit()
	{
		CameraServer.getInstance().startAutomaticCapture();
		m_gyro.setSensitivity(RobotMap.kVoltsPerDegreePerSecond);
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);

		
	}
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() 
	{
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic()
	{
		switch (m_autoSelected) 
		{
			case kCustomAuto:
			
				break;
			case kDefaultAuto:
			default:
				// Put default auto code here
				break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic()
	{
		System.out.println("IN TELEOPPERIODIC");
		System.out.println("VALUE OF Y = " + m_joystick.getY());
		//startCompetition();
		System.out.println("AFTERCOMPETITION FUNC");
		double turningValue = (RobotMap.kAngleSetpoint - m_gyro.getAngle()) * RobotMap.kP;
		// Invert the direction of the turn if we are going backwards
		turningValue = Math.copySign(turningValue, m_joystick.getY());
		m_myRobot.arcadeDrive(m_joystick.getY(), turningValue);

		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic()
	{
		
	}
}
