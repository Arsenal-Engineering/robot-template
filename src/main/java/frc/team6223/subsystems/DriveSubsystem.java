package frc.team6223.subsystems;


import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class DriveSubsystem extends Subsystem {

    private Spark leftMotorController = new Spark(8);
    private Spark rightMotorController = new Spark(9);

    @Override
    protected void initDefaultCommand() {

    }

    public void driveMotors(double moveValue, double rotateValue) {

        // Square the inputs (while preserving the sign) to increase fine control
        // while permitting full power.
        moveValue = Math.copySign(moveValue * moveValue, moveValue);
        rotateValue = Math.copySign(rotateValue * rotateValue, rotateValue);

        double maxInput = Math.copySign(Math.max(Math.abs(moveValue), Math.abs(rotateValue)), moveValue);

        // If we're moving forward, we must be in the 1st or 2nd quadrant
        if (moveValue >= 0.0) {
            // If we're turning right (or moving forward with no turning), we're in the 1st quadrant
            // Otherwise, we're in the second quadrant
            if (rotateValue >= 0.0) {
                leftMotorController.set(maxInput);
                rightMotorController.set(moveValue - rotateValue);
            } else {
                leftMotorController.set(moveValue + rotateValue);
                rightMotorController.set(maxInput);
            }
        } else {
            // If we're turning right (or moving forward with no turning, we're in the 3rd quadrant
            // Otherwise, we're in the fourth quadrant
            if (rotateValue >= 0.0) {
                leftMotorController.set(moveValue + rotateValue);
                rightMotorController.set(maxInput);
            } else {
                leftMotorController.set(maxInput);
                rightMotorController.set(moveValue - rotateValue);
            }
        }
    }
}
