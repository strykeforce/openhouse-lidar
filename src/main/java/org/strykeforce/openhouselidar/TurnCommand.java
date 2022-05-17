package org.strykeforce.openhouselidar;

import edu.wpi.first.wpilibj.command.Command;

public class TurnCommand extends Command {

  private final double min;
  private final double max;
  private final ServoSubsystem servoSubsystem = Robot.servoSubsystem;
  private final LidarSubsystem lidarSubsystem = Robot.lidarSubsystem;
  private double lidarDistance;

  public TurnCommand(double min, double max) {
    this.min = min;
    this.max = max;
    requires(servoSubsystem);
    requires(lidarSubsystem);
  }

  @Override
  protected void initialize() {
    System.out.println("initialize");
  }

  @Override
  protected void execute() {
    lidarDistance = lidarSubsystem.lidarGet();
    //    System.out.println("lidarDistance = " + lidarDistance);
    double servoPosition = ((lidarDistance - min) / (max - min));
    System.out.println("servo = " + servoPosition);
    servoSubsystem.setPosition(servoPosition);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
}
