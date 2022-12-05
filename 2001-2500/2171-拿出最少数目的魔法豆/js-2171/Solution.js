/**
 * @param {number[]} beans
 * @return {number}
 */
var minimumRemoval = function (beans) {
    let n = beans.length

    let sum = 0
    for (let i = 0; i < n; i++) {
        sum += beans[i]
    }

    beans.sort((a, b) => a - b)
    let presum = 0
    let res = Infinity
    for (let i = 0; i < n; i++) {
        res = Math.min(res, presum + (sum - presum - beans[i] - (beans[i] * (n - i - 1))));
        presum += beans[i]
    }

    return res
};