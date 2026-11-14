package frc.robot.constants;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RobotContainer;
import frc.robot.commands.states.*;
import frc.robot.commands.states.PrepIntakings.*;
import frc.robot.commands.states.PrepScorings.PrepExchange;
import frc.robot.commands.states.PrepScorings.PrepLeveled2Layers;
import frc.robot.commands.states.PrepScorings.PrepLeveledScale;
import frc.robot.commands.states.PrepScorings.PrepSwitch;
import frc.robot.commands.states.PrepScorings.PrepTippedDownScale;
import frc.robot.commands.states.PrepScorings.PrepTippedUp2Layers;
import frc.robot.commands.states.PrepScorings.PrepTippedUpScale;

public final class ConstStateMachine {
  private ConstStateMachine() {
  }

  public enum RobotStates {
    NONE(None::new),
    PREP_INTAKE_LV1(PrepIntakeLV1::new),
    PREP_INTAKE_LV2(PrepIntakeLV2::new),
    PREP_INTAKE_LV3(PrepIntakeLV3::new),
    PREP_INTAKE_PORTAL(PrepIntakePortal::new),
    PREP_EXCHANGE(PrepExchange::new),
    PREP_LEVELED_SCALE(PrepLeveledScale::new),
    PREP_LEVELED_2_LAYERS(PrepLeveled2Layers::new),
    PREP_TIPPED_UP_SCALE(PrepTippedUpScale::new),
    PREP_TIPPED_UP_2_LAYERS(PrepTippedUp2Layers::new),
    PREP_TIPPED_DOWN_SCALE(PrepTippedDownScale::new),
    PREP_TIPPED_DOWN_2_LAYERS(PrepTippedUp2Layers::new),
    PREP_SWITCH(PrepSwitch::new),
    INTAKING(Intaking::new),
    HAS_POWER_CUBE(HasPowerCube::new),
    PREP_CLIMB(PrepClimb::new),
    CLIMBING(Climbing::new),
    SCORING(Scoring::new);

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
