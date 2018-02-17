package org.usfirst.frc.team6925.robot.subsystems;

import org.usfirst.frc.team6925.robot.RobotMap;
import org.usfirst.frc.team6925.robot.commands.driveArcade;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class driveTrain extends Subsystem 
{
	 public VictorSP frontLeft = new VictorSP(RobotMap.m_frontLeftMotor);
	 public VictorSP frontRight = new VictorSP(RobotMap.m_frontRightMotor);
	 public VictorSP rearLeft = new VictorSP(RobotMap.m_rearLeftMotor);
	 public VictorSP rearRight = new VictorSP(RobotMap.m_rearRightMotor);
	 public SpeedControllerGroup m_Left = new SpeedControllerGroup(frontLeft, rearLeft);
	 public SpeedControllerGroup m_Right = new SpeedControllerGroup(frontRight, rearRight);
	 public DifferentialDrive robotDrive = new DifferentialDrive(m_Left, m_Right);
    // Put methods for controlling this subsystem
    // here. Call these from Commands

   public void arcadeDrive(double moveSpeed, double rotateSpeed) 
   {
	   robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
   }
	public void initDefaultCommand() 
    {
		setDefaultCommand(new driveArcade());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

