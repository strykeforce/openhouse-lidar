package org.strykeforce.openhouselidar;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ServoSubsystem extends Subsystem {

  private static final int ID = 0;
  private final Servo servo = new Servo(ID);

  public void setPosition(double pos) {
    servo.set(pos);
  }

  @Override
  protected void initDefaultCommand() {
  }
}
