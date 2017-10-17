package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.commands.DriveWithControllers;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	private static final double THROTTLE_DEADBAND = 0.1;
	private static final double STEERING_DEADBAND = 0.1;

	public void warlordDrive(double controllerY, double controllerX) {
		if (Math.abs(controllerY) < THROTTLE_DEADBAND) {
			controllerY = 0;
		}

		if (Math.abs(controllerX) < STEERING_DEADBAND) {
			controllerX = 0;
		}

		double left = controllerY * (1 - controllerX);
		double right = controllerY * (1 + controllerX);

		if (left > 1) {
			right /= left;
			left /= left;
		}

		if (right > 1) {
			left /= right;
			right /= right;
		}

		setLeftRight(left, right);
	}

	public void setLeftRight(double leftPwm, double rightPwm) {
		RobotMap.leftDrive.set(leftPwm);
		RobotMap.rightDrive.set(rightPwm);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveWithControllers());
	}
}
