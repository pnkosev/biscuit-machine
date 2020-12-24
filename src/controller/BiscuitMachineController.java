package controller;

import manager.BiscuitMachineManager;
import model.*;
import model.impl.OvenImpl;
import view.BiscuitMachineView;


public class BiscuitMachineController {

    private BiscuitMachineView view;
    private BiscuitMachineManager manager;

    public BiscuitMachineController() {
        this.view = new BiscuitMachineView();
        this.manager = new BiscuitMachineManager(
                new Motor(),
                new Extruder(),
                new Stamper(),
                new Conveyor(),
                new OvenImpl()
        );
    }

    public void run() {
        this.view.show();

        while (true) {

            SwitchPosition switchState = this.view.getSwitchState();

            switch (switchState) {

                case ON:
                    this.manager.turnOn();
                    break;
                case PAUSED:
                    this.manager.pause();
                    break;
                case OFF:
                    this.manager.turnOff();
                    break;
            }

            this.revolution(500);
        }
    }

    private void revolution(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // set interrupt flag
        }
    }
}
