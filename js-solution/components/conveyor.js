const queueFactoryFunc = require("../utils/queue");

module.exports = conveyor = (size) => {

    let belt = queueFactoryFunc();
    const beltLength = size;

    return {
        add: (item) => {  
            belt.add(item);
        },
        turnOn: () => {
            if (belt.size() == beltLength) {
                return belt.remove();
            }

            return null;
        },
        turnOff: () => {
            if (!belt.isEmpty()) {
                return belt.remove();
            }

            return null;
        }
    }
}