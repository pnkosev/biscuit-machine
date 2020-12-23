package entity.impl;

import entity.api.*;

public class BiscuitMachine implements Switchable {

    private Motor motor;

    private Extruder extruder;

    private Stamper stamper;

    private Conveyor conveyor;

    private Oven oven;

    public BiscuitMachine(
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

    @Override
    public void turnOn() {
        this.motor.turnOn();
    }

    @Override
    public void pause() {
        this.motor.turnOff();
    }

    @Override
    public void turnOff() {

    }
}
