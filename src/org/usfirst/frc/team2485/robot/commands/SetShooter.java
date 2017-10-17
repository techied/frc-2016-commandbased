package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SetShooter extends Command {

	boolean isEnabled = false;

	public SetShooter() {
		requires(RobotMap.shooter);
	}

	@Override
	protected void execute() {
		if (isEnabled) {
			RobotMap.shooter.setPWM(0);
		} else {
			RobotMap.shooter.setPWM(0.5);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
