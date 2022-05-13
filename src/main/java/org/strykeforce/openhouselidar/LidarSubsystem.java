package org.strykeforce.openhouselidar;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.CANifierStatusFrame;

import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;


public class LidarSubsystem extends Subsystem {

  private static final int CANIFIER_ID = 34;
  private static final int LIDAR_READ_PERIOD_MS = 10;
  private static final int NUM_TAPS = 2;

  private static final double LIDAR_SLOPE = 1.0;
  private static final double LIDAR_OFFSET = 0.0;

  private final CANifier canifier = new CANifier(CANIFIER_ID);
  private final double lidarPwmData[] = new double[2];
  private final double shoulderPwmData[] = new double[2];
  private final LinearFilter lidarFilter;

  private boolean lidarEnabled = false;
  private Timer lidarTimer;

  public LidarSubsystem() {

    lidarFilter =
        LinearFilter.movingAverage(NUM_TAPS);

    enableLidar(true);
  }

  public void enableLidar(boolean enable) {
    lidarEnabled = enable;
    
    if (enable) {
      canifier.setGeneralOutput(CANifier.GeneralPin.LIMF, true, true);
      canifier.setStatusFramePeriod(
          CANifierStatusFrame.Status_5_PwmInputs2, LIDAR_READ_PERIOD_MS, 0);
      lidarTimer = new Timer();
      lidarTimer.start();
    } else {
      canifier.setGeneralOutput(CANifier.GeneralPin.LIMF, false, true);
      if (lidarTimer != null) lidarTimer.stop();
      lidarTimer = null;
      lidarFilter.reset();
    }
  }

  public double lidarGet() {
    canifier.getPWMInput(CANifier.PWMChannel.PWMChannel0, lidarPwmData);
    return LIDAR_SLOPE * lidarPwmData[0] + LIDAR_OFFSET;
  }

  @Override
  protected void initDefaultCommand() {}

  @Override
  public void periodic() {
    System.out.println(lidarGet());

    if (lidarEnabled && lidarTimer.hasPeriodPassed(LIDAR_READ_PERIOD_MS / 1000.0)) {
      // lidarFilter.;
    }
  }

  public double getLidarDistance() {
    return 0.0;
    // return lidarFilter.calculate(input);
  }
}
