/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6925.robot;

import org.usfirst.frc.team6925.robot.components.basket;
import org.usfirst.frc.team6925.robot.components.intake;
import org.usfirst.frc.team6925.robot.components.drivetrain;
import org.usfirst.frc.team6925.robot.autonomous.autonomous;
import org.usfirst.frc.team6925.robot.OI;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	public static drivetrain driveTrain;
	public static basket basket;
	public static intake intake;
	public static OI input;
	public static autonomous auto;
    private static final String L_fullSpeed = "FULL SPEED AHEAD";
    private static final String Left = "Left";
    private static final String Right = "Right";
    private static final String Middle = "Middle";
    private static final String None = "None";
	private String m_autoSelected;
	public static String gameData;
	
	private SendableChooser<String> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain driveTrain = new drivetrain();
		basket basket = new basket();	
		intake intake = new intake();
		UsbCamera rearCamera = CameraServer.getInstance().startAutomaticCapture(0);
		UsbCamera frontCamera = CameraServer.getInstance().startAutomaticCapture(1);
		rearCamera.setFPS(15);
		rearCamera.setResolution(640, 640);
		frontCamera.setFPS(15);
		frontCamera.setResolution(640, 640);
	   	m_chooser.addObject("FULL SPEED AHEAD", L_fullSpeed);
	   	m_chooser.addObject("Left", Left);
	   	m_chooser.addObject("Middle", Middle);
	   	m_chooser.addObject("Right", Right);
	   	m_chooser.addDefault("None", None);
		SmartDashboard.putData("Auto choices", m_chooser);
	}


	@Override
	public void autonomousInit() {
		autonomous auto = new autonomous();
		m_autoSelected = m_chooser.getSelected();
	   	gameData = DriverStation.getInstance().getGameSpecificMessage();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}
	@Override
	public void autonomousPeriodic() {
		 switch(m_autoSelected) {
		 case Left:
			 if (gameData.charAt(0) == 'L') {
				 auto.run("left");
				 //Left placement and left switch
			 }
			 else if(gameData.charAt(0) == 'R') {
				 auto.run("left","right");
				 //Left placement and right switch
			 }
			 break;
		 case Middle:
			 if (gameData.charAt(0) == 'L') {
				 auto.run("middle", "left");
				 //Middle placement and left switch
			 }
			 else if(gameData.charAt(0) == 'R') {
				 //Middle placement and right switch
				 auto.run("middle","right");
			 }
		 	 break;
		 case Right:
			 if (gameData.charAt(0) == 'L') {
				 auto.run("right", "left");
				 //Right placement and left switch
			 }
			 else if(gameData.charAt(0) == 'R') {
				 auto.run("right");
				 //Right placement and right switch
			 }
			 break;
		 case L_fullSpeed:
   		 		auto.run("fullspeed");
   		 		break;
		 case None:
			 break;
		 
		 }
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		if (Robot.input.reverseControls.get()){
			driveTrain.leftMotorGroup.setInverted(false);
			driveTrain.rightMotorGroup.setInverted(true);
		}
		else{
			driveTrain.leftMotorGroup.setInverted(true);
			driveTrain.rightMotorGroup.setInverted(false);
		}
	
		double inputSpeedLeft = input.driveJoystick.getRawAxis(1);
		double inputSpeedRight = input.driveJoystick.getRawAxis(5);
    	driveTrain.setSpeedLeft(inputSpeedLeft *  .8);
    	driveTrain.setSpeedRight(inputSpeedRight * .8);
		
		
    	//Gets the value of the button that controls the basket.
		if (input.getBasket.get() && !input.getBasketReload.get()){
			basket.setBasket(.9);
		}
		else if (input.getBasketReload.get()){
			basket.setBasket(-.8);
		}
		else{
			basket.setBasket(0);
		}
		
		if (input.getOuttake.get()) {
			intake.setIntake(1);
		}
		else if (input.getOuttake.get()) {
			intake.setIntake(-1);
		}
		else {
			intake.setIntake(0);
		}
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
