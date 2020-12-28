import { biscuitState } from "./biscuitState.js";

const stamper = () => {

    return {
        stamp: (biscuit) => {
            biscuit.setBiscuitState(biscuitState.STAMPED);
            return biscuit;
        }
    };
};

export { stamper };