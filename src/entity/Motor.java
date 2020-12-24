package entity;

public class Motor {

    private boolean isRunning;

    public void turnOn() {

        if (!isRunning) {
            isRunning = true;
        }

        System.out.println("Motor is on!");
    }

    public void turnOff() {

        if (isRunning) {
            isRunning = false;
        }

        System.out.println("Motor is off!");
    }

    public boolean isRunning() {
        return this.isRunning;
    }
}
