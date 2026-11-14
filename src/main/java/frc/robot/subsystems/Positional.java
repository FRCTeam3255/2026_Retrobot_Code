// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicExpoVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import com.ctre.phoenix6.sim.TalonFXSimState;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceIDs;
import frc.robot.Robot;

@Logged
public class Positional extends SubsystemBase {
  final TalonFX elevatorWestLeader = new TalonFX(DeviceIDs.positionalIDs.ELEVATOR_WEST_LEADER);
  final TalonFX elevatorEastFollower = new TalonFX(DeviceIDs.positionalIDs.ELEVATOR_EAST_FOLLOWER);
  final TalonFX buddyClimbMotor = new TalonFX(DeviceIDs.positionalIDs.BUDDY_CLIMB_MOTOR);

  Follower elevatorFollower = new Follower(elevatorWestLeader.getDeviceID(), MotorAlignmentValue.Opposed);
  MotionMagicExpoVoltage positionRequest = new MotionMagicExpoVoltage(0);

  private Distance elevatorLiftDesiredPosition = Units.Inches.zero();

  public Positional() {
  }

  public void setLiftPosition(Distance height) {

    elevatorWestLeader.setControl(positionRequest.withPosition(height.in(Units.Inches)));
    elevatorEastFollower.setControl(elevatorFollower);
    elevatorLiftDesiredPosition = height;

  }

  public Distance getLiftPosition()  {
    if (Robot.isSimulation()) {
      return elevatorLiftDesiredPosition;
    }
    return Units.Inches.of(elevatorWestLeader.getPosition().getValueAsDouble());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
