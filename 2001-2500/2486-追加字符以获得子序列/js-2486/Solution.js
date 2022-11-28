/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var appendCharacters = function (s, t) {
    let m = s.length
    let n = t.length

    let i = 0
    let j = 0
    let len = 0
    while (i < m && j < n) {
        if (s[i] == t[j]) {
            i++
            j++
        } else {
            i++
        }
    }
    return n - j
};