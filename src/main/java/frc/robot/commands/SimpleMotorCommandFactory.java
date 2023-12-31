// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.SimpleMotorSubsystem;
import static frc.robot.Constants.*;

public class SimpleMotorCommandFactory {
  SimpleMotorSubsystem _subsys;
  Command rotate_fwd, rotate_bwd;
  public SimpleMotorCommandFactory(SimpleMotorSubsystem subsystem ) {
    _subsys = subsystem;
    rotate_fwd = new StartEndCommand(_subsys::rotateForward, _subsys::stop, _subsys);
    rotate_bwd = new StartEndCommand(_subsys::rotateBackward, _subsys::stop, _subsys);
  }
  public Command rotateForwardCommand()
  {
    return rotate_fwd;
  }

  public Command rotateBackwardCommand()
  {
    return rotate_bwd;
  }

  public void bindButton (JoystickButton forwardButton, JoystickButton backwardButton)
  {
    forwardButton.whileTrue(rotateForwardCommand());
    backwardButton.whileTrue(rotateBackwardCommand());
  }
  private boolean isNoise(double a)
  {
    return Math.abs(a) < SENSITIVITY;
  }
  public Command bindAxis (Joystick joystick, int ID)
  {
    return new RunCommand(() -> {
      double axis = joystick.getRawAxis(ID);
      if (isNoise(axis))
        axis = 0;
      _subsys.set(axis);
    }, _subsys);
  } 
}
