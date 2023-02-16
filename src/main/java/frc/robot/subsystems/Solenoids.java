// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Solenoids extends SubsystemBase {
    public final DoubleSolenoid intakedoubleSolenoid =new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    protected static Compressor intakecompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

  /** Creates a new ExampleSubsystem. */
  public Solenoids() {
    intakecompressor.enableDigital();
  }

  public void airin(){
    intakedoubleSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void airout(){
    intakedoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void cumstart(){
    intakecompressor.enableAnalog(20, 110);
  }
  public void comstop(){
    intakecompressor.disable();
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
