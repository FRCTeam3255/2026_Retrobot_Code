package frc.robot.constants;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;
import frc.robot.commands.states.None;

public final class ConstStateMachine {
  private ConstStateMachine() {
  }

  public enum RobotStates {
    NONE(None::new);

    public final Supplier<Command> commandFactory;

    RobotStates(Supplier<Command> commandFactory) {
      this.commandFactory = commandFactory;
    }

    /**
     * Requests this state on the robot's state machine, validating the transition.
     */
    public Command TRY() {
      return RobotContainer.stateMachineInstance.tryState(this);
    }
  }

  public static final Map<RobotStates, Set<RobotStates>> TRANSITIONS =
      // Target State
      Map.of(RobotStates.NONE, Set.of(
          // Allow to come from
          RobotStates.NONE

      ));
}
