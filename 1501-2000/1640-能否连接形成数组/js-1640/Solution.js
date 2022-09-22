/**
 * @param {number[]} arr
 * @param {number[][]} pieces
 * @return {boolean}
 */
var canFormArray = function (arr, pieces) {
    let map = new Map();
    for (let i = 0; i < pieces.length; i++) {
        map.set(pieces[i][0], i);
    }

    for (let i = 0; i < arr.length;) {
        if (!map.has(arr[i])) {
            return false;
        }
        let idx = map.get(arr[i]);

        let tempIdx = i;
        for (let j = 0; j < pieces[idx].length; j++) {
            if (arr[tempIdx] != pieces[idx][j]) {
                return false;
            } else {
                tempIdx++;
            }
        }

        i += pieces[idx].length;
    }
    return true;
};