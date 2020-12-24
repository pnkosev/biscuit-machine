package entity.impl;

import entity.api.Switch;


public class SwitchImpl implements Switch {

    private String state;


    @Override
    public void turnOn() {
        this.state = "on";
    }

    @Override
    public void pause() {
        this.state = "paused";
    }

    @Override
    public void turnOff() {
        this.state = "off";
    }

    @Override
    public String getState() {
        return this.state;
    }
}
