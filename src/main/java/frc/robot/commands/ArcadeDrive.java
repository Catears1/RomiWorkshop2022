// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;
import fr.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcadeDrive extends CommandBase {
  // We put all the subsystems we are going to use here
  private final Drivetrain drivetrain;

  // We put all the fields we need for this command here
  private final Supplier<Double> forwardSpeed;
  private final Supplier<Double> turnSpeed;

  /** Creates a new ArcadeDrive. */
  public ArcadeDrive(Supplier<Double> forwardSpeed, Supplier<Double> turnSpeed) {
    this.drivetrain = Drivetrain.getInstance();

    // We store our speed suppliers here
    this.forwardSpeed = forwardSpeed;
    this.turnSpeed = turnSpeed;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }
awwa;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(forwardSpeed.get(), turnSpeed.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
