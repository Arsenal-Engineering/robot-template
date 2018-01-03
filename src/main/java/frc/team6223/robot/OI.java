package frc.team6223.robot;


import edu.wpi.first.wpilibj.Joystick;


public class OI {

    private Joystick primaryJoystick;

    public OI() {
        primaryJoystick = new Joystick(0);
    }

    public Joystick getPrimaryJoystick() {
        return primaryJoystick;
    }
}
