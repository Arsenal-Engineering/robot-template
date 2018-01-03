package frc.team6223.subsystems;


import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveSubsystem extends Subsystem {

    private Spark leftMotorController = new Spark(8);
    private Spark rightMotorController = new Spark(9);
    private RobotDrive robotDrive = new RobotDrive(leftMotorController, rightMotorController);

    @Override
    protected void initDefaultCommand() {

    }

    public void driveMotors(double x, double y) {
        robotDrive.arcadeDrive(y, x);
    }
}
