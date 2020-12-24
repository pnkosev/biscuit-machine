package model.impl;

import model.SwitchPosition;
import model.api.Switch;


public class SwitchImpl implements Switch {

    private SwitchPosition state;

    public SwitchImpl() {
        this.state = SwitchPosition.OFF;
    }

    @Override
    public void turnOn() {
        this.state = SwitchPosition.ON;
    }

    @Override
    public void pause() {
        this.state = SwitchPosition.PAUSED;
    }

    @Override
    public void turnOff() {
        this.state = SwitchPosition.OFF;
    }

    @Override
    public SwitchPosition getState() {
        return this.state;
    }
}
