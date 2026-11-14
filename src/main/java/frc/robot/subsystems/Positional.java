// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.module.Configuration;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceIDs;
import frc.robot.DeviceIDs.positionalIDs;

@Logged
public class Positional extends SubsystemBase {
  public Positional() {
    final TalonFX elevatorWestLeader = new TalonFX (DeviceIDs.positionalIDs.ELEVATOR_WEST_CAN);
    final TalonFX elevatorEastFollower = new TalonFX (DeviceIDs.positionalIDs.ELEVATOR_EAST_CAN);
    final TalonFX buddyClimbMotor = new TalonFX (DeviceIDs.positionalIDs.BUDDY_CLIMB_CAN);
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
