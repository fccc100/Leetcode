/**
 * @param {string[]} words
 * @param {number[][]} queries
 * @return {number[]}
 */
var vowelStrings = function (words, queries) {
    let m = words.length
    let cnts = Array(m).fill(0)
    let w = ['a', 'e', 'i', 'o', 'u']
    for (let i = 0; i < m; i++) {
        if (w.includes(words[i][0]) && w.includes(words[i][words[i].length - 1])) {
            cnts[i] = 1
        }
    }
    let presum = Array(m + 1).fill(0)
    for (let i = 1; i <= m; i++) {
        presum[i] = presum[i - 1] + cnts[i - 1]
    }

    let res = Array(queries.length)
    for (let i = 0; i < queries.length; i++) {
        let l = queries[i][0]
        let r = queries[i][1]
        res[i] = presum[r + 1] - presum[l]
    }
    return res
};