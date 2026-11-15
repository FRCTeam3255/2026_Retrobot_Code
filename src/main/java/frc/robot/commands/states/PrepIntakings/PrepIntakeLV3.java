// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states.PrepIntakings;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.constants.ConstPositional;
import frc.robot.constants.ConstStateMachine.RobotStates;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class PrepIntakeLV3 extends BasePrepIntake {
  /** Creates a new PrepIntakeLV3. */
  public PrepIntakeLV3() {
    super(ConstPositional.PREP_INTAKE_LV3_HEIGHT);
  }
}
