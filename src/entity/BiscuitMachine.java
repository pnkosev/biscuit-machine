package entity;

import entity.api.Oven;
import entity.api.Switch;

public class BiscuitMachine {

    private long biscuitsCooked;

    private Switch aSwitch;

    private Motor motor;

    private Extruder extruder;

    private Stamper stamper;

    private Conveyor conveyor;

    private Oven oven;

    public BiscuitMachine(
            Switch aSwitch,
            Motor motor,
            Extruder extruder,
            Stamper stamper,
            Conveyor conveyor,
            Oven oven
    ) {
        this.aSwitch = aSwitch;
        this.motor = motor;
        this.extruder = extruder;
        this.stamper = stamper;
        this.conveyor = conveyor;
        this.oven = oven;
    }

    public void turnOn() {

        try {
            this.oven.turnOn(240);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // set interrupt flag
            System.out.println("Failed to heat oven");
        }

        this.motor.turnOn();

        while (this.aSwitch.getState().equals("on")) {
            Biscuit biscuit = this.extruder.extrude();
            this.stamper.stamp(biscuit);
            biscuit.setBiscuitState(BiscuitState.COOKED);

            System.out.println(++this.biscuitsCooked);
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // set interrupt flag
                System.out.println("Failed to heat oven");
            }
        }


    }

    public void turnOff() {

        this.oven.turnOff();

        this.motor.turnOff();
    }

    public void update(String input) {

    }
}
