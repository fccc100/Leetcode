/**
 * @param {number} n
 * @return {number[]}
 */
var evenOddBit = function (n) {
    let s = n.toString(2)
    let res = [0, 0]
    for (let i = 0; i < s.length; i++) {
        if (s[s.length - 1 - i] == 1) {
            if (i % 2 == 0) {
                res[0]++
            } else {
                res[1]++
            }
        }
    }
    return res
};