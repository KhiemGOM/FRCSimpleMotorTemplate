// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SimpleMotorSubsystem extends SubsystemBase {
  WPI_TalonSRX _motor;
  float max_forward_speed, max_backward_speed;
  public SimpleMotorSubsystem(int motorID, float maxSpeed) {
    _motor = new WPI_TalonSRX(motorID);
    max_forward_speed = maxSpeed;
    max_backward_speed = maxSpeed;
  }
  public SimpleMotorSubsystem(int motorID, float maxForwardSpeed, float maxBackwardSpeed)
  {
    _motor = new WPI_TalonSRX(motorID);
    max_forward_speed = maxForwardSpeed;
    max_backward_speed = maxBackwardSpeed;
  }
  public void rotateForward()
  {
    _motor.set(max_forward_speed);
  }
  public void rotateBackward()
  {
    _motor.set(max_backward_speed);
  }
  public void stop()
  {
    _motor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
