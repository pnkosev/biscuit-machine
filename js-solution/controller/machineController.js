import { oven } from "../components/oven.js";
import { motor } from "../components/motor.js";
import { extruder } from "../components/extruder.js";
import { stamper } from "../components/stamper.js";
import { conveyor } from "../components/conveyor.js";
import { biscuitMachineFactory } from "../components/biscuitMachine.js";
// import biscuitState from "../components/biscuitState.js";

const biscuitMachine = biscuitMachineFactory(
    oven(),
    motor(),
    extruder(),
    stamper(),
    conveyor(7),
    240
);

const setup = () => {
    const okBtn = document.getElementById("onBtn");
    okBtn.onclick = () => {
        console.log(biscuitMachine.turnOn());
    }
}

window.onload = () => setup();