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
	 VictorSP frontLeft = new VictorSP(1);
	 VictorSP frontRight = new VictorSP(3);
	 VictorSP rearLeft = new VictorSP(2);
	 VictorSP rearRight = new VictorSP(4);
	 SpeedControllerGroup m_Left = new SpeedControllerGroup(frontLeft, rearLeft);
	 SpeedControllerGroup m_Right = new SpeedControllerGroup(frontRight, rearRight);
	 DifferentialDrive robotDrive = new DifferentialDrive(m_Left, m_Right);
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

