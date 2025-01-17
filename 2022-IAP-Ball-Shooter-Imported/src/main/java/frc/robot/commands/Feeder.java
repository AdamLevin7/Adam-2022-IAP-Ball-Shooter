// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallShooter;

public class Feeder extends CommandBase {
  /** Creates a new Feeder. */
  private BallShooter shooter;
  private Timer timer;
  public Feeder() {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter = new BallShooter();
    timer = new Timer();
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.setFeedOnOff(true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.setFeedOnOff(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get()>1) return true;
    //command ends after a second
    return false;
  }
}
