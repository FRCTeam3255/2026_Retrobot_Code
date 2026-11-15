// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states.PrepIntakings;

import static edu.wpi.first.units.Units.Inches;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class BasePrepIntake extends Command {
  /** Creates a new BasePrepScoring. */

  Distance elevatorPosition = Inches.zero();

  public BasePrepIntake(Distance elevatorPosition) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.elevatorPosition = elevatorPosition;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.positionalInstance.setLiftPosition(elevatorPosition);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
