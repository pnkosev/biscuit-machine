package entity.api;

public interface Oven {

    void turnOn(int targetTemperature) throws InterruptedException;

    void pause(int minimumTemperature) throws InterruptedException;

    void turnOff();
}
