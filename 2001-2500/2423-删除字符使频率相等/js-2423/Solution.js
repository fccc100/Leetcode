/**
 * @param {string} word
 * @return {boolean}
 */
var equalFrequency = function (word) {
    for (let i = 0; i < word.length; i++) {
        let map = new Map();
        for (let j = 0; j < word.length; j++) {
            if (i == j) {
                continue;
            }
            if (!map.has(word[j])) {
                map.set(word[j], 1);
            } else {
                map.set(word[j], map.get(word[j]) + 1);
            }
        }

        let set = new Set();
        for (let [k, v] of map) {
            set.add(v);
        }
        if (set.size == 1) {
            return true;
        }
    }
    return false;
};