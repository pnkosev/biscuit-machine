package entity.impl;

import entity.api.Oven;

import java.util.Timer;

public class OvenImpl implements Oven {

    private int currentTemperature;

    @Override
    public void turnOn(int targetTemperature) throws InterruptedException {

        while (this.currentTemperature < targetTemperature) {
            this.currentTemperature += 10;

            System.out.printf("Oven is heating. Currently at %d degrees!%n", this.currentTemperature);

            Thread.sleep(500L);
        }
    }

    @Override
    public void turnOff() {
        this.currentTemperature = 0;
    }

    public void pause(int minimumTemperature) throws InterruptedException {

        while (this.currentTemperature > minimumTemperature) {
            this.currentTemperature -= 10;

            System.out.printf("Oven is paused. Currently at %d degrees!%n", this.currentTemperature);

            Thread.sleep(500L);
        }
    }
}
