/**
 * @param {number} n
 * @return {number}
 */
var monkeyMove = function(n) {
    let MOD = BigInt(1000000007)
    return (quickPow(2n, BigInt(n)) - 2n + MOD) % MOD
};

function quickPow(x, n) {
    if (n == 0) return 1n

    let y = quickPow(x, n >> 1n)
    y %= 1000000007n
    return n % 2n == 0 ? (y * y % 1000000007n) : ((y * y % 1000000007n) * x) % 1000000007n
}