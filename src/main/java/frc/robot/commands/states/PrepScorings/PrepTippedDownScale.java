// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states.PrepScorings;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.ConstPositional;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class PrepTippedDownScale extends BasePrepScoring {
  /** Creates a new PrepTippedDownScale. */
  public PrepTippedDownScale(){
    super(ConstPositional.PREP_TIPPED_DOWN_SCALE_HEIGHT);
  }}