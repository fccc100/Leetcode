/**
 * @param {number[]} jump
 * @return {number}
 */
var minJump = function (jump) {
    let n = jump.length;

    let visited = Array(n).fill(false);
    let queue = [];
    queue.push(0);
    visited[0] = true;
    let maxIndex = 0;

    let res = 0;
    while (queue.length) {
        let len = queue.length;
        let newQueue = [];

        for (let i = 0; i < len; i++) {
            let cur = queue[i];

            if (cur + jump[cur] >= n) {
                return res + 1;
            }

            if (!visited[cur + jump[cur]]) {
                newQueue.push(cur + jump[cur]);
                visited[cur + jump[cur]] = true;
            }

            for (let j = maxIndex; j < cur; j++) {
                if (!visited[j]) {
                    newQueue.push(j);
                    visited[j] = true;
                }
            }
            maxIndex = Math.max(maxIndex, cur);
        }
        queue = newQueue;
        res++;
    }
    return -1;
};