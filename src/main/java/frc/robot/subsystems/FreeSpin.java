// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DeviceIDs;
import frc.robot.Robot;
import frc.robot.constants.ConstFreeSpin;

@Logged
public class FreeSpin extends SubsystemBase {
  final TalonFX intakeWestLeader = new TalonFX(DeviceIDs.freeSpinIDs.INTAKE_WEST_CAN);
  final TalonFX intakeEastFollower = new TalonFX(DeviceIDs.freeSpinIDs.INTAKE_EAST_CAN);

  Follower intakeFollower = new Follower(intakeWestLeader.getDeviceID(), MotorAlignmentValue.Opposed);

  private double lastDesiredIntakePercentOutput = 0;

  public FreeSpin() {
    intakeWestLeader.getConfigurator().apply(ConstFreeSpin.INTAKE_WEST_CONFIG);
    intakeEastFollower.getConfigurator().apply(ConstFreeSpin.INTAKE_EAST_CONFIG);

  }

  public void setIntakePercentOutput(double percentOutput) {

    intakeWestLeader.set(percentOutput);
    intakeEastFollower.setControl(intakeFollower);

    lastDesiredIntakePercentOutput = percentOutput;
  }

  public double getIntakePercentOutput() {
    if (Robot.isSimulation()) {
      return lastDesiredIntakePercentOutput;
    }
    return intakeWestLeader.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
