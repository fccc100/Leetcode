/**
 * @param {number} n
 * @param {number[][]} logs
 * @return {number}
 */
var hardestWorker = function (n, logs) {
    logs.sort((a, b) => a[1] - b[1]);

    let res = Infinity;
    let max = -Infinity;
    let end = 0;
    for (let i = 0; i < logs.length; i++) {
        let cur = logs[i][1] - end;

        if (cur > max) {
            max = cur;
            res = logs[i][0];
        }
        if (cur == max) {
            if (logs[i][0] < res) {
                res = logs[i][0]
            }
        }
        end = logs[i][1]
    }
    return res;
};