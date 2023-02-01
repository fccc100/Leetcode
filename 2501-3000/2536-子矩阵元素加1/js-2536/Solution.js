/**
 * @param {number} n
 * @param {number[][]} queries
 * @return {number[][]}
 */
var rangeAddQueries = function(n, queries) {
    let diff = Array(n + 2);
    for (let i = 0; i < diff.length; i++) {
        diff[i] = Array(n + 2).fill(0);
    }
    for (let i = 0; i < queries.length; i++) {
        let x1 = queries[i][0];
        let y1 = queries[i][1];
        let x2 = queries[i][2];
        let y2 = queries[i][3];
        diff[x1 + 1][y1 + 1]++;
        diff[x1 + 1][y2 + 2]--;
        diff[x2 + 2][y1 + 1]--;
        diff[x2 + 2][y2 + 2]++;
    }

    let res = Array(n);
    for (let i = 0; i < n; i++) {
        res[i] = Array(n).fill(0);
    }

    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= n; j++) {
            diff[i][j] += diff[i][j - 1] + diff[i - 1][j] - diff[i - 1][j - 1];
            res[i - 1][j - 1] = diff[i][j];
        }
    }
    return res;
};
