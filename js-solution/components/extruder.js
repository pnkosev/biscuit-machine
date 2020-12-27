const biscuit = require("./biscuit");

module.exports = extruder = () => {
    
    return {
        extrude: () => {
            return biscuit("Whole wheat");
        }
    }
}