/**
 * @param {number[]} arr
 * @param {number[][]} queries
 * @return {number[]}
 */
var xorQueries = function (arr, queries) {
    let n = arr.length;

    let prefix = Array(n + 1).fill(0);
    prefix[0] = 0;
    for (let i = 1; i <= n; i++) {
        prefix[i] = prefix[i - 1] ^ arr[i - 1];
    }

    let res = Array(queries.length);
    for (let i = 0; i < queries.length; i++) {
        res[i] = prefix[queries[i][1] + 1] ^ prefix[queries[i][0]];
    }
    return res;
};