import { oven } from "../components/oven.js";
import { motor } from "../components/motor.js";
import { extruder } from "../components/extruder.js";
import { stamper } from "../components/stamper.js";
import { conveyor } from "../components/conveyor.js";
import { biscuitMachineFactory } from "../components/biscuitMachine.js";

const biscuitMachine = biscuitMachineFactory(
    oven(),
    motor(),
    extruder(),
    stamper(),
    conveyor(7),
    240
);

const setValueOfInput = (input, value) => {
    input.value = value;
};

const setup = () => {

    const ovenTempInput = document.getElementById("oven-temperature");
    const biscuitCountInput = document.getElementById("biscuit-count");

    setValueOfInput(ovenTempInput, 0);
    setValueOfInput(biscuitCountInput, 0);

    setInterval(() => {
        const currentSwitchState = document.querySelector('input[name="switch-state"]:checked').value;

        switch (currentSwitchState.toLowerCase()) {
            case "off":
                biscuitMachine.turnOff();
                break;
            case "on":
                biscuitMachine.turnOn();
                break;
            case "paused":
                biscuitMachine.pause();
                break;
        }

        setValueOfInput(ovenTempInput, biscuitMachine.getOvenTemperature());
        setValueOfInput(biscuitCountInput, biscuitMachine.getBiscuitCount());

    }, 500);
}

window.onload = () => setup();