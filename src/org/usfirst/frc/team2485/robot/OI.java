package org.usfirst.frc.team2485.robot;

import org.usfirst.frc.team2485.robot.commands.SetHoodPosition;
import org.usfirst.frc.team2485.robot.commands.SetShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static Joystick driver;
	public static Joystick operator;
	
	public static final int XBOX_BUTTON_A = 1;
	public static final int XBOX_BUTTON_B = 2;
	
	public static final int XBOX_LEFT_Y = 1;
	public static final int XBOX_RIGHT_X = 4;
	
	void init() {
		driver = new Joystick(0);
		operator = new Joystick(1);
		new JoystickButton(driver, XBOX_BUTTON_A).whenReleased(new SetShooter());
		new JoystickButton(driver, XBOX_BUTTON_B).whenReleased(new SetHoodPosition());
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
