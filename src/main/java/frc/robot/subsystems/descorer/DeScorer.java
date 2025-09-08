package frc.robot.subsystems.descorer;

import edu.wpi.first.math.system.plant.DCMotor;

public class DeScorer {
    enum Height {
        L2,
        L3
    }
    Height height;
    Tal motor;
    public DeScorer(Height height){
        this.height = height;
    }
    public void descoreAt(Height height){
        if (height == Height.L2){
            //TODO run some motor to some amount equal to the height of L2
            motor.getClosedLoopOutput();
            motor.closedLoopRequest();
        }
        if (height == L3){
            //TODO run given motor to the amount equal to height of L3
        }
    }

    public void stopDescoring(){
        //TODO run the motor backward to the idle state
    }


}
