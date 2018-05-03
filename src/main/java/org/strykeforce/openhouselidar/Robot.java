package org.strykeforce.openhouselidar;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

  private static LidarSubsystem lidarSubsystem;
  private static ServoSubsystem servoSubsystem;
  private Scheduler scheduler;

  public static LidarSubsystem getLidarSubsystem() {
    return lidarSubsystem;
  }

  public static ServoSubsystem getServoSubsystem() {
    return servoSubsystem;
  }

  @Override
  public void robotInit() {
    scheduler = Scheduler.getInstance();
    lidarSubsystem = new LidarSubsystem();
    servoSubsystem = new ServoSubsystem();
  }

  @Override
  public void teleopInit() {
    scheduler.add(new TurnCommand());
  }

  @Override
  public void teleopPeriodic() {
    scheduler.run();
  }
}
