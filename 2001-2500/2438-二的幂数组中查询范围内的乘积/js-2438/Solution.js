/**
 * @param {number} n
 * @param {number[][]} queries
 * @return {number[]}
 */
var productQueries = function (n, queries) {
    let m = queries.length;
    let res = Array(m);
    let mod = 1000000007;
    let pows = Array(32);
    pows[0] = 1;
    for (let i = 1; i < 32; i++) {
        pows[i] = pows[i - 1] * 2;
    }
    for (let i = 0; i < queries.length; i++) {
        let cur = 1;
        let oneCnt = 0;
        for (let j = 0; j < 30; j++) {
            if ((n & (1 << j)) != 0) {
                oneCnt++;
                if (oneCnt >= queries[i][0] + 1 && oneCnt <= queries[i][1] + 1) {
                    cur = (cur * pows[j]) % mod;
                }
            }

            if (oneCnt >= queries[i][1] + 1) break;
        }

        res[i] = cur;
    }
    return res;
};