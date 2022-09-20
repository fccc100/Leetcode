/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
    return hammingWeight(x ^ y);
}

function hammingWeight(n) {
    let res = 0;
    while (n != 0) {
        n &= n - 1;
        res++;
    }
    return res;
}