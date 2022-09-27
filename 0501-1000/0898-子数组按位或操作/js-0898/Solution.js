/**
 * @param {number[]} arr
 * @return {number}
 */
var subarrayBitwiseORs = function (arr) {
    let n = arr.length;

    // dp[i]表示已i结尾的子数组中有哪些按位或结果
    let dp = Array(n);
    for (let i = 0; i < n; i++) {
        dp[i] = new Set();
    }

    let res = new Set();
    dp[0].add(arr[0]);
    res.add(arr[0]);
    for (let i = 1; i < n; i++) {
        let preSet = dp[i - 1];

        for (let k of preSet) {
            dp[i].add(k | arr[i]);
            res.add(k | arr[i]);
        }
        dp[i].add(arr[i]);
        res.add(arr[i]);
    }

    return res.size;
};