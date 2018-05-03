package org.strykeforce.openhouselidar;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ServoSubsystem extends Subsystem {

  private static final int ID = 2;
  private Servo servo;

  public ServoSubsystem() {
    servo = new Servo(ID);
  }

  public void setPosition(double pos) {
    servo.set(pos);
  }

  public double readPosition() {
    return servo.get();
  }

  @Override
  protected void initDefaultCommand() {
  }
}
