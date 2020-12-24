package manager;

import model.*;
import model.api.Oven;

import java.util.Optional;

public class BiscuitMachineManager {

    private final static int MAXIMUM_HEAT = 240;
    private final static int MINIMUM_HEAT = 220;

    private int biscuitsCooked;

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
        this.keepOvenHeated();

        if (this.oven.isDesiredTemperature(MINIMUM_HEAT, MAXIMUM_HEAT)) {
            this.motor.turnOn();

            Biscuit biscuit = this.extruder.extrude();
            this.conveyor.addBiscuit(biscuit);

            if (this.conveyor.hasBiscuitToStamp()) {
                this.stamper.stamp(biscuit);
            }

            Optional<Biscuit> optionalBiscuit = this.conveyor.turn();

            if (optionalBiscuit.isPresent()) {
                this.biscuitsCooked++;
            }

//            System.out.println(this.biscuitsCooked);
        }
    }

    public void pause() {

        this.keepOvenHeated();
    }

    public void turnOff() {

        this.oven.turnOff();

        Optional<Biscuit> biscuit = this.conveyor.turnOff();

        if (biscuit.isPresent()) {
            this.biscuitsCooked++;
        } else {
            this.motor.turnOff();
        }

//        System.out.println(this.biscuitsCooked);
    }

    private void keepOvenHeated() {
        boolean isReady = this.oven.isReady();

        if (!isReady) {
            this.oven.turnOn(MAXIMUM_HEAT);
        } else {
            this.oven.pause(MINIMUM_HEAT);
        }
    }
}
