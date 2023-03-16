/**
 * @param {string[]} words
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var vowelStrings = function (words, left, right) {
    let n = words.length
    let arr = ['a', 'e', 'i', 'o', 'u']
    let res = 0
    for (let i = left; i <= right; i++) {
        let w = words[i]
        if (arr.includes(w[0]) && arr.includes(w[w.length - 1])) {
            res++
        }
    }
    return res
};