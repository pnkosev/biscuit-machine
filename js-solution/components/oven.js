const oven = () => {

    let state = {
        currentTemp: 0,
        targetTemp: 0,
        lowerTempMargin: 20,
        step: 10,
        isReady: false
    };

    const checkTemp = () => {
        if (state.currentTemp == state.targetTemp) {
            state.isReady = true;
        } else if (state.currentTemp <= state.targetTemp - state.lowerTempMargin) {
            state.isReady = false;
        }
    };

    const increaseTemp = () => {
        state.currentTemp += state.step;
    };

    const decreaseTemp = () => {
        state.currentTemp -= state.step;
    };

    return {
        setTargetTemperature: (targetTemp) => {
            state.targetTemp = targetTemp;
        },
        turnOn: () => {
            checkTemp();
            if (!state.isReady) {
                increaseTemp();
            } else {
                decreaseTemp();
            }

            console.log(state.currentTemp);
        },
        turnOff: () => {
            if (state.currentTemp > 0) {
                decreaseTemp();
            }
        },
        getCurrentTemp: () => {
            return state.currentTemp;
        },
        isDesiredTemp: () => {
            return state.currentTemp >= state.targetTemp - state.lowerTempMargin
                && state.currentTemp <= state.targetTemp;
        }
    }
};

export { oven };
