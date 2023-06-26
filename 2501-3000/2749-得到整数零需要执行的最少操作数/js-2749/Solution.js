/**
 * @param {number} num1
 * @param {number} num2
 * @return {number}
 */
var makeTheIntegerZero = function (num1, num2) {
    // nums1 - nums2 * k
    num1 = BigInt(num1)
    num2 = BigInt(num2)
    for (let k = 0n; k <= num1 - num2 * k; k++) {
        if (k >= bitCount(num1 - num2 * k)) {
            return k
        }
    }
    return -1
};

function bitCount(n) {
    let res = 0n
    while (n > 0) {
        n &= (n - 1n)
        res++
    }
    return res
}