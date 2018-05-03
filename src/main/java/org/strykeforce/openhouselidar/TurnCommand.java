package org.strykeforce.openhouselidar;

import edu.wpi.first.wpilibj.command.Command;

public class TurnCommand extends Command {

  private final static double max = 0.5;
  private final static double min = -0.5;
  private ServoSubsystem servoSubsystem;
  private LidarSubsystem lidarSubsystem;
  private double lidarDistance;

  public TurnCommand() {
    servoSubsystem = Robot.getServoSubsystem();
    lidarSubsystem = Robot.getLidarSubsystem();
    requires(servoSubsystem);
    requires(lidarSubsystem);
  }

  @Override
  protected void execute() {
    lidarDistance = lidarSubsystem.getLidarDistance();
    turn(lidarDistance);

  }

  public void turn(double lidarDistance) {
    servoSubsystem.setPosition((max - min) * (lidarDistance - min) / (max - min) - min);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
}
