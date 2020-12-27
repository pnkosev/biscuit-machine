module.exports = queue = () => {

    let arr = [];
    let index = 0;

    return {
        add: (item) => {
            arr.unshift(item);
            index++;
        },
        remove: () => {
            if (arr.length != 0) {
                index--;
                return arr.pop();
            }

            return null;
        },
        peek: () => {
            if (arr.length != 0) {
                return arr[arr.length - 1];
            }

            return null;
        },
        size: () => {
            return arr.length;
        },
        isEmpty: () => {
            return index === 0;
        }
    }
}