// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.states;

import edu.wpi.first.wpilibj2.command.Command;
<<<<<<< HEAD

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Scoring extends Command {
  /** Creates a new Scoring. */
=======
import frc.robot.RobotContainer;
import frc.robot.constants.ConstStateMachine.RobotStates;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Scoring extends Command {
  /** Creates a new SCORING. */
>>>>>>> 37aef8d3620ffb173c562d2b16a155ce57282c0a
  public Scoring() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
<<<<<<< HEAD
  public void initialize() {}
=======
  public void initialize() {
        RobotContainer.stateMachineInstance.setState(RobotStates.SCORING);

  }
>>>>>>> 37aef8d3620ffb173c562d2b16a155ce57282c0a

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
