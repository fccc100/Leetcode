/**
 * @param {number[][]} maze
 * @param {number[]} start
 * @param {number[]} destination
 * @return {boolean}
 */
var hasPath = function(maze, start, destination) {
    let m = maze.length;
    if (m == 0) return false;
    let n = maze[0].length;

    const dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]];

    let visited = Array(m);
    for (let i = 0; i < m; i++) {
        visited[i] = Array(n).fill(false);
    }

    let queue = [];
    visited[start[0]][start[1]] = true;
    queue.push(start);

    while (queue.length) {
        let curV = queue.shift();

        if (curV[0] == destination[0] && curV[1] == destination[1]) {
            return true;
        }

        for (let i = 0; i < dirs.length; i++) {
            let nextX = curV[0] + dirs[i][0];
            let nextY = curV[1] + dirs[i][1];

            while (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && maze[nextX][nextY] == 0) {
                nextX += dirs[i][0];
                nextY += dirs[i][1];
            }

            if (!visited[nextX - dirs[i][0]][nextY - dirs[i][1]]) {
                queue.push([nextX - dirs[i][0], nextY - dirs[i][1]]);
                visited[nextX - dirs[i][0]][nextY - dirs[i][1]] = true;
            }
        }
    }
    return false;
};