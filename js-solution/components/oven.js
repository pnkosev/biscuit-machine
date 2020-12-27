module.exports = oven = () => {

    let state = {
        currentTemp: 0,
        lowerTempMargin: 20,
        step: 10,
        isReady: false
    };

    const checkTemp = (targetTemp) => {
        if (state.currentTemp >= targetTemp) {
            state.isReady = true;
        } else if (state.currentTemp <= targetTemp - state.lowerTempMargin) {
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
        turnOn: (targetTemp) => {
            checkTemp(targetTemp);
            if (!state.isReady) {
                increaseTemp();
            } else {
                decreaseTemp();
            }
        },
        turnOff: () => {
            if (state.currentTemp > 0) {
                decreaseTemp();
            }
        },
        getCurrentTemp: () => {
            return state.currentTemp;
        },
        isDesiredTemp: (targetTemp) => {
            return state.currentTemp >= targetTemp - state.lowerTempMargin
                && state.currentTemp <= targetTemp;
        }
    }
}
