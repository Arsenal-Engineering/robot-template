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

    public void driveMotors(double x, double y) {
        // Square the inputs (while preserving the sign) to increase fine control
        // while permitting full power.
        y = Math.copySign(y * y, y);
        x = Math.copySign(x * x, x);

        double maxInput = Math.copySign(Math.max(Math.abs(y), Math.abs(x)), y);

        // If we're moving forward, we must be in the 1st or 2nd quadrant
        if (y >= 0.0) {
            // If we're turning right (or moving forward with no turning), we're in the 1st quadrant
            // Otherwise, we're in the second quadrant
            if (x >= 0.0) {
                leftMotorController.set(maxInput);
                rightMotorController.set(y - x);
            } else {
                leftMotorController.set(y + x);
                rightMotorController.set(maxInput);
            }
        } else {
            // If we're turning right (or moving forward with no turning, we're in the 3rd quadrant
            // Otherwise, we're in the fourth quadrant
            if (x >= 0.0) {
                leftMotorController.set(y + x);
                rightMotorController.set(maxInput);
            } else {
                leftMotorController.set(maxInput);
                rightMotorController.set(y - x);
            }
        }
    }
}
