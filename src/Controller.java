import entity.api.Switchable;
import entity.impl.*;

import java.util.Scanner;

public class Controller {

    private Scanner scanner;
    private Switchable machine;

    public Controller() {
        this.scanner = new Scanner(System.in);
        this.machine = new BiscuitMachine(
                new MotorImpl(),
                new ExtruderImpl(),
                new StamperImpl(),
                new ConveyorImpl(),
                new OvenImpl()
        );
    }

    public void run() {

        System.out.println("Please select an option:");
        System.out.println("1. Turn on the biscuit machine");
        System.out.println("2. Pause the biscuit machine");
        System.out.println("3. Turn off the biscuit machine");
        System.out.println("0. Exit");

        int input = scanner.nextInt();

        while (true) {
            switch (input) {

                case 1:
                    this.machine.turnOn();
                    break;
                case 2:
                    this.machine.pause();
                    break;
                case 3:
                    this.machine.turnOff();
                    break;
                case 0:
                    System.exit(1);
                default:
                    System.out.println("Please choose one of the options above!");
                    break;
            }

            input = scanner.nextInt();
        }
    }
}
