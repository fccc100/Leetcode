/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    return n >= 0 ? quickPow(x, n) : 1 / quickPow(x, -n);
};

function quickPow(x, n) {
    let res = 1;
    let t = x;

    while (n > 0) {
        if (n & 1 != 0) {
            res *= t;
        }
        t *= t;

        n = Math.floor(n / 2);
    }
    return res;
}