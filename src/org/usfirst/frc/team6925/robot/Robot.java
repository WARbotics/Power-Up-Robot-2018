/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/



/*
 * 
 * 
 * Y'ALL, RIGHT SPEED GROUP SPEEDS SHOULD ALWAYS BE MULTIPLIED BY -1
 */
package org.usfirst.frc.team6925.robot;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogGyro;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;

import org.usfirst.frc.team6925.robot.commands.Autonomous;
import org.usfirst.frc.team6925.robot.subsystems.driveTrain;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

public class Robot extends IterativeRobot 
{
	
	public static driveTrain;
	public static OI oi;
    private static final String fullSpeed = "FULL SPEED AHEAD";
    private static final String Left = "Left";
    private static final String Right = "Right";
    private static final String Middle = "Middle";
    private static final String None = "None";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	public static String gameData;
	private AnalogGyro m_gyro = new AnalogGyro(RobotMap.GyroPort);
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit()
	{
		drivetrain = new driveTrain();
		oi = new OI();
		UsbCamera rearCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.rearCamera);
		UsbCamera frontCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.frontCamera);
		m_rearCamera.setFPS(15);
		m_rearCamera.setResolution(640, 640);
		m_frontCamera.setFPS(15);
		m_frontCamera.setResolution(640, 640);
		m_gyro.setSensitivity(RobotMap.kVoltsPerDegreePerSecond);
	   	m_chooser.addObject("FULL SPEED AHEAD", fullSpeed);
	   	m_chooser.addObject("Left", Left);
	   	m_chooser.addObject("Middle", Middle);
	   	m_chooser.addObject("Right", Right);
	   	m_chooser.addDefault("None", None);

		SmartDashboard.putData("Auto choices", m_chooser);
		System.out.println("Robot Init has finished");

		
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

	Autonomous obj;
	@Override
	public void autonomousInit() 
	{
		//Collecting the GameData 
	
	   	gameData = DriverStation.getInstance().getGameSpecificMessage();
	   	
		m_autoSelected = m_chooser.getSelected();
		System.out.println("Auto selected: " + m_autoSelected);
		obj = new Autonomous();
	}


	
	

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() 
	{
		
			 switch(m_autoSelected) 
			 {
			 case Left:
				 if (gameData.charAt(0) == 'L') 
				 {
					 obj.run("left");
					 //Left placement and left switch
				 }
				 else if(gameData.charAt(0) == 'R') 
				 {
					 obj.run("left","right");
					 //Left placement and right switch
				 }
				 break;
			 case Middle:
				 if (gameData.charAt(0) == 'L') 
				 {
					 obj.run("middle", "left");
					 //Middle placement and left switch
				 }
				 else if(gameData.charAt(0) == 'R') 
				 {
					 //Middle placement and right switch
					 obj.run("middle","right");
				 }
			 	 break;
			 case Right:
				 if (gameData.charAt(0) == 'L') 
				 {
					 obj.run("right", "left");
					 //Right placement and left switch
				 }
				 else if(gameData.charAt(0) == 'R') 
				 {
					 obj.run("right");
					 //Right placement and right switch
				 }
				 break;
			 case fullSpeed:
	   		 		obj.run("fullspeed");
	   		 		break;
			 case None:
				 break;
			 
			 }
	}
	
		

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic()
	{

		
		if (Robot.oi.reverseControl.get()) 
		{
			Robot.drivetrain.leftDrivetrainGroup.setInverted(false);
			Robot.drivetrain.rightDrivetrainGroup.setInverted(true);
		}
		else
		{
			Robot.leftDrivetrainGroup.setInverted(true);
			Robot.drivetrain.rightDrivetrainGroup.setInverted(false);
		}
	
		double inputSpeedLeft = Robot.oi.driverJoystick.getRawAxis(1);
		double inputSpeedRight = Robot.oi.driverJoystick.getRawAxis(5);
		//put sinSmooth here1
    		Robot.drivetrain.setLeftDrivetrainSpeed(inputSpeedLeft *  .8);
    		Robot.drivetrain.setRightDrivetrainSpeed(inputSpeedRight * .8);
		
		
    	
    	//Gets the value of the button that controls the basket.
		if (Robot.oi.basketActive.get() && !Robot.oi.basketReload.get()) 
		{
			Robot.drivetrain.setBasket(.9);
		}
		else if (Robot.oi.basketReload.get())
		{
			Robot.drivetrain.setBasket(-.8);
		}
		else
		{
			Robot.drivetrain.setBasket(0);
		}
		
		if (Robot.oi.inTakeButton.get()) 
		{
			Robot.drivetrain.setIntakeSpeed(1);
		}
		else if (Robot.oi.outTakeButton.get()) 
		{
			Robot.drivetrain.setIntakeSpeed(-1);
		}
		else 
		{
			Robot.drivetrain.setIntakeSpeed(0);
		}
		
	}
	



	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic()
	{
		

	}
	//Make sure when using this function, you add RAW SPEED value with no weight.
	public double sinSmooth(double speed)
	{
		//3l
		//check out: y = .5 * Math.sin((Math.PI * x) - (Math.PI/2)) + .5
		//^ is the best functiona
		if (speed >= 0)
		{
			return .5 * Math.sin((Math.PI * speed) - (Math.PI / 2)) + .5;
		}
		else if (speed < 0)
		{
			return -(.5 * Math.sin((Math.PI * speed) - (Math.PI / 2)) + .5);
		}
		return 0;
	}
}
