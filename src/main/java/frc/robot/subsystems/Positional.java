// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicExpoVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceIDs;
import frc.robot.Robot;
import frc.robot.constants.ConstPositional;

@Logged
public class Positional extends SubsystemBase {
  MotionMagicExpoVoltage positionRequest = new MotionMagicExpoVoltage(0);
  public Distance elevatorLiftLastDesiredPosition = Units.Inches.zero();

  final TalonFX elevatorWestLeader = new TalonFX(DeviceIDs.positionalIDs.ELEVATOR_WEST_CAN);
  final TalonFX elevatorEastFollower = new TalonFX(DeviceIDs.positionalIDs.ELEVATOR_EAST_CAN);
  final TalonFX forkLift = new TalonFX(DeviceIDs.positionalIDs.FORK_LIFT_CAN);

  Follower ElevatorFollower = new Follower(elevatorWestLeader.getDeviceID(), MotorAlignmentValue.Opposed);

  public Positional() {
    elevatorEastFollower.getConfigurator().apply(ConstPositional.EAST_LIFT_CONFIG);
    elevatorWestLeader.getConfigurator().apply(ConstPositional.WEST_LIFT_CONFIG);
    forkLift.getConfigurator().apply(ConstPositional.FORK_CONFIG);
  }

  public void setLiftPosition(Distance height) {
    elevatorWestLeader.setControl(positionRequest.withPosition(height.in(Units.Inches)));
    elevatorEastFollower.setControl(ElevatorFollower);
    elevatorLiftLastDesiredPosition = height;
  }

  public Distance getLiftPosition() {
    if (Robot.isSimulation()) {
      return elevatorLiftLastDesiredPosition;
    }
    return Units.Inches.of(elevatorWestLeader.getPosition().getValueAsDouble());
  }

  public void setForkLiftPercentOutput(double percentOutput) {
    forkLift.set(percentOutput);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
