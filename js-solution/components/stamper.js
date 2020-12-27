const { biscuitState } = require("./biscuitState")

module.exports = stamper = () => {

    return {
        stamp: (biscuit) => {
            biscuit.setBiscuitState(biscuitState.STAMPED);
            return biscuit;
        }
    };
}