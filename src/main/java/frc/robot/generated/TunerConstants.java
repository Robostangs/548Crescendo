package frc.robot.generated;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstantsFactory;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.ClosedLoopOutputType;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants.SteerFeedbackType;
import com.pathplanner.lib.util.HolonomicPathFollowerConfig;
import com.pathplanner.lib.util.PIDConstants;
import com.pathplanner.lib.util.ReplanningConfig;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import frc.robot.CommandSwerveDrivetrain;

public class TunerConstants {
        // Both sets of gains need to be tuned to your individual robot.

        // The steer motor uses any SwerveModule.SteerRequestType control request with
        // the
        // output type specified by SwerveModuleConstants.SteerMotorClosedLoopOutput
        private static final Slot0Configs steerGains = new Slot0Configs()
                        .withKP(100).withKI(0).withKD(0.2)
                        .withKS(0).withKV(1.5).withKA(0);
        // When using closed-loop control, the drive motor uses the control
        // output type specified by SwerveModuleConstants.DriveMotorClosedLoopOutput
        private static final Slot0Configs driveGains = new Slot0Configs()
                        .withKP(3).withKI(0).withKD(0)
                        .withKS(0).withKV(0).withKA(0);

        // The closed-loop output type to use for the steer motors;
        // This affects the PID/FF gains for the steer motors
        private static final ClosedLoopOutputType steerClosedLoopOutput = ClosedLoopOutputType.Voltage;
        // The closed-loop output type to use for the drive motors;
        // This affects the PID/FF gains for the drive motors
        private static final ClosedLoopOutputType driveClosedLoopOutput = ClosedLoopOutputType.Voltage;

        // The stator current at which the wheels start to slip;
        // This needs to be tuned to your individual robot
        private static final double kSlipCurrentA = 300.0;

        // Theoretical free speed (m/s) at 12v applied output;
        // This needs to be tuned to your individual robot
        public static final double kSpeedAt12VoltsMps = 9.46;

        // Every 1 rotation of the azimuth results in kCoupleRatio drive motor turns;
        // This may need to be tuned to your individual robot
        private static final double kCoupleRatio = 3.5714285714285716;

        private static final double kDriveGearRatio = 6.746031746031747;
        private static final double kSteerGearRatio = 21.428571428571427;
        private static final double kWheelRadiusInches = 4;

        private static final boolean kSteerMotorReversed = true;
        private static final boolean kInvertLeftSide = false;
        private static final boolean kInvertRightSide = true;

        private static final String kCANbusName = "Swerve CANivore";
        private static final int kPigeonId = 0;

        // These are only used for simulation
        private static final double kSteerInertia = 0.00001;
        private static final double kDriveInertia = 0.001;
        // Simulated voltage necessary to overcome friction
        private static final double kSteerFrictionVoltage = 0.25;
        private static final double kDriveFrictionVoltage = 0.25;

        private static final SwerveDrivetrainConstants DrivetrainConstants = new SwerveDrivetrainConstants()
                        .withPigeon2Id(kPigeonId)
                        .withCANbusName(kCANbusName);

        private static final SwerveModuleConstantsFactory ConstantCreator = new SwerveModuleConstantsFactory()
                        .withDriveMotorGearRatio(kDriveGearRatio)
                        .withSteerMotorGearRatio(kSteerGearRatio)
                        .withWheelRadius(kWheelRadiusInches)
                        .withSlipCurrent(kSlipCurrentA)
                        .withSteerMotorGains(steerGains)
                        .withDriveMotorGains(driveGains)
                        .withSteerMotorClosedLoopOutput(steerClosedLoopOutput)
                        .withDriveMotorClosedLoopOutput(driveClosedLoopOutput)
                        .withSpeedAt12VoltsMps(kSpeedAt12VoltsMps)
                        .withSteerInertia(kSteerInertia)
                        .withDriveInertia(kDriveInertia)
                        .withSteerFrictionVoltage(kSteerFrictionVoltage)
                        .withDriveFrictionVoltage(kDriveFrictionVoltage)
                        .withFeedbackSource(SteerFeedbackType.FusedCANcoder)
                        .withCouplingGearRatio(kCoupleRatio)
                        .withSteerMotorInverted(kSteerMotorReversed);

        // Front Left
        private static final int kFrontLeftDriveMotorId = 12;
        private static final int kFrontLeftSteerMotorId = 11;
        private static final int kFrontLeftEncoderId = 10;
        private static final double kFrontLeftEncoderOffset = -0.493896484375;

        private static final double kFrontLeftXPosInches = 12;
        private static final double kFrontLeftYPosInches = 12;

        // Front Right
        private static final int kFrontRightDriveMotorId = 22;
        private static final int kFrontRightSteerMotorId = 21;
        private static final int kFrontRightEncoderId = 20;
        private static final double kFrontRightEncoderOffset = 0.44580078125;

        private static final double kFrontRightXPosInches = 12;
        private static final double kFrontRightYPosInches = -12;

        // Back Left
        private static final int kBackLeftDriveMotorId = 32;
        private static final int kBackLeftSteerMotorId = 31;
        private static final int kBackLeftEncoderId = 30;
        private static final double kBackLeftEncoderOffset = -0.350341796875;

        private static final double kBackLeftXPosInches = -12;
        private static final double kBackLeftYPosInches = 12;

        // Back Right
        private static final int kBackRightDriveMotorId = 52;
        private static final int kBackRightSteerMotorId = 51;
        private static final int kBackRightEncoderId = 40;
        private static final double kBackRightEncoderOffset = -0.08056640625;

        private static final double kBackRightXPosInches = -12;
        private static final double kBackRightYPosInches = -12;

        private static final SwerveModuleConstants FrontLeft = ConstantCreator.createModuleConstants(
                        kFrontLeftSteerMotorId, kFrontLeftDriveMotorId, kFrontLeftEncoderId, kFrontLeftEncoderOffset,
                        Units.inchesToMeters(kFrontLeftXPosInches), Units.inchesToMeters(kFrontLeftYPosInches),
                        kInvertLeftSide);
        private static final SwerveModuleConstants FrontRight = ConstantCreator.createModuleConstants(
                        kFrontRightSteerMotorId, kFrontRightDriveMotorId, kFrontRightEncoderId,
                        kFrontRightEncoderOffset, Units.inchesToMeters(kFrontRightXPosInches),
                        Units.inchesToMeters(kFrontRightYPosInches), kInvertRightSide);
        private static final SwerveModuleConstants BackLeft = ConstantCreator.createModuleConstants(
                        kBackLeftSteerMotorId, kBackLeftDriveMotorId, kBackLeftEncoderId, kBackLeftEncoderOffset,
                        Units.inchesToMeters(kBackLeftXPosInches), Units.inchesToMeters(kBackLeftYPosInches),
                        kInvertLeftSide);
        private static final SwerveModuleConstants BackRight = ConstantCreator.createModuleConstants(
                        kBackRightSteerMotorId, kBackRightDriveMotorId, kBackRightEncoderId, kBackRightEncoderOffset,
                        Units.inchesToMeters(kBackRightXPosInches), Units.inchesToMeters(kBackRightYPosInches),
                        kInvertRightSide);

        public static final CommandSwerveDrivetrain DriveTrain = new CommandSwerveDrivetrain(DrivetrainConstants,
                        FrontLeft,
                        FrontRight, BackLeft, BackRight);

                        static double dev = 2.3d;
        public static final HolonomicPathFollowerConfig FollowConfig = new HolonomicPathFollowerConfig(
                        new PIDConstants(dev, 0.0, 0.0), // Translation PID constants
                        new PIDConstants(dev, 0.0, 0.0), // Rotation PID constants
                        TunerConstants.kSpeedAt12VoltsMps, // Max module speed, in m/s
                        Units.inchesToMeters(Math.sqrt(Math.pow(14.75, 2) + Math.pow(14.75, 2))),
                        new ReplanningConfig() // Default path replanning config. See the API for the options here
        );

        public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
                        new Translation2d(TunerConstants.FrontLeft.LocationX, TunerConstants.FrontLeft.LocationY),
                        new Translation2d(TunerConstants.FrontRight.LocationX, TunerConstants.FrontRight.LocationY),
                        new Translation2d(TunerConstants.BackLeft.LocationX, TunerConstants.BackLeft.LocationY),
                        new Translation2d(TunerConstants.BackRight.LocationX, TunerConstants.BackRight.LocationY)

        );

}