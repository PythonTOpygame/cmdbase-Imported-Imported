// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Chasis extends SubsystemBase {
  private final WPI_VictorSPX m_leftMotor = new WPI_VictorSPX(Constants.m_chasis_left);
  private final WPI_VictorSPX m_rightMotor = new WPI_VictorSPX(Constants.m_chasis_right);
  private final WPI_VictorSPX s_leftMotor = new WPI_VictorSPX(Constants.s_chasis_left);
  private final WPI_VictorSPX s_rightMotor = new WPI_VictorSPX(Constants.s_chasis_right);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  // 設置Chasis初始化
  public Chasis() {
    // 1023 * PerOutput = unit / 0.1s * kF
    m_leftMotor.configFactoryDefault();
    m_rightMotor.configFactoryDefault();
    s_leftMotor.configFactoryDefault();
    s_rightMotor.configFactoryDefault();
    m_leftMotor.setInverted(true);
    m_rightMotor.setInverted(false);
    s_leftMotor.setInverted(true);
    s_rightMotor.setInverted(false);
    s_leftMotor.follow(m_leftMotor);
    s_rightMotor.follow(m_rightMotor);
    m_leftMotor.setSafetyEnabled(false);
    m_rightMotor.setSafetyEnabled(false);
    s_leftMotor.setSafetyEnabled(false);
    s_rightMotor.setSafetyEnabled(false);


  }

  public void move(double a, double b){

      m_robotDrive.arcadeDrive(a*0.5, b*0.6);
    }
  
  // public void speed_up(boolean isspeedup){
  //   if (isspeedup){
  //     m_leftMotor.set(ControlMode.PercentOutput, -0.6);
  //     m_rightMotor.set(ControlMode.PercentOutput, -0.6);
  //   }  
  // }
  
  // public void speed_down(boolean isspeedup){
  //   if (isspeedup){
  //     m_leftMotor.set(ControlMode.PercentOutput, 0.6);
  //     m_rightMotor.set(ControlMode.PercentOutput, 0.6);
  //   }  
  // } 
  public void lime_left(){
    m_leftMotor.set(ControlMode.PercentOutput, -0.4);
    m_rightMotor.set(ControlMode.PercentOutput, -0.2);
  }

  public void lime_right(){
    m_leftMotor.set(ControlMode.PercentOutput, -0.2);
    m_rightMotor.set(ControlMode.PercentOutput, -0.4);
  }

  public void lime_move(){
    m_leftMotor.set(ControlMode.PercentOutput, -0.2);
    m_rightMotor.set(ControlMode.PercentOutput, -0.2);
  }

  public void lime_stop(){
    m_leftMotor.set(ControlMode.PercentOutput, 0);
    m_rightMotor.set(ControlMode.PercentOutput, 0);
  }

  public void lime_back(){
    m_leftMotor.set(ControlMode.PercentOutput, 0.2);
    m_rightMotor.set(ControlMode.PercentOutput, 0.2);
  }
}
