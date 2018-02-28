/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6925.robot;
import org.usfirst.frc.team6925.robot.subsystems.Diagnostics;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;

import org.usfirst.frc.team6925.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team6925.robot.subsystems.basket;
import org.usfirst.frc.team6925.robot.subsystems.driveTrain;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

/*   __   ___ ____  ____  
  / /_ / _ \___ \| ___| 
 | '_ \ (_) |__) |___ \ 
 | (_) \__, / __/ ___) |
  \___/  /_/_____|____/ 
*/                        


//TODO 
//Button and basket (spark)
public class Robot extends IterativeRobot 
{
	public static basket Basket; 
	public static IntakeSubsystem intake;
	public static driveTrain drivetrain;
	public static OI oi;
    private static final String R_Left = "R-Switch L-Start";
    private static final String R_Right = "R-Switch R-Start";
    private static final String R_Mid = "R-Switch M-Start";
    private static final String L_Left = "L-Switch L-Start";
    private static final String L_Right = "L-Switch R-Start";
    private static final String L_Mid = "L-Switch M-Start";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	public static String gameData;
	private AnalogGyro m_gyro = new AnalogGyro(RobotMap.kGyroPort);
	

	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit()
	{
		System.out.println("Robot has init");
		Basket = new basket();
		intake = new IntakeSubsystem();
		drivetrain = new driveTrain();
		oi = new OI();
		UsbCamera m_frontCamera = CameraServer.getInstance().startAutomaticCapture(RobotMap.frontCamera);
		m_frontCamera.setFPS(60);
		m_frontCamera.setResolution(640, 640);
		m_gyro.setSensitivity(RobotMap.kVoltsPerDegreePerSecond);
		m_chooser.addDefault("Right Switch and Right Start", R_Left);
	   	m_chooser.addObject("Right Switch and Right Start", R_Right);
	   	m_chooser.addObject("Right Switch and Mid Start", R_Mid);
	   	m_chooser.addDefault("Left Switch Left Start", L_Left);
	   	m_chooser.addObject("Left Switch Right Start", L_Right);
	   	m_chooser.addObject("Left Switch Mid Start", L_Mid);

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
	@Override
	public void autonomousInit() 
	{
		//Collecting the GameData 
		String GameData;
	   	GameData = DriverStation.getInstance().getGameSpecificMessage();
	   	gameData = GameData;   
		m_autoSelected = m_chooser.getSelected();
		System.out.println("Auto selected: " + m_autoSelected);
	}
    public String getGameData()
    {
    	//returns the data  
   	 	return gameData;
    }


	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() 
	{
		//based on the first letter of the game Data
		if (gameData.charAt(0)== 'L') 
		{
			 switch(m_autoSelected) 
		{
	   		 case L_Right:
	   			 //Left Switch and Right placement
	   			 break;
	   		 case L_Mid:
	   			 //Left  Switch and Right placement 
	   			 break;
	   		 case L_Left:
	   			 //Left  switch anad Left placement
	   			 break;
	   	}
		}

	   	 
	   	 else
	   	 {
	   		 switch (m_autoSelected) 
	   		 {
	   		 	case R_Right:
	   		 		//Right Switch and Right placement
	   		 		break;
	   		 	case R_Mid:
	   		 		//Right Switch and Middle placement
	   		 		break;
	   		 	case R_Left:
	   		 		//Right Switch and Left Placement
	   		 		break;
	   		 } 
	   	 }
	}
	
		

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic()
	{
		double inputSpeedLeft = -Robot.oi.drive_Joystick.getRawAxis(1);
		
		double inputSpeedRight = Robot.oi.drive_Joystick.getRawAxis(5);
    		Robot.drivetrain.tankDriveLeft(deadBand(inputSpeedLeft));
    		System.out.println("Passed leftside");
    		Robot.drivetrain.tankDriveRight(deadBand(inputSpeedRight));
		System.out.println("IN TELEOPPERIODIC");
		
		
		if (Robot.oi.basket.get()) 
		{
			Robot.Basket.setSpeed(.75);
		}
		else {
			Robot.Basket.setSpeed(0);
		}
		
		
		if (Robot.oi.basketReload.get()) 
		{
			Robot.Basket.setSpeed(-.75);
		}
		else 
		{
			Robot.Basket.setSpeed(0);
		}
		
		
		if (Robot.oi.intakeIN.get()) 
		{
			Robot.intake.setIntakeSpeed(.75);
		}
		else 
		{
			Robot.intake.setIntakeSpeed(0);
		}
		
		
		if (Robot.oi.intakeOUT.get()) 
		{
			Robot.intake.setIntakeSpeed(-.75);
		}
		else 
		{
			Robot.intake.setIntakeSpeed(0);
		}
		
		
		//now for the pretty stuff :)
		if (Robot.oi.testMotors.get())
		{
			if (!Diagnostics.isRunning())
			{
				Diagnostics.testSpeedGroups();
			}
		}
		
		if (Robot.oi.testUnit.get())
		{
			if (!Diagnostics.isRunning())
			{
				Diagnostics.testUnit();
			}
		}
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic()
	{
		

	}
	public double deadBand(double coolDoubleThing)
	{
		if (coolDoubleThing > .2)
		{
			return 0.0;
		}
		else
		{
			return coolDoubleThing;
		}
	}
}
