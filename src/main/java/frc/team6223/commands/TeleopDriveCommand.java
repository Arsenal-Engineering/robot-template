package frc.team6223.commands;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.team6223.subsystems.DriveSubsystem;


public class TeleopDriveCommand extends Command {

    private DriveSubsystem driveSubsystem;
    private Joystick joystick;

    public TeleopDriveCommand(DriveSubsystem driveSubsystem, Joystick joystick) {
        requires(driveSubsystem);
        this.driveSubsystem = driveSubsystem;
        this.joystick = joystick;
    }

    @Override
    protected void execute() {
        super.execute();
        driveSubsystem.driveMotors(joystick.getX(), joystick.getY());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
