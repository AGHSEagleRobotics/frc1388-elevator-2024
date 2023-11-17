// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
  private final CANSparkMax m_elevatorMotor1;
  private final CANSparkMax m_elevatorMotor2;
  private final DigitalInput m_topLimitSwitch;
  private final DigitalInput m_bottomLimitSwitch;

  /** Creates a new ExampleSubsystem. */
  public ElevatorSubsystem(CANSparkMax elevatorMotor1, CANSparkMax elevatorMotor2, DigitalInput topLimitSwitch, DigitalInput bottomLimitSwitch) {
    m_bottomLimitSwitch = bottomLimitSwitch;
    m_topLimitSwitch = topLimitSwitch;
    m_elevatorMotor1 = elevatorMotor1;
    m_elevatorMotor2 = elevatorMotor2;
    m_elevatorMotor1.restoreFactoryDefaults();
    m_elevatorMotor2.restoreFactoryDefaults();
    //m_elevatorMotor2.follow(m_elevatorMotor1);
    m_elevatorMotor1.setIdleMode(IdleMode.kBrake);
    m_elevatorMotor2.setIdleMode(IdleMode.kBrake);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */


  public double setPower(double power) {
    if(power > 0){
      if(m_topLimitSwitch.get()){
        m_elevatorMotor1.set(0);
        m_elevatorMotor2.set(0);
      } else {
        m_elevatorMotor1.set(power);
        m_elevatorMotor2.set(power);
      }
    } else {
      if(m_bottomLimitSwitch.get()){
        m_elevatorMotor1.set(0);
        m_elevatorMotor2.set(0);
      } else {
        m_elevatorMotor1.set(power);
        m_elevatorMotor2.set(power);
      }
    }
   // m_elevatorMotor1.set(power);
    //m_elevatorMotor2.set(power);
    return power;
    
    //power is 1 to -1, in terms of speed

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
