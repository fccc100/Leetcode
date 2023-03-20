/**
 * @param {string} s
 * @param {string} target
 * @return {number}
 */
var rearrangeCharacters = function(s, target) {
    let targetMap = new Map();
    for (let i = 0; i < target.length; i++) {
        if (!targetMap.has(target[i])) {
            targetMap.set(target[i], 1);
        } else {
            targetMap.set(target[i], targetMap.get(target[i]) + 1);
        }
    }

    let sMap = new Map();
    for (let i = 0; i < s.length; i++) {
        if (targetMap.has(s[i])) {
            if (!sMap.has(s[i])) {
                sMap.set(s[i], 1);
            } else {
                sMap.set(s[i], sMap.get(s[i]) + 1);
            }
        }
    }

    if (sMap.size < targetMap.size) {
        return 0;
    }

    let min = Infinity;
    for (let entry of sMap) {
        min = Math.min(min, Math.floor(entry[1] / targetMap.get(entry[0])));
    }
    return min;
};