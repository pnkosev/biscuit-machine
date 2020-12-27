package model;

public class OvenImpl implements Oven {

    private final static int STEP = 10;
    private final static int LOWER_TEMP_MARGIN = 20;

    private int currentTemperature;
    private boolean isReady;

    @Override
    public void turnOn(int targetTemperature) {
        this.checkTemperature(targetTemperature);

        if (!isReady) {
            this.currentTemperature += STEP;
        } else {
            this.currentTemperature -= STEP;
        }
    }

    @Override
    public void turnOff() {
        if (this.currentTemperature > 0) {
            this.currentTemperature -= STEP;
        }
    }

    @Override
    public int getCurrentTemperature() {
        return this.currentTemperature;
    }

    @Override
    public boolean isDesiredTemperature(int max) {
        return this.currentTemperature >= max - LOWER_TEMP_MARGIN && this.currentTemperature <= max;
    }

    private void checkTemperature(int targetTemperature) {
        if (this.currentTemperature >= targetTemperature) {
            this.isReady = true;
        } else if (this.currentTemperature <= targetTemperature - LOWER_TEMP_MARGIN) {
            this.isReady = false;
        }
    }
}
