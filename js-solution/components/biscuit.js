import { biscuitState } from "./biscuitState.js";

const biscuit = (flavor) => {

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
};

export { biscuit };
