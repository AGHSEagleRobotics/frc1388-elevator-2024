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
  private final ElevatorSubsystem m_elevatorSubsystem;
  private final Supplier <Integer> m_dpadValue;

  /**
   * Creates a new ElevatorCommand.
   *
   * @param elevatorSubsystem The subsystem used by this command.
   */
  public ElevatorCommand(ElevatorSubsystem elevatorSubsystem, Supplier <Integer> dpadValue ) {
    m_elevatorSubsystem = elevatorSubsystem;
    m_dpadValue = dpadValue; 

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_elevatorSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double dpad = m_dpadValue.get();
    if(dpad == 0){ //if dpad = 0, dpad up was pressed
      m_elevatorSubsystem.setPower(0.2);
    } 
      else if(dpad == 180){ //if dpad = 180, dpad down was pressed
      m_elevatorSubsystem.setPower(-0.2);
    } else{
      m_elevatorSubsystem.setPower(0);
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_elevatorSubsystem.setPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
