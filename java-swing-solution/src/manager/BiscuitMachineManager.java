package manager;

import model.*;
import model.Oven;

import java.util.Optional;

public class BiscuitMachineManager {

    private final static int TARGET_TEMPERATURE = 240;

    private int biscuitCount;

    private int ovenTemperature;

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
        this.oven.turnOn(TARGET_TEMPERATURE);

        if (this.oven.isDesiredTemperature(TARGET_TEMPERATURE)) {
            this.motor.turnOn();

            Biscuit biscuit = this.extruder.extrude();
            this.conveyor.addBiscuit(biscuit);

            if (this.conveyor.hasBiscuitToStamp()) {
                this.stamper.stamp(biscuit);
            }

            Optional<Biscuit> optionalBiscuit = this.conveyor.turn();

            if (optionalBiscuit.isPresent()) {
                this.biscuitCount++;
            }
        }
    }

    public void pause() { this.oven.turnOn(TARGET_TEMPERATURE); }

    public void turnOff() {

        this.oven.turnOff();

        Optional<Biscuit> biscuit = this.conveyor.turnOff();

        if (biscuit.isPresent() && this.oven.isDesiredTemperature(TARGET_TEMPERATURE)) {
            this.biscuitCount++;
        } else {
            this.motor.turnOff();
        }
    }

    public int getBiscuitCount() {
        return this.biscuitCount;
    }

    public int getOvenTemperature() { return this.oven.getCurrentTemperature(); }
}
