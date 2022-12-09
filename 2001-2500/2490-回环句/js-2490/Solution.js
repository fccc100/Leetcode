/**
 * @param {string} sentence
 * @return {boolean}
 */
var isCircularSentence = function (s) {
    s = s.split(' ')
    let n = s.length

    let cur = s[0][s[0].length - 1]

    for (let i = 1; i < n; i++) {
        let c = s[i]
        if (c[0] != cur) {
            return false
        }
        cur = c[c.length - 1]
    }
    return s[0][0] == cur
};