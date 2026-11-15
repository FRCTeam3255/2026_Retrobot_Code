// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Distance;

/** Add your docs here. */
public class ConstPositional {
  public static final double STOP = 0;

  public static final Distance PREP_SWITCH = Units.Inches.of(0); // TODO:GET ACTUAL VALUE
  public static final double FORK_OUT = 0.2;
  public static final Distance CLIMB = Units.Inches.of(0);
  public static final Distance PREP_CLIMB = Units.Inches.of(50); // TODO:GET ACTUAL VALUE
  public static final Distance PREP_EXCHANGE_HEIGHT = Units.Inches.of(5);
  public static final Distance PREP_TIPPED_UP_2_LAYERS_HEIGHT = Units.Inches.of(15);
  public static final Distance PREP_TIPPED_UP_SCALE_HEIGHT = Units.Inches.of(12);
  public static final Distance PREP_TIPPED_DOWN_SCALE_HEIGHT = Units.Inches.of(5);
  public static final Distance PREP_LEVELED_2_LAYERS_HEIGHT = Units.Inches.of(5);
  public static final Distance PREP_TIPPED_DOWN_2_LAYERS_HEIGHT = Units.Inches.of(5);
  public static final Distance PREP_SCALE_HEIGHT = Units.Inches.of(5);

  public static final Distance ZERO = Units.Inches.of(0);
  public static final Distance PREP_INTAKE_LV1_HEIGHT = Units.Inches.of(10); // TODO:GET ACTUAL VALUE
  public static final Distance PREP_INTAKE_LV2_HEIGHT = Units.Inches.of(15); // TODO:GET ACTUAL VALUE
  public static final Distance PREP_INTAKE_LV3_HEIGHT = Units.Inches.of(20); // TODO:GET ACTUAL VALUE
  public static final Distance PREP_INTAKE_PORTAL = Units.Inches.of(5); // TODO:GET ACTUAL VALUE

  public static TalonFXConfiguration LIFT_CONFIG = new TalonFXConfiguration();
  public static TalonFXConfiguration FORK_CONFIG = new TalonFXConfiguration();

  static {
    // Configure TalonFXConfiguration objects here
    FORK_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    FORK_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;

    LIFT_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    LIFT_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    LIFT_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    LIFT_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Inches.of(0).in(Units.Inches);
    LIFT_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    LIFT_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Inches.of(0).in(Units.Inches);
    LIFT_CONFIG.Slot0.GravityType = GravityTypeValue.Elevator_Static;
    LIFT_CONFIG.Slot0.kP = 0;
    LIFT_CONFIG.Slot0.kI = 0;
    LIFT_CONFIG.Slot0.kD = 0;
    LIFT_CONFIG.Slot0.kS = 0.0;
    LIFT_CONFIG.Slot0.kG = 0.0;

    LIFT_CONFIG.Feedback.SensorToMechanismRatio = 1.0 / ((12.0 / 48.0) * (24.0 / 60.0) * (1.751 * Math.PI));

    LIFT_CONFIG.MotionMagic.MotionMagicCruiseVelocity = 0;
    LIFT_CONFIG.MotionMagic.MotionMagicAcceleration = 0;
    LIFT_CONFIG.MotionMagic.MotionMagicExpo_kV = 0.00;
    LIFT_CONFIG.MotionMagic.MotionMagicExpo_kA = 0.00;
    LIFT_CONFIG.CurrentLimits.SupplyCurrentLimitEnable = true;
    LIFT_CONFIG.CurrentLimits.SupplyCurrentLowerLimit = 30;
    LIFT_CONFIG.CurrentLimits.SupplyCurrentLimit = 60;
    LIFT_CONFIG.CurrentLimits.SupplyCurrentLowerTime = 1;

  }
}