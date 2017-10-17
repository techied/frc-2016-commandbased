package org.usfirst.frc.team2485.robot.subsystems;

import java.util.Timer;
import java.util.TimerTask;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.SpeedControllerWrapper;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	/**
	 * Low Angle = Long Shot <br>
	 * High Angle = Batter Shot <br>
	 * Stowed = Don't Shoot <br>
	 */

	public static enum HoodPosition {
		LOW_ANGLE, HIGH_ANGLE, STOWED
	};

	public static double RPS_LONG_SHOT = 95, RPS_BATTER_SHOT = 80;

	private static final HoodPosition DEFAULT_HOOD_POSITION = HoodPosition.HIGH_ANGLE;
	private SpeedControllerWrapper shooterMotors;
	private HoodPosition currHoodPosition;

	public Shooter() {
		shooterMotors = new SpeedControllerWrapper(
				new SpeedController[] { RobotMap.leftShooter, RobotMap.rightShooter }, new double[] { 0.0, 0.0 });

		currHoodPosition = DEFAULT_HOOD_POSITION;

		disableShooter();
	}

	@Override
	protected void initDefaultCommand() {

	}

	public void disableShooter() {

		shooterMotors.disable();
		shooterMotors.emergencyStop();

	}

	public void setHoodPosition(final HoodPosition newHoodPosition) {

		if (newHoodPosition == HoodPosition.LOW_ANGLE) {
			if (currHoodPosition == HoodPosition.HIGH_ANGLE) {
				RobotMap.upperSolenoid.set(true); // This should extend the upper piston
			} else if (currHoodPosition == HoodPosition.STOWED) {
				RobotMap.lowerSolenoid.set(false); // Retracting the lower piston pulls open the shooter

				new Timer().schedule(new TimerTask() {

					@Override
					public void run() {
						RobotMap.upperSolenoid.set(true);
					}
				}, 250);
			}
		} else if (newHoodPosition == HoodPosition.HIGH_ANGLE) {
			if (currHoodPosition == HoodPosition.LOW_ANGLE) {
				RobotMap.upperSolenoid.set(false);

			} else if (currHoodPosition == HoodPosition.STOWED) {
				RobotMap.lowerSolenoid.set(false);
			}
		} else { // setting to stowed

			if (currHoodPosition == HoodPosition.LOW_ANGLE) {

				RobotMap.upperSolenoid.set(false);

				new Timer().schedule(new TimerTask() {

					@Override
					public void run() {
						RobotMap.lowerSolenoid.set(true);
					}
				}, 250);

			} else if (currHoodPosition == HoodPosition.HIGH_ANGLE) {
				RobotMap.lowerSolenoid.set(true);
			}
		}

		currHoodPosition = newHoodPosition;

	}

	public void resetHood() {
		setHoodPosition(DEFAULT_HOOD_POSITION);
	}

	public HoodPosition getHoodPosition() {
		return currHoodPosition;
	}

	public void setPWM(double pwm) {

		shooterMotors.set(pwm);

	}

	public double getRate() {

		return RobotMap.shooterEncoder.getRate();

	}

	/**
	 * Checks if the current error is within the percentage given from the last
	 * setpoint
	 * 
	 * @param maxPercentError
	 *            the maximum error, as a percent, from 0.0 to 1.0
	 */

	public double getCurrentPower() {

		return shooterMotors.get();

	}

}
