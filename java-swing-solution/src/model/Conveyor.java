package model;

import java.util.*;

public class Conveyor {

    private final static int BELT_LENGTH = 7;

    private Queue<Biscuit> slots;

    public Conveyor() {
        this.slots = new ArrayDeque<>();
    }

    public Optional<Biscuit> turn() {

        Optional<Biscuit> biscuit = Optional.empty();
        if (this.slots.size() == BELT_LENGTH) {
            biscuit = Optional.ofNullable(this.slots.remove());
        }

        return biscuit;
    }

    public Optional<Biscuit> turnOff() {

        Optional<Biscuit> biscuit = Optional.empty();

        if (!this.slots.isEmpty()) {
            if (this.slots.peek().getBiscuitState() != BiscuitState.RAW) {
                biscuit = Optional.ofNullable(this.slots.remove());
            }
        }

        return biscuit;
    }

    public void addBiscuit(Biscuit biscuit) {
        this.slots.add(biscuit);
    }

    public boolean hasBiscuitToStamp() {
        return this.slots.size() > 1;
    }
}
