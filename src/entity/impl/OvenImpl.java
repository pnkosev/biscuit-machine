package entity.impl;

import entity.api.Oven;

import java.util.Timer;
import java.util.TimerTask;

public class OvenImpl implements Oven {

    private int temperature;
    private Timer timer;

    public OvenImpl() {
        this.timer = new Timer();
    }

    @Override
    public void turnOn(int targetTemperature) {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.printf("Oven is heating. Currently at %d degrees!%n", temperature);

                if (temperature == targetTemperature) {
                    timer.cancel();
                    return;
                }

                temperature += 60;
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);

        this.pause(targetTemperature - 20);
    }

    @Override
    public void turnOff() {
        this.temperature = 0;
    }

    private void pause(int minimumTemperature) {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.printf("Oven is paused. Currently at %d degrees!%n", temperature);

                if (temperature == minimumTemperature) {
                    timer.cancel();
                    return;
                }

                temperature -= 1;
            }
        };

        while (this.temperature >= minimumTemperature) {
            this.timer.scheduleAtFixedRate(task, 0, 1000);
        }

        this.turnOn(minimumTemperature + 20);
    }
}
