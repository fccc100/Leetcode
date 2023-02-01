/**
 * @param {number} targetX
 * @param {number} targetY
 * @return {boolean}
 */
var isReachable = function (x, y) {
    while(x % 2 == 0) x /= 2
    while(y % 2 == 0) y /= 2
    return gcd(x, y) == 1
};

function gcd(x, y) {
    if (y == 0) return x;

    return gcd(y, x % y);
}