const biscuitState = require("./biscuitState");

module.exports = biscuit = (flavor) => {

    let state = {
        flavor,
        biscuitState: biscuitState.RAW,
    };

    return {
        getBiscuitState: () => {
            return state.biscuitState;
        },
        setBiscuitState: (newState) => {
            state.biscuitState = newState;
        }
    }
}
