// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  WPI_VictorSPX m_rightmotor = new WPI_VictorSPX(Constants.intake);
  /** Creates a new ExampleSubsystem. */
  public Intake() {
    m_rightmotor.configFactoryDefault();
  }

  public void go(){
    m_rightmotor.set(ControlMode.PercentOutput, 0.3);
  }

  public void back(){
    m_rightmotor.set(ControlMode.PercentOutput, -0.3);
  }

  public void stop(){
    m_rightmotor.set(ControlMode.PercentOutput, 0);
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
