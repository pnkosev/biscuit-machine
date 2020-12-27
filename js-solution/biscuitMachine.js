const ovenFuncFactory = require('./oven');

const oven = ovenFuncFactory();

oven.turnOn(240);
oven.turnOn(240);
oven.turnOn(240);
oven.turnOn(240);
oven.turnOff();
console.log(oven.getCurrentTemp());