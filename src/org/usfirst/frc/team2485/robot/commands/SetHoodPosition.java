package org.usfirst.frc.team2485.robot.commands;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.robot.subsystems.Shooter.HoodPosition;

import edu.wpi.first.wpilibj.command.Command;

public class SetHoodPosition extends Command {

	public SetHoodPosition() {
		requires(RobotMap.shooter);
	}
	
	@Override
	protected void execute() {
		if(RobotMap.shooter.getHoodPosition().equals(HoodPosition.STOWED)) {
			RobotMap.shooter.setHoodPosition(HoodPosition.LOW_ANGLE);
		} else if (RobotMap.shooter.getHoodPosition().equals(HoodPosition.LOW_ANGLE)) {
			RobotMap.shooter.setHoodPosition(HoodPosition.HIGH_ANGLE);
		} else if (RobotMap.shooter.getHoodPosition().equals(HoodPosition.HIGH_ANGLE)){
			RobotMap.shooter.setHoodPosition(HoodPosition.STOWED);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
}
