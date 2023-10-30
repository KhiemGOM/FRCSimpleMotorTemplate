// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SimpleMotorSubsystem extends SubsystemBase {
  WPI_TalonSRX _motor;
  double forward_speed, backward_speed;
  public SimpleMotorSubsystem(int motorID, double maxSpeed) {
    _motor = new WPI_TalonSRX(motorID);
    forward_speed = maxSpeed;
    backward_speed = maxSpeed;
  }
  public SimpleMotorSubsystem(int motorID, double forwardSpeed, double backwardSpeed)
  {
    _motor = new WPI_TalonSRX(motorID);
    forward_speed = forwardSpeed;
    backward_speed = backwardSpeed;
  }
  public WPI_TalonSRX getMotor ()
  {
    return _motor;
  }
  public void rotateForward()
  {
    _motor.set(forward_speed);
  }
  public void rotateBackward()
  {
    _motor.set(backward_speed);
  }

  public void stop()
  {
    _motor.set(0);
  }
  private double clamp (double a, double min, double max)
  {
    if (a < min) a = min;
    if (a > max) a = max;
    return a;
  }
  public void set(double speed)
  {
    _motor.set(clamp(speed, -backward_speed, forward_speed));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
