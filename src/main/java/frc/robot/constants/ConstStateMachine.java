package frc.robot.constants;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.commands.states.Climbing;
import frc.robot.commands.states.HasPowerCube;
import frc.robot.commands.states.Intaking;
import frc.robot.commands.states.None;
import frc.robot.commands.states.PrepClimb;
import frc.robot.commands.states.Scoring;
import frc.robot.commands.states.PrepIntakings.PrepIntakeLV1;
import frc.robot.commands.states.PrepIntakings.PrepIntakeLV2;
import frc.robot.commands.states.PrepIntakings.PrepIntakeLV3;
import frc.robot.commands.states.PrepIntakings.PrepIntakePortal;
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
      Map.ofEntries(
          Map.entry(RobotStates.NONE, Set.of(
              // Allow to go to
              RobotStates.NONE,
              RobotStates.PREP_INTAKE_LV1,
              RobotStates.PREP_INTAKE_LV2,
              RobotStates.PREP_INTAKE_LV3,
              RobotStates.PREP_INTAKE_PORTAL,
              RobotStates.PREP_CLIMB)),

          Map.entry(RobotStates.PREP_INTAKE_PORTAL, Set.of(
              RobotStates.INTAKING,
              RobotStates.PREP_INTAKE_LV2,
              RobotStates.PREP_INTAKE_LV3,
              RobotStates.PREP_INTAKE_LV1)),

          Map.entry(RobotStates.PREP_INTAKE_LV1, Set.of(
              RobotStates.INTAKING,
              RobotStates.PREP_INTAKE_LV2,
              RobotStates.PREP_INTAKE_LV3,
              RobotStates.PREP_INTAKE_PORTAL)),

          Map.entry(RobotStates.PREP_INTAKE_LV2, Set.of(
              RobotStates.INTAKING,
              RobotStates.PREP_INTAKE_LV1,
              RobotStates.PREP_INTAKE_LV3,
              RobotStates.PREP_INTAKE_PORTAL)),

          Map.entry(RobotStates.PREP_INTAKE_LV3, Set.of(
              RobotStates.INTAKING,
              RobotStates.PREP_INTAKE_LV1,
              RobotStates.PREP_INTAKE_LV2,
              RobotStates.PREP_INTAKE_PORTAL)),

          Map.entry(RobotStates.INTAKING, Set.of(
              RobotStates.HAS_POWER_CUBE,
              RobotStates.NONE)),

          Map.entry(RobotStates.HAS_POWER_CUBE, Set.of(
              RobotStates.NONE,
              RobotStates.PREP_EXCHANGE,
              RobotStates.PREP_LEVELED_SCALE,
              RobotStates.PREP_LEVELED_2_LAYERS,
              RobotStates.PREP_TIPPED_UP_SCALE,
              RobotStates.PREP_TIPPED_UP_2_LAYERS,
              RobotStates.PREP_TIPPED_DOWN_SCALE,
              RobotStates.PREP_TIPPED_DOWN_2_LAYERS,
              RobotStates.PREP_SWITCH)),

          Map.entry(RobotStates.PREP_EXCHANGE, Set.of(
              RobotStates.SCORING,
              RobotStates.PREP_LEVELED_SCALE,
              RobotStates.PREP_LEVELED_2_LAYERS,
              RobotStates.PREP_TIPPED_UP_SCALE,
              RobotStates.PREP_TIPPED_UP_2_LAYERS,
              RobotStates.PREP_TIPPED_DOWN_SCALE,
              RobotStates.PREP_TIPPED_DOWN_2_LAYERS,
              RobotStates.PREP_SWITCH)),

          Map.entry(RobotStates.PREP_LEVELED_SCALE, Set.of(
              RobotStates.SCORING,
              RobotStates.PREP_EXCHANGE,
              RobotStates.PREP_LEVELED_2_LAYERS,
              RobotStates.PREP_TIPPED_UP_SCALE,
              RobotStates.PREP_TIPPED_UP_2_LAYERS,
              RobotStates.PREP_TIPPED_DOWN_SCALE,
              RobotStates.PREP_TIPPED_DOWN_2_LAYERS,
              RobotStates.PREP_SWITCH)),

          Map.entry(RobotStates.PREP_LEVELED_2_LAYERS, Set.of(
              RobotStates.SCORING,
              RobotStates.PREP_EXCHANGE,
              RobotStates.PREP_LEVELED_SCALE,
              RobotStates.PREP_TIPPED_UP_SCALE,
              RobotStates.PREP_TIPPED_UP_2_LAYERS,
              RobotStates.PREP_TIPPED_DOWN_SCALE,
              RobotStates.PREP_TIPPED_DOWN_2_LAYERS,
              RobotStates.PREP_SWITCH)),

          Map.entry(RobotStates.PREP_TIPPED_UP_SCALE, Set.of(
              RobotStates.SCORING,
              RobotStates.PREP_EXCHANGE,
              RobotStates.PREP_LEVELED_SCALE,
              RobotStates.PREP_LEVELED_2_LAYERS,
              RobotStates.PREP_TIPPED_UP_2_LAYERS,
              RobotStates.PREP_TIPPED_DOWN_SCALE,
              RobotStates.PREP_TIPPED_DOWN_2_LAYERS,
              RobotStates.PREP_SWITCH)),

          Map.entry(RobotStates.PREP_TIPPED_UP_2_LAYERS, Set.of(
              RobotStates.SCORING,
              RobotStates.PREP_EXCHANGE,
              RobotStates.PREP_LEVELED_SCALE,
              RobotStates.PREP_LEVELED_2_LAYERS,
              RobotStates.PREP_TIPPED_UP_SCALE,
              RobotStates.PREP_TIPPED_DOWN_SCALE,
              RobotStates.PREP_TIPPED_DOWN_2_LAYERS,
              RobotStates.PREP_SWITCH)),

          Map.entry(RobotStates.PREP_TIPPED_DOWN_SCALE, Set.of(
              RobotStates.SCORING,
              RobotStates.PREP_EXCHANGE,
              RobotStates.PREP_LEVELED_SCALE,
              RobotStates.PREP_LEVELED_2_LAYERS,
              RobotStates.PREP_TIPPED_UP_SCALE,
              RobotStates.PREP_TIPPED_UP_2_LAYERS,
              RobotStates.PREP_TIPPED_DOWN_2_LAYERS,
              RobotStates.PREP_SWITCH)),

          Map.entry(RobotStates.PREP_TIPPED_DOWN_2_LAYERS, Set.of(
              RobotStates.SCORING,
              RobotStates.PREP_EXCHANGE,
              RobotStates.PREP_LEVELED_SCALE,
              RobotStates.PREP_LEVELED_2_LAYERS,
              RobotStates.PREP_TIPPED_UP_SCALE,
              RobotStates.PREP_TIPPED_UP_2_LAYERS,
              RobotStates.PREP_TIPPED_DOWN_SCALE,
              RobotStates.PREP_SWITCH)),

          Map.entry(RobotStates.PREP_SWITCH, Set.of(
              RobotStates.SCORING,
              RobotStates.PREP_EXCHANGE,
              RobotStates.PREP_LEVELED_SCALE,
              RobotStates.PREP_LEVELED_2_LAYERS,
              RobotStates.PREP_TIPPED_UP_SCALE,
              RobotStates.PREP_TIPPED_UP_2_LAYERS,
              RobotStates.PREP_TIPPED_DOWN_SCALE,
              RobotStates.PREP_TIPPED_DOWN_2_LAYERS)),

          Map.entry(RobotStates.SCORING, Set.of(
              RobotStates.NONE)),

          Map.entry(RobotStates.PREP_CLIMB, Set.of(
              RobotStates.NONE,
              RobotStates.CLIMBING)),

          Map.entry(RobotStates.CLIMBING, Set.of(
              RobotStates.PREP_CLIMB)));
}
