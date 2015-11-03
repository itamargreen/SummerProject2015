package org.usfirst.frc.team2212.subsystems;

import org.usfirst.frc.team2212.commands.DoubleJoystickDrive;
import org.usfirst.frc.team2212.robot.Hardware;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	Gearbox left, right;

	public Drivetrain() {
		this.left = Hardware.leftGearbox;
		this.right = Hardware.rightGearbox;
	}

	/**
	 * Drive straight in a specified speed.
	 * 
	 * @param speed
	 */
	public void straight(double speed) {
		left.set(-speed);
		right.set(speed);

	}

	public void turn(double speed) {
		left.set(speed);
		right.set(speed);

	}

	public void setTwoSides(double leftSpeed, double rightSpeed) {
		left.set(-leftSpeed);
		right.set(rightSpeed);

	}

	public void arcade(double moveValue, double rotateValue) {
		double leftSpeed, rightSpeed;
		if (moveValue > 0.0) {
			if (rotateValue > 0.0) {
				leftSpeed = moveValue - rotateValue;
				rightSpeed = Math.max(moveValue, rotateValue);
			} else {
				leftSpeed = Math.max(moveValue, -rotateValue);
				rightSpeed = moveValue + rotateValue;
			}
		} else {
			if (rotateValue > 0.0) {
				leftSpeed = -Math.max(-moveValue, rotateValue);
				rightSpeed = moveValue + rotateValue;
			} else {
				leftSpeed = moveValue - rotateValue;
				rightSpeed = -Math.max(-moveValue, -rotateValue);
			}
		}
		setTwoSides(leftSpeed, rightSpeed);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DoubleJoystickDrive());
	}
}
