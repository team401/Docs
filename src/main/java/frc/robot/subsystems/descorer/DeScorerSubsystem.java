package frc.robot.subsystems.descorer;

import com.ctre.phoenix6.hardware.TalonFX;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static edu.wpi.first.units.Units.VoltsPerRadianPerSecond;
import static edu.wpi.first.units.Units.VoltsPerRadianPerSecondSquared;

import coppercore.parameter_tools.LoggedTunableNumber;
import coppercore.wpilib_interface.UnitUtils;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.MutAngle;
import frc.robot.constants.JsonConstants;
import org.littletonrobotics.junction.Logger;

public class DeScorerSubsystem {
    private Angle angle;
    TalonFX motor;
    private enum Angle {
        L2,
        L3
    }
    public DeScorerSubsystem(Angle angle){
        this.angle = angle;
        this.motor = motor;
    }
    public void descoreAt(Angle angle){
        if (angle == Angle.L2){
            //TODO run some motor to some amount equal to the height of L2
            motor.closedLoopRequest(motor.getClosedLoopOutput());
        }
        if (angle == Angle.L3){
            //TODO run given motor to the amount equal to height of L3
        }
    }

    public void stopDescoring(){
        //TODO run the motor backward to the idle state
    }


}
