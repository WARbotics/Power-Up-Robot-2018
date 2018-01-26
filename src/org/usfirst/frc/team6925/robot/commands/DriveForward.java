package org.usfirst.frc.team6925.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6925.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6925.robot.Robot;


public class DriveForward extends Command 
{
	private double m_driveForwardSpeed;
	private double m_distance;
	private double m_error;
	private static final double kTolerance = 0.1;
	private static final double kP = -1.0 / 5.0;

	public DriveForward() 
	{
		this(10, 0.5);
	}

	public DriveForward(double dist) 
	{
		this(dist, 0.5);
	}

	public DriveForward(double dist, double maxSpeed) 
	{
		requires(Robot.drivetrain);
		m_distance = dist;
		m_driveForwardSpeed = maxSpeed;
	}

	@Override
	protected void initialize() 
	{
		Robot.drivetrain.getRightEncoder().reset();
		setTimeout(2);
	}

	@Override
	protected void execute() 
	{
		m_error = m_distance - Robot.drivetrain.getRightEncoder().getDistance();
		if (m_driveForwardSpeed * kP * m_error >= m_driveForwardSpeed) 
		{
			Robot.drivetrain.tankDrive(m_driveForwardSpeed, m_driveForwardSpeed);
		} 
		else 
		{
			Robot.drivetrain.tankDrive(m_driveForwardSpeed * kP * m_error,
					m_driveForwardSpeed * kP * m_error);
		}
	}

	@Override
	protected boolean isFinished() 
	{
		return Math.abs(m_error) <= kTolerance || isTimedOut();
	}

	@Override
	protected void end() 
	{
		Robot.drivetrain.stop();
	}
}
