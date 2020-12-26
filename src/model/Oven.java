package model;

public interface Oven {

    void turnOn(int targetTemperature);

    void turnOff();

    int getCurrentTemperature();

    boolean isDesiredTemperature(int maxDesiredTemp);
}
