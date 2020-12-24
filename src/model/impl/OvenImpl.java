package model.impl;

import model.api.Oven;

public class OvenImpl implements Oven {

    private final static int STEP = 10;

    private boolean isReady;
    private int currentTemperature;


    @Override
    public void turnOn(int targetTemperature) {
        if (this.currentTemperature < targetTemperature) {
            this.currentTemperature += STEP;
        }

        if (this.currentTemperature == targetTemperature) {
            this.isReady = true;
        }

        System.out.println(this.currentTemperature);
    }

    @Override
    public void turnOff() {
        if (this.currentTemperature > 0) {
            this.currentTemperature -= STEP;
        }

        System.out.println(this.currentTemperature);
    }

    public void pause(int minimumTemperature) {
        if (this.currentTemperature > minimumTemperature) {
            this.currentTemperature -= STEP;
        }

        if (this.currentTemperature == minimumTemperature) {
            this.isReady = false;
        }

        System.out.println(this.currentTemperature);
    }

    @Override
    public boolean isReady() { return this.isReady; }

    @Override
    public boolean isDesiredTemperature(int min, int max) {
        return this.currentTemperature >= min && this.currentTemperature <= max;
    }
}
