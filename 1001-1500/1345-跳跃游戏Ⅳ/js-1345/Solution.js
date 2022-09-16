/**
 * @param {number[]} arr
 * @return {number}
 */

var minJumps = function (arr) {
    let n = arr.length;

    let map = new Map();
    for (let i = 0; i < n; i++) {
        if (!map.has(arr[i])) {
            map.set(arr[i], []);
        }
        map.get(arr[i]).push(i);
    }

    let visited = Array(n).fill(false);
    let queue = [];
    queue.push(0);
    visited[0] = true;

    let res = 0;
    while (queue.length) {
        let len = queue.length;

        let newQueue = [];
        for (let i = 0; i < len; i++) {
            let cur = queue[i];

            if (cur == n - 1) {
                return res;
            }

            if (cur - 1 >= 0 && !visited[cur - 1]) {
                newQueue.push(cur - 1);
                visited[cur - 1] = true;
            }
            if (cur + 1 < n && !visited[cur + 1]) {
                newQueue.push(cur + 1);
                visited[cur + 1] = true;
            }

            let path = map.get(arr[cur]);
            for (let j = 0; j < path.length; j++) {
                if (path[j] == cur) {
                    continue;
                }

                if (!visited[path[j]]) {
                    newQueue.push(path[j]);
                    visited[path[j]] = true;
                }
            }
            // 访问过的点清空，避免下一次再做无效遍历
            map.get(arr[cur]).length = 0;
        }
        queue = newQueue;
        res++;
    }
    return -1;
};