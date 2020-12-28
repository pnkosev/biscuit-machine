const queue = () => {

    let arr = [];
    let length = arr.length;

    return {
        add: (item) => {
            arr.unshift(item);
            length++;
        },
        remove: () => {
            if (length > 0) {
                length--;
                return arr.pop();
            }

            return null;
        },
        peek: () => {
            if (length > 0) {
                return arr[length - 1];
            }

            return null;
        },
        size: () => {
            return length;
        },
        isEmpty: () => {
            return length === 0;
        }
    }
};

export { queue };