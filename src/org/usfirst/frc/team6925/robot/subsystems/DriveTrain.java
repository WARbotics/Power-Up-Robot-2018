package org.usfirst.frc.team6925.robot.subsystems;


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

import org.usfirst.frc.team6925.robot.Robot;
import org.usfirst.frc.team6925.robot.commands.DriveWithJoystick;

/**
 * The DriveTrain subsystem controls the robot's chassis and reads in
 * information about it's speed and position.
 */
public class DriveTrain extends Subsystem 
{
	// Subsystem devices
	private SpeedController m_frontLeftCIM = new VictorSP(1);
	private SpeedController m_frontRightCIM = new VictorSP(2);
	private SpeedController m_rearLeftCIM = new VictorSP(3);
	private SpeedController m_rearRightCIM = new VictorSP(4);
	private SpeedControllerGroup m_leftCIMs = new SpeedControllerGroup(m_frontLeftCIM, m_rearLeftCIM);
	private SpeedControllerGroup m_rightCIMs = new SpeedControllerGroup(m_frontRightCIM, m_rearRightCIM);
	private DifferentialDrive m_drive;
	private Encoder m_rightEncoder = new Encoder(1, 2, true, EncodingType.k4X);
	private Encoder m_leftEncoder = new Encoder(3, 4, false, EncodingType.k4X);

	public DriveTrain() 
	{
		// Configure drive motors
		addChild("Front Left CIM", (VictorSP) m_frontLeftCIM);
		addChild("Front Right CIM", (VictorSP) m_frontRightCIM);
		addChild("Back Left CIM", (VictorSP) m_rearLeftCIM);
		addChild("Back Right CIM", (VictorSP) m_rearRightCIM);

		m_drive = new DifferentialDrive(m_leftCIMs, m_rightCIMs);
		m_drive.setSafetyEnabled(true);
		m_drive.setExpiration(0.1);
		m_drive.setMaxOutput(1.0);

		// Configure encoders
		m_rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		m_leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);

		if (Robot.isReal()) { // Converts to feet
			m_rightEncoder.setDistancePerPulse(0.0785398);
			m_leftEncoder.setDistancePerPulse(0.0785398);
		} 
		else 
		{
			// Convert to feet 4in diameter wheels with 360 tick sim encoders
			m_rightEncoder.setDistancePerPulse(
					(4.0/* in */ * Math.PI) / (360.0 * 12.0/* in/ft */));
			m_leftEncoder.setDistancePerPulse(
					(4.0/* in */ * Math.PI) / (360.0 * 12.0/* in/ft */));
		}

		addChild("Right Encoder", m_rightEncoder);
		addChild("Left Encoder", m_leftEncoder);
	/**
	 * When other commands aren't using the drivetrain, allow tank drive with
	 * the joystick.
	 */
	@Override
	public void initDefaultCommand() 
	{
		setDefaultCommand(new DriveWithJoysitck());
		//The reason that this is not working is because with need make the DriveWithJoyStick command
	}

		public void tankDrive(Joystick joy) 
		{
		m_drive.tankDrive(joy.getY(), joy.getRawAxis(4));
	}

	/**
	 * Tank drive using individual joystick axes.
	 *
	 * @param leftAxis Left sides value
	 * @param rightAxis Right sides value
	 */
	public void tankDrive(double leftAxis, double rightAxis) 
	{
		m_drive.tankDrive(leftAxis, rightAxis);
	}

	/**
	 * Stop the drivetrain from moving.
	 */
	public void stop() 
	{
		m_drive.tankDrive(0, 0);
	}

	/**
	 * The encoder getting the distance and speed of left side of the
	 * drivetrain.
	 */
	public Encoder getLeftEncoder() 
	{
		return m_leftEncoder;
	}

	/**
	 * The encoder getting the distance and speed of right side of the
	 * drivetrain.
	 */
	public Encoder getRightEncoder() 
	{
		return m_rightEncoder;
	}

	/**
	 * The current angle of the drivetrain as measured by the Gyro.
	 */
}







