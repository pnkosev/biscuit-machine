import { biscuit } from "./biscuit.js";

const extruder = () => {

    return {
        extrude: () => {
            return biscuit("Whole wheat");
        }
    }
};

export { extruder };