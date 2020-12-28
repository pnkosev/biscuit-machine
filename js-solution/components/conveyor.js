import { queue } from "../utils/queue.js";

const conveyor = (size) => {

    let slots = queue();
    const beltLength = size;

    return {
        add: (item) => {
            slots.add(item);
        },
        turnOn: () => {
            if (slots.size() == beltLength) {
                return slots.remove();
            }

            return null;
        },
        turnOff: () => {
            if (!slots.isEmpty()) {
                return slots.remove();
            }

            return null;
        },
        getSlotOccupancy: () => {
            return slots.size();
        }
    }
};

export { conveyor };