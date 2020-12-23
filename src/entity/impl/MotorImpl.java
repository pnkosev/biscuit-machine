package entity.impl;

import entity.api.Motor;

public class MotorImpl implements Motor {

    public boolean isRunning;

    @Override
    public void turnOn() {

        if (this.isRunning) {
            System.out.println("Motor is already on!");
            return;
        }

        this.isRunning = true;

        System.out.println("Motor is on!");
    }

    @Override
    public void turnOff() {

        if (!this.isRunning) {
            System.out.println("Motor is already off!");
            return;
        }

        this.isRunning = false;

        System.out.println("Motor is off!");
    }
}
