// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An elevator command that uses an elevator subsystem. */
public class ElevatorCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ElevatorSubsystem m_subsystem;
  private final Supplier <Integer> m_dpadValue;

  /**
   * Creates a new ElevatorCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ElevatorCommand(ElevatorSubsystem subsystem, Supplier <Integer> dpadValue ) {
    m_subsystem = subsystem;
    m_dpadValue = dpadValue; 

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double dpad = m_dpadValue.get();
    if(dpad == 0){ //if dpad = 0, dpad up was pressed
      m_subsystem.setPower(0.2);
    } 
      else if(dpad == 180){ //if dpad = 0, dpad down was pressed
      m_subsystem.setPower(-0.2);
    } else{
      m_subsystem.setPower(0);
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
