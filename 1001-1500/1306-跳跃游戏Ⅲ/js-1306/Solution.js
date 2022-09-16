/**
 * @param {number[]} arr
 * @param {number} start
 * @return {boolean}
 */
var canReach = function(arr, start) {
    let n = arr.length;

    let visited = Array(n).fill(false);

    let queue = [];
    queue.push(start);
    visited[start] = true;

    while (queue.length) {
        let cur = queue.shift();

        if (arr[cur] == 0) {
            return true;
        }

        let next1 = cur - arr[cur];
        let next2 = cur + arr[cur];

        if (next1 >= 0 && !visited[next1]) {
            queue.push(next1);
            visited[next1] = true;
        }
        if (next2 < n && !visited[next2]) {
            queue.push(next2);
            visited[next2] = true;
        }
    }

    return false;
};