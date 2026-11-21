// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.StaticFeedforwardSignValue;

import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Distance;

/** Add your docs here. */
public class ConstPositional {
  public static final double STOP = 0;

  public static final Distance PREP_SWITCH = Units.Inches.of(0); // TODO:GET ACTUAL VALUE
  public static final double FORK_OUT = 0.2;
  public static final Distance CLIMB = Units.Inches.of(0);
  public static final Distance PREP_CLIMB = Units.Inches.of(28.5); // TODO:GET ACTUAL VALUE
  public static final Distance PREP_EXCHANGE_HEIGHT = Units.Inches.of(0);
  public static final Distance PREP_TIPPED_UP_2_LAYERS_HEIGHT = Units.Inches.of(15);
  public static final Distance PREP_TIPPED_UP_SCALE_HEIGHT = Units.Inches.of(12);
  public static final Distance PREP_TIPPED_DOWN_SCALE_HEIGHT = Units.Inches.of(5);
  public static final Distance PREP_LEVELED_2_LAYERS_HEIGHT = Units.Inches.of(5);
  public static final Distance PREP_TIPPED_DOWN_2_LAYERS_HEIGHT = Units.Inches.of(5);
  public static final Distance PREP_SCALE_HEIGHT = Units.Inches.of(5);

  public static final Distance ZERO = Units.Inches.of(0);
  public static final Distance PREP_INTAKE_LV1_HEIGHT = Units.Inches.of(0); // TODO:GET ACTUAL VALUE
  public static final Distance PREP_INTAKE_LV2_HEIGHT = Units.Inches.of(15); // TODO:GET ACTUAL VALUE
  public static final Distance PREP_INTAKE_LV3_HEIGHT = Units.Inches.of(20); // TODO:GET ACTUAL VALUE
  public static final Distance PREP_INTAKE_PORTAL = Units.Inches.of(5); // TODO:GET ACTUAL VALUE

  public static TalonFXConfiguration WEST_LIFT_CONFIG = new TalonFXConfiguration();
  public static TalonFXConfiguration EAST_LIFT_CONFIG = new TalonFXConfiguration();
  public static TalonFXConfiguration FORK_CONFIG = new TalonFXConfiguration();

  static {
    // Configure TalonFXConfiguration objects here
    FORK_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    FORK_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;

    WEST_LIFT_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    WEST_LIFT_CONFIG.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    WEST_LIFT_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    WEST_LIFT_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Inches.of(29.5).in(Units.Inches);
    WEST_LIFT_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    WEST_LIFT_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Inches.of(0).in(Units.Inches);
    WEST_LIFT_CONFIG.Slot0.GravityType = GravityTypeValue.Elevator_Static;
    WEST_LIFT_CONFIG.Slot0.kP = 1.75;
    WEST_LIFT_CONFIG.Slot0.kI = 0;
    WEST_LIFT_CONFIG.Slot0.kD = 0;
    WEST_LIFT_CONFIG.Slot0.kS = 0.37;
    WEST_LIFT_CONFIG.Slot0.kG = 0.1;
    WEST_LIFT_CONFIG.Slot0.StaticFeedforwardSign = StaticFeedforwardSignValue.UseClosedLoopSign;

    WEST_LIFT_CONFIG.Feedback.SensorToMechanismRatio = 1.0 / ((12.0 / 48.0) * (24.0 / 60.0) * (1.751 * Math.PI));

    WEST_LIFT_CONFIG.MotionMagic.MotionMagicCruiseVelocity = 0;
    WEST_LIFT_CONFIG.MotionMagic.MotionMagicAcceleration = 0;
    WEST_LIFT_CONFIG.MotionMagic.MotionMagicExpo_kV = 0.2;
    WEST_LIFT_CONFIG.MotionMagic.MotionMagicExpo_kA = 0.00;
    WEST_LIFT_CONFIG.CurrentLimits.SupplyCurrentLimitEnable = true;
    WEST_LIFT_CONFIG.CurrentLimits.SupplyCurrentLowerLimit = 30;
    WEST_LIFT_CONFIG.CurrentLimits.SupplyCurrentLimit = 60;
    WEST_LIFT_CONFIG.CurrentLimits.SupplyCurrentLowerTime = 1;

    EAST_LIFT_CONFIG.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    EAST_LIFT_CONFIG.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    EAST_LIFT_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
    EAST_LIFT_CONFIG.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Inches.of(29.5).in(Units.Inches);
    EAST_LIFT_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
    EAST_LIFT_CONFIG.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Inches.of(0).in(Units.Inches);
    EAST_LIFT_CONFIG.Slot0.GravityType = GravityTypeValue.Elevator_Static;
    EAST_LIFT_CONFIG.Slot0.kP = 1.75;
    EAST_LIFT_CONFIG.Slot0.kI = 0;
    EAST_LIFT_CONFIG.Slot0.kD = 0;
    EAST_LIFT_CONFIG.Slot0.kS = 0.37;
    EAST_LIFT_CONFIG.Slot0.kG = 0.1;
    EAST_LIFT_CONFIG.Slot0.StaticFeedforwardSign = StaticFeedforwardSignValue.UseClosedLoopSign;

    EAST_LIFT_CONFIG.Feedback.SensorToMechanismRatio = 1.0 / ((12.0 / 48.0) * (24.0 / 60.0) * (1.751 * Math.PI));

    EAST_LIFT_CONFIG.MotionMagic.MotionMagicCruiseVelocity = 0;
    EAST_LIFT_CONFIG.MotionMagic.MotionMagicAcceleration = 0;
    EAST_LIFT_CONFIG.MotionMagic.MotionMagicExpo_kV = 0.2;
    EAST_LIFT_CONFIG.MotionMagic.MotionMagicExpo_kA = 0.00;
    EAST_LIFT_CONFIG.CurrentLimits.SupplyCurrentLimitEnable = true;
    EAST_LIFT_CONFIG.CurrentLimits.SupplyCurrentLowerLimit = 30;
    EAST_LIFT_CONFIG.CurrentLimits.SupplyCurrentLimit = 60;
    EAST_LIFT_CONFIG.CurrentLimits.SupplyCurrentLowerTime = 1;

  }
}