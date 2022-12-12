/**
 * @param {string[]} strs
 * @return {number}
 */
var maximumValue = function (strs) {
    let n = strs.length
    let res = 0
    for (let i = 0; i < n; i++) {
        if (!isNaN(strs[i])) {
            res = Math.max(res, Number(strs[i]))
            continue
        } else {
            res = Math.max(res, strs[i].length)
        }
    }
    return res
};