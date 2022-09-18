/**
 * @param {number[][]} points
 * @param {number} k
 * @return {number}
 */
var findMaxValueOfEquation = function (points, k) {
    let n = points.length;

    let res = -Infinity;
    let queue = [];
    queue.push(points[0]);

    for (let i = 1; i < n; i++) {

        while (queue.length && points[i][0] - queue[0][0] > k) {
            queue.shift();
        }

        if (queue.length) {
            res = Math.max(res, queue[0][1] + points[i][1] + Math.abs(queue[0][0] - points[i][0]))
        }

        while (queue.length && points[i][1] - points[i][0] >= queue[queue.length - 1][1] - queue[queue.length - 1][0]) {
            queue.pop();
        }

        queue.push(points[i]);
    }

    return res;
};