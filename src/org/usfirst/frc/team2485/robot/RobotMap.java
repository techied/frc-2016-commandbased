package org.usfirst.frc.team2485.robot;

import org.usfirst.frc.team2485.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2485.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	public static VictorSP[] rightDriveVictorSPs = new VictorSP[3];
	public static VictorSP[] leftDriveVictorSPs = new VictorSP[3];

	public static Talon leftShooterMotor;
	public static Talon rightShooterMotor;

	public static Encoder shooterEncoder;

	public static SpeedControllerWrapper leftDrive;
	public static SpeedControllerWrapper rightDrive;

	public static SpeedControllerWrapper leftShooter;
	public static SpeedControllerWrapper rightShooter;

	public static DriveTrain driveTrain;
	
	public static Shooter shooter;

	public static Solenoid lowerSolenoid, upperSolenoid;

	public static void init() {

		// Initializing hardware.

		// Constructing hardware.
		rightDriveVictorSPs = new VictorSP[] { new VictorSP(5), new VictorSP(6), new VictorSP(7) };
		leftDriveVictorSPs = new VictorSP[] { new VictorSP(2), new VictorSP(3), new VictorSP(4) };

		leftShooterMotor = new Talon(3);
		rightShooterMotor = new Talon(2);

		leftShooterMotor.setInverted(true);
		rightShooterMotor.setInverted(false);

		// channelA, channelB, reverse direction?, encoder type
		shooterEncoder = new Encoder(6, 7, false, EncodingType.k1X);

		leftDrive = new SpeedControllerWrapper(leftDriveVictorSPs);
		rightDrive = new SpeedControllerWrapper(rightDriveVictorSPs);

		leftShooter = new SpeedControllerWrapper(leftShooterMotor);
		rightShooter = new SpeedControllerWrapper(rightShooterMotor);

		// Constructing subsystems
		driveTrain = new DriveTrain();
		
		shooter = new Shooter();

		// Solenoids
		lowerSolenoid = new Solenoid(4);
		upperSolenoid = new Solenoid(5);
	}
}
