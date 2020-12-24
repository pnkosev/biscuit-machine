package manager;

import model.*;
import model.api.Oven;

public class BiscuitMachineManager {

    private final static int MAXIMUM_HEAT = 240;
    private final static int MINIMUM_HEAT = 220;

    private long biscuitsCooked;

    private Motor motor;

    private Extruder extruder;

    private Stamper stamper;

    private Conveyor conveyor;

    private Oven oven;

    public BiscuitMachineManager(
            Motor motor,
            Extruder extruder,
            Stamper stamper,
            Conveyor conveyor,
            Oven oven
    ) {
        this.motor = motor;
        this.extruder = extruder;
        this.stamper = stamper;
        this.conveyor = conveyor;
        this.oven = oven;
    }

    public void turnOn() {

        boolean isReady = this.oven.isReady();

        if (!isReady) {
            this.oven.turnOn(MAXIMUM_HEAT);
        } else {
            this.oven.pause(MINIMUM_HEAT);
        }
    }

    public void pause() {
        System.out.println("paused!");
    }

    public void turnOff() {

        this.oven.turnOff();
    }
}
