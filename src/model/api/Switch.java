package model.api;

import model.SwitchPosition;

public interface Switch {

    void turnOn();

    void pause();

    void turnOff();

    SwitchPosition getState();
}
