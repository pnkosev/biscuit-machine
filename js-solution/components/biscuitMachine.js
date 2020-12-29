const biscuitMachineFactory = (oven, motor, extruder, stamper, conveyor, targetTemperature) => {

    const machinery = {
        oven,
        motor,
        extruder,
        stamper,
        conveyor
    };

    let state = {
        targetTemperature,
        bisctuitCount: 0,
    };

    machinery.oven.setTargetTemperature(state.targetTemperature);

    return {
        turnOn: () => {
            machinery.oven.turnOn();

            if (machinery.oven.isDesiredTemp()) {

                machinery.motor.turnOn();

                let biscuit = machinery.extruder.extrude();

                machinery.conveyor.add(biscuit);

                if (machinery.conveyor.getSlotOccupancy() > 1) {
                    machinery.stamper.stamp(biscuit);
                }

                const optionalBiscuit = machinery.conveyor.turnOn();

                if (optionalBiscuit != null) {
                    state.bisctuitCount++;
                }
            }
        },
        pause: () => {
            machinery.oven.turnOn();
        },
        turnOff: () => {
            machinery.oven.turnOff();

            const optionalBiscuit = machinery.conveyor.turnOff();
            
            if (optionalBiscuit != null && machinery.oven.isDesiredTemp()) {
                state.bisctuitCount++;
            } else {
                machinery.motor.turnOff();
            }
        },
        getOvenTemperature: () => {
            return machinery.oven.getCurrentTemp();
        },
        getBiscuitCount: () => {
            return state.bisctuitCount;
        }
    }
};

export { biscuitMachineFactory };
