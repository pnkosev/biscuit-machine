package model;

public class Extruder {

    public Biscuit extrude() {
        System.out.println("Cookie extruded!");
        return new Biscuit(BiscuitType.CHOCOLATE_CHIP);
    }
}
