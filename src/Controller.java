import entity.*;
import entity.impl.OvenImpl;
import entity.impl.SwitchImpl;

import java.util.Scanner;

public class Controller {

    private BiscuitMachine biscuitMachine;

    public Controller() {
        this.biscuitMachine = new BiscuitMachine(
                new SwitchImpl(),
                new Motor(),
                new Extruder(),
                new Stamper(),
                new Conveyor(),
                new OvenImpl()
        );
    }

    public void run() {

        System.out.println("Please select an option at any given time:");
        System.out.println("1. Turn on the biscuit machine");
        System.out.println("2. Pause the biscuit machine");
        System.out.println("3. Turn off the biscuit machine");
        System.out.println("0. Exit");

        try (Scanner scanner = new Scanner(System.in)) {


            while (scanner.hasNext()) {
                String input = scanner.next();

                this.biscuitMachine.update(input);

//                switch (input) {
//
//                    case "1":
//                        this.aSwitch.turnOn();
//                        break;
//                    case "2":
//                        this.aSwitch.pause();
//                        break;
//                    case "3":
//                        this.aSwitch.turnOff();
//                        break;
//                    case "0":
//                        System.exit(1);
//                    default:
//                        System.out.println("Please choose one of the options above!");
//                        break;
//                }
            }

        }

    }
}
