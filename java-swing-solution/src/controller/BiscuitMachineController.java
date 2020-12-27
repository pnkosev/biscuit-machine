package controller;

import manager.BiscuitMachineManager;
import model.*;
import model.OvenImpl;
import view.BiscuitMachineView;


public class BiscuitMachineController {

    private BiscuitMachineView view;
    private BiscuitMachineManager manager;

    public BiscuitMachineController() {
        this.view = new BiscuitMachineView("Biscuit Machine UI");
        this.manager = new BiscuitMachineManager(
                new Motor(),
                new Extruder(),
                new Stamper(),
                new Conveyor(),
                new OvenImpl()
        );
    }

    public void run() {
        this.view.showGUI();

        while (true) {

            SwitchPosition switchState = this.view.getSwitchPosition();

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

            this.view.updateBiscuitCount(this.manager.getBiscuitCount());
            this.view.updateOvenTemperature(this.manager.getOvenTemperature());

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
