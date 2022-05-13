package org.strykeforce.openhouselidar;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {

  public static final LidarSubsystem lidarSubsystem = new LidarSubsystem();
  public static final ServoSubsystem servoSubsystem = new ServoSubsystem();
  private Scheduler scheduler;

  @Override
  public void robotInit() {
    scheduler = Scheduler.getInstance();
  }

  @Override
  public void teleopInit() {
    new TurnCommand(30, 5000).start();
  }

  @Override
  public void teleopPeriodic() {
    scheduler.run();
  }
}
