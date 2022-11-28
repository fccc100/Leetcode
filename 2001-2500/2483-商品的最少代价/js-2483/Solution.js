/**
 * @param {string} customers
 * @return {number}
 */
var bestClosingTime = function (customers) {
    let nums = customers.split('')
    let n = nums.length
    for (let i = 0; i < n; i++) {
        nums[i] = nums[i] == 'Y' ? 1 : 0
    }

    let lastOne = Array(n + 1).fill(0)
    lastOne[n] = 0
    for (let i = n - 1; i >= 0; i--) {
        if (nums[i] == 1) {
            lastOne[i] = lastOne[i + 1] + 1
        } else {
            lastOne[i] = lastOne[i + 1]
        }
    }

    let preZero = Array(n + 1)
    preZero[0] = 0
    for (let i = 1; i <= n; i++) {
        if (nums[i - 1] == 0) {
            preZero[i] = preZero[i - 1] + 1
        } else {
            preZero[i] = preZero[i - 1]
        }
    }

    let min = Infinity
    let res = -1
    for (let i = 0; i <= n; i++) {
        if (preZero[i] + lastOne[i] < min) {
            min = preZero[i] + lastOne[i]
            res = i
        }
    }
    return res
};