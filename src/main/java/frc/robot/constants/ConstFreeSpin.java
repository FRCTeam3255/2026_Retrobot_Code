// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;

/** Add your docs here. */
public class ConstFreeSpin {

  public static final double STOP = 0;
  public static final double HAS_POWER_CUBE_PERCENT_OUT = 0.025;
  public static final double INTAKE_CUBE_PERCENT_OUT =  1;
  public static double INTAKE_SCORING_PERCENT_OUTPUT = -0.5;

  public static Current INTAKE_CUBE_CURRENT = Units.Amps.of(35);
  public static AngularVelocity INTAKE_CUBE_VELOCITY = Units.RPM.of(4500);

  public static TalonFXConfiguration INTAKE_EAST_CONFIG = new TalonFXConfiguration();
  public static TalonFXConfiguration INTAKE_WEST_CONFIG = new TalonFXConfiguration();

  static {
    // Configure TalonFXConfiguration objects here
    INTAKE_EAST_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    INTAKE_EAST_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;

    INTAKE_WEST_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    INTAKE_WEST_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
  }
}
