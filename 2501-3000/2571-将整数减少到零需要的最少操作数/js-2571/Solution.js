/**
 * @param {number} n
 * @return {number}
 */
var minOperations = function(n) {
    if ((n & (n - 1)) == 0) {
        return 1;
    }

    return Math.min(minOperations((n & (n - 1))) + 1, minOperations(n + (n & -n)) + 1);
};