package model.api;

public interface Oven {

    void turnOn(int targetTemperature);

    void pause(int minimumTemperature);

    void turnOff();

    boolean isReady();

    boolean isDesiredTemperature(int minDesiredTemp, int maxDesiredTemp);
}
