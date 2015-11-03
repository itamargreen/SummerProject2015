package org.usfirst.frc.team2212.commands;

import org.usfirst.frc.team2212.robot.Subsystems;

/**
 * Stops the picker
 *
 */
public class StopPicker extends SingleActionCommand {

	public StopPicker() {
		requires(Subsystems.picker);
	}

	@Override
	protected void doAction() {
		Subsystems.picker.stop();
	}
}
