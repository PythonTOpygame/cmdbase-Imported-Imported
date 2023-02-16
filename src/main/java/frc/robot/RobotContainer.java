// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.Chasis;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.subsystems.Conemotor;
// import frc.robot.subsystems.Cubemotor;
// import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
// import edu.wpi.first.wpilibj2.command.InstantCommand;
// import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// import frc.robot.subsystems.Arm;
// import frc.robot.subsystems.Bigbang;
import frc.robot.subsystems.Intake;
// import frc.robot.subsystems.Limelight_new;
import frc.robot.subsystems.Limelight_new;

// import frc.robot.subsystems.Solenoids;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final Chasis chasis = new Chasis();
  // private final Intake intake = new Intake();
  private final CommandXboxController xboxController = new CommandXboxController(0);
  // private final Arm arm = new Arm();
  private final Intake intake = new Intake();
  // private static Bigbang bigbang;
  // private final Solenoids solenoid = new Solenoids();
  private final Limelight_new limelight = new Limelight_new();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    // new JoystickButton(joystick, 1)   .whenPressed(new RunCommand(() -> chasis.move(joystick.getY(), joystick.getZ())))
    // .whenReleased(new RunCommand(() -> chasis.stop()));
    double x = 1;
    double y = 1;

    chasis.setDefaultCommand(                                  
     Commands.run(() -> {chasis.move(xboxController.getLeftY()*y, xboxController.getRightX()*x);},
     chasis)
   );

    // limelight.setDefaultCommand(
    //   Commands.run() -> {limelight.});


    // solenoid.setDefaultCommand(
    //   new RunCommand(() -> {solenoid.comstart();},
    //   solenoid)
    // );
    
      xboxController.start().whileTrue(new RunCommand(() -> limelight.rotation()));
      
    
      // xboxController.leftBumper().whileTrue(new RunCommand(() -> arm.suck()))
    //                             .whileFalse(new RunCommand(() -> arm.stop()));

    // xboxController.rightBumper().whileTrue(new RunCommand(() -> arm.shoot()))
    //                             .whileFalse(new RunCommand(() -> arm.stop()));

    // xboxController.y().whileTrue(new RunCommand(() -> arm.shoot()))
    //                   .whileFalse(new RunCommand(() -> intake.stop()));
    
    // xboxController.a().whileTrue(new RunCommand(() -> arm.suck()))
    //                   .whileFalse(new RunCommand(() -> intake.stop()));

    // xboxController.leftTrigger().whileTrue(new RunCommand(() -> intake.go()))
    //                             .whileFalse(new RunCommand(() -> intake.stop()));

    // xboxController.rightTrigger().whileTrue(new RunCommand(() -> intake.back()))
    //                             .whileFalse(new RunCommand(() -> intake.stop()));
    // xboxController.start().whileTrue(new RunCommand(() -> chasis.speed_up(true)))
    //                             .whileFalse(new RunCommand(() -> chasis.speed_up(false)));
    // xboxController.back().whileTrue(new RunCommand(() -> chasis.speed_down(true)))
    //                             .whileFalse(new RunCommand(() -> chasis.speed_down(false)));
                                
    // xboxController.start().whileTrue(new RunCommand(() -> bigbang.bongjitheajinduaxia()));
    // xboxController.leftBumper().whileTrue(new RunCommand(() -> solenoid.airin()));

    // xboxController.rightBumper().whileFalse(new RunCommand(() -> solenoid.airout()));
  }
                                           

  public Command getAutonomousCommand() {

    // An ExampleCommand will run in autonomous
    return null;
    }
  }


