package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.OI;
import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithControllers extends Command {

	public DriveWithControllers() {
		requires(RobotMap.driveTrain);
		setInterruptible(true);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void execute() {
		double steering = OI.driver.getRawAxis(OI.XBOX_RIGHT_X);
		double throttle = OI.operator.getRawAxis(OI.XBOX_LEFT_Y);
		RobotMap.driveTrain.warlordDrive(steering, throttle);
	}

	public void end() {
	}
}
