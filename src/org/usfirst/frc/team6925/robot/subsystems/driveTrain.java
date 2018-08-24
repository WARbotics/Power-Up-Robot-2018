package org.usfirst.frc.team6925.robot.subsystems;
import org.usfirst.frc.team6925.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

public class driveTrain
{
	//Creating VictorSP motors 
	private VictorSP frontDrivetrainMotor0;
	private VictorSP frontDrivetrainMotor1; 
	private VictorSP rearDrivetrainMotor0;
	private VictorSP rearDrivetrainMotor1;
	//drivetrain speed groups
	public SpeedControllerGroup leftDrivetrainGroup;
	public SpeedControllerGroup rightDrivetrainGroup;
	//basket Motor
	public Spark basketMotor; 
    public SpeedControllerGroup basketGroup;
    //Intake  
	private Spark intakeMotor0;
	private Spark intakeMotor1;
	SpeedControllerGroup intakeMotorGroup;	
	
	public driveTrain() {
		frontDrivetrainMotor0 = new VictorSP(RobotMap.frontDrivetrainMotor0);		
		frontDrivetrainMotor1 = new VictorSP(RobotMap.frontDrivetrainMotor1);
		rearDrivetrainMotor0 = new VictorSP(RobotMap.rearDrivetrainMotor0);
		rearDrivetrainMotor1 = new VictorSP(RobotMap.rearDrivetrainMotor1);
				
		leftDrivetrainGroup = new SpeedControllerGroup(frontDrivetrainMotor0, rearDrivetrainMotor0);
		rightDrivetrainGroup = new SpeedControllerGroup(frontDrivetrainMotor1, rearDrivetrainMotor1);
		leftDrivetrainGroup.setInverted(true);
		
		basketMotor = new Spark(RobotMap.basketMotor);
		basketGroup = new SpeedControllerGroup(basketMotor);

		intakeMotor0 = new Spark(RobotMap.intakeMotor0);
		intakeMotor0.setInverted(true);
		intakeMotor1 = new Spark(RobotMap.inTakeMotor1);
		intakeController = new SpeedControllerGroup(intakeLeft, intakeRight);
	}

	public void setBasket(double inputSpeed){
		this.basket.set(inputSpeed);
	}

	public void setIntakeSpeed(double inputSpeed){
		intakeController.set(inputSpeed);
	}

   	public void setLeftDrivetrainSpeed(double inputSpeed){
		leftDrivetrainGroup.set(inputSpeed);
	}

   	public void setRightDrivetrainSpeed(double inputSpeed) {
	   rightDrivetrainGroup.set(inputSpeed);
	}
}


