package frc.team6223.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team6223.commands.TeleopDriveCommand;
import frc.team6223.subsystems.DriveSubsystem;


public class Robot extends IterativeRobot {

    private OI operatorInterface = new OI();
    private DriveSubsystem driveSubsystem = new DriveSubsystem();

    @Override
    public void disabledInit() {
        Scheduler.getInstance().removeAll();
    }

    @Override
    public void autonomousInit() { }

    @Override
    public void teleopInit() {
        new TeleopDriveCommand(driveSubsystem, operatorInterface.getPrimaryJoystick()).start();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
    
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
        Scheduler.getInstance().run();
    }
}