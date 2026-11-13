package frc.robot.subsystems;

import java.util.Set;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.ConstStateMachine;
import frc.robot.constants.ConstStateMachine.RobotStates;

/**
 * State transition engine.
 *
 * State definitions and transitions are configured in
 * {@link ConstStateMachine}.
 */
@Logged
public class StateMachine extends SubsystemBase {

  private RobotStates currentState = RobotStates.NONE;
  private RobotStates previousState = RobotStates.NONE;

  public RobotStates getRobotState() {
    return currentState;
  }

  public RobotStates getPreviousRobotState() {
    return previousState;
  }

  /** Is this move allowed right now? Useful for tests and for LEDs. */
  public boolean canGoTo(RobotStates desired) {
    return ConstStateMachine.TRANSITIONS.getOrDefault(currentState, Set.of()).contains(desired);
  }

  /**
   * Ask the robot to change state.
   *
   * <p>
   * Wrapped in defer() on purpose: this method usually runs ONCE at startup when
   * you bind a
   * button, but the answer to "is this legal" depends on what state we are in
   * when the button is
   * actually pressed. defer() delays the decision until press time.
   */
  public Command tryState(RobotStates desired) {
    return Commands.defer(
        () -> {
          if (!canGoTo(desired)) {
            return Commands.print(
                "Rejected " + currentState + " -> " + desired + " (not in LEGAL_MOVES)");
          }
          previousState = currentState;
          return desired.commandFactory.get().beforeStarting(() -> currentState = desired);
        },
        Set.of(this));
  }

  public void setState(RobotStates state) {
    currentState = state;
  }

  @Override
  public void periodic() {
  }
}