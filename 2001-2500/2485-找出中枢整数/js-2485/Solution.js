/**
 * @param {number} n
 * @return {number}
 */
var pivotInteger = function (n) {
    let sum = 0
    for (let i = 0; i <= n; i++) {
        sum += i
    }

    let psum = 0
    for (let x = 1; x <= n; x++) {
        psum += x
        if (psum == sum - psum + x) {
            return x
        }
    }
    return -1
};