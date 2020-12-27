const ovenFactoryFunc = require("./oven");
const motorFactoryFun = require("./motor");
const stamperFactoryFunc = require("./stamper");
const extruderFactoryFunc = require("./extruder");
const conveyorFactoryFunc = require("./conveyor");
const biscuitState = require("./biscuitState");

const oven = ovenFactoryFunc();

oven.turnOn(240);
oven.turnOn(240);
oven.turnOn(240);
oven.turnOn(240);
oven.turnOff();
console.log(oven.getCurrentTemp());

const extruder = extruderFactoryFunc();
const biscuit = extruder.extrude();
biscuit.setBiscuitState(biscuitState.STAMPED);

console.log(biscuit.getBiscuitState());

const conveyor = conveyorFactoryFunc(7);


for (let i = 0; i < 10; i++) {
    conveyor.add(extruder.extrude());
    const b = conveyor.turnOn();
    if (b != null) {
        console.log(b);
    }
}
