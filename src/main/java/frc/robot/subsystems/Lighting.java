package frc.robot.subsystems;

import com.ctre.phoenix.led.CANdle;
import com.ctre.phoenix.led.CANdle.LEDStripType;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Lights;
import frc.robot.Constants.Lights.LEDState;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain.Drivetrain;

public class Lighting extends SubsystemBase {
    private CANdle mCANdle;
    private LEDState mState;
    private boolean auto = false;
    private int[] oldColor = new int[3];

    @Override
    public void periodic() {
        int[] color = new int[3];

        if (auto) {
            if (DriverStation.isDisabled()) {
                if (Robot.pdh.getVoltage() < Lights.lowVoltageThreshold) {
                    color = LEDState.kWhite.getColor();
                }

                else if (DriverStation.getAlliance().isPresent()) {
                    if (DriverStation.getAlliance().get() == DriverStation.Alliance.Blue) {
                        color = LEDState.kBlue.getColor();
                    }

                    else {
                        color = LEDState.kRed.getColor();
                    }
                }

                else {
                    color = LEDState.kOff.getColor();
                }
            }

            else if (Intake.getInstance().getShooterSensor()) {
                if (Shooter.getInstance().readyToShootAdvanced() &&
                        Drivetrain.getInstance().readyToShoot()) {
                    color = LEDState.kGreen.getColor();
                }

                else {
                    color = LEDState.kPurple.getColor();
                }
            }

            else {
                color = LEDState.kOff.getColor();
            }
        } 
        
        else {
            color = mState.getColor();
        }

        if (color != oldColor) {
            mCANdle.setLEDs(color[0], color[1], color[2], 0, 0, 98);
        }

        oldColor = color;
    }

    private Lighting() {
        mCANdle = new CANdle(Lights.CANdleID);
        mCANdle.configLEDType(LEDStripType.GRB);
        
        // Orange on init
        mState = LEDState.kOff;
    }

    public void setLights(LEDState state) {
        autoSetLights(false);
        mState = state;
    }

    public void autoSetLights(boolean autoSet) {
        auto = autoSet;
    }

    private static Lighting mLighting;

    public static Lighting getInstance() {
        if (mLighting == null) {
            mLighting = new Lighting();
        }

        return mLighting;
    }
}