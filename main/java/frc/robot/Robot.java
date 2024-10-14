// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot;

// import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
// import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix6.controls.Follower;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  //private final PWMSparkMax m_leftDrive1 = new PWMSparkMax(0);
  //private final PWMSparkMax m_leftDrive2 = new PWMSparkMax(1);
  private final XboxController m_controller = new XboxController(0);
  private final Timer m_timer = new Timer();
  TalonSRX _talon0 = new TalonSRX(1);
  TalonSRX _talon1 = new TalonSRX(2);
  TalonSRX _talon2 = new TalonSRX(3);
  TalonSRX _talon3 = new TalonSRX(4);
  // private final DifferentialDrive m_robotDrive =
  //     new DifferentialDrive(_talon0, _talon1);


  public Robot() {
  //   SendableRegistry.addChild(m_robotDrive, m_leftDrive1);
  //   SendableRegistry.addChild(m_robotDrive, m_leftDrive2);
 }



  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //m_leftDrive1.addFollower(m_leftDrive2);
    _talon1.follow(_talon0);
    _talon3.follow(_talon2);
    //m_leftDrive1.setInverted(true);
  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    m_timer.restart();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    // if (m_timer.get() < 2.0) {
    //   // Drive forwards half speed, make sure to turn input squaring off
    //   m_robotDrive.arcadeDrive(0.5, 0.0, false);
    // } else {
    //   m_robotDrive.stopMotor(); // stop robot
    // }
  }

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    // Very basic arcade drive
    _talon0.set(ControlMode.PercentOutput, (m_controller.getLeftY() + m_controller.getRightX()));
    _talon1.set(ControlMode.PercentOutput, (m_controller.getLeftY() + m_controller.getRightX()));
    _talon2.set(ControlMode.PercentOutput, (-m_controller.getLeftY() + m_controller.getRightX()));
    _talon3.set(ControlMode.PercentOutput, (-m_controller.getLeftY() + m_controller.getRightX()));
    //m_leftDrive1.set(m_controller.getRightY());
    //m_leftDrive2.set(-m_controller.getRightY());
    //m_robotDrive.arcadeDrive(-m_controller.getLeftY(), -m_controller.getRightX());
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}