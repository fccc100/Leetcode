/**
 * @param {number[]} reward1
 * @param {number[]} reward2
 * @param {number} k
 * @return {number}
 */
var miceAndCheese = function (reward1, reward2, k) {
    let n = reward1.length

    let res = 0
    let p = []
    for (let i = 0; i < n; i++) {
        p.push([reward1[i], reward2[i]])
    }

    p.sort((a, b) => (b[0] - b[1]) - (a[0] - a[1]))


    for (let i = 0; i < k; i++) {
        res += p[i][0]
    }
    for (let i = k; i < n; i++) {
        res += p[i][1]
    }
    return res
};