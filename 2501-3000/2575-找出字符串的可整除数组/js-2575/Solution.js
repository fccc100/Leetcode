/**
 * @param {string} word
 * @param {number} m
 * @return {number[]}
 */
var divisibilityArray = function (word, m) {
    let n = word.length
    let res = Array(n).fill(0)

    let cur = ''
    for (let i = 0; i < n; i++) {
        cur = cur + word[i]
        if (Number(cur) % m == 0) {
            res[i] = 1
        }
        cur = String(Number(cur) % m)
    }
    return res
};