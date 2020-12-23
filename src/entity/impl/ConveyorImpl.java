package entity.impl;

import entity.api.Conveyor;

public class ConveyorImpl implements Conveyor {

    @Override
    public void run() {
        System.out.println("Conveyor running!");
    }

    @Override
    public void stop() {
        System.out.println("Conveyor stopped!");
    }
}
