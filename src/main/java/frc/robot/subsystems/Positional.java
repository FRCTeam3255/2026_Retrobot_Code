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

@Logged
public class Positional extends SubsystemBase {
  MotionMagicExpoVoltage positionRequest = new MotionMagicExpoVoltage(0);
  private Distance elevatorLiftLastDesiredPosition = Units.Inches.zero();

  final TalonFX ElevatorWestLeader = new TalonFX(DeviceIDs.positionalIDs.ELEVATOR_WEST_CAN);
  final TalonFX ElevatorEastFollower = new TalonFX(DeviceIDs.positionalIDs.ELEVATOR_EAST_CAN);

  Follower ElevatorFollower = new Follower(ElevatorWestLeader.getDeviceID(), MotorAlignmentValue.Opposed);

  public Positional() {
  }

  public void setLiftPosition(Distance height) {
    ElevatorWestLeader.setControl(positionRequest.withPosition(height.in(Units.Inches)));
    ElevatorEastFollower.setControl(ElevatorFollower);
    elevatorLiftLastDesiredPosition = height;
  }

  public Distance getLiftPosition() {
    if (Robot.isSimulation()) {
      return elevatorLiftLastDesiredPosition;
    }
    return Units.Inches.of(ElevatorWestLeader.getPosition().getValueAsDouble());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
