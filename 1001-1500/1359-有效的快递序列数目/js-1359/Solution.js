/**
 * @param {number} n
 * @return {number}
 */
var countOrders = function (n) {
    let cnt = 1;
    let mod = 1000000007;

    let gapCnt = 3;
    for (let i = 2; i <= n; i++) {
        let cur = (gapCnt * (gapCnt + 1) / 2) % mod;
        cnt = (cnt * cur) % mod;
        gapCnt += 2;
    }
    return cnt;
};