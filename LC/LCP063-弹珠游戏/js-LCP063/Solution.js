/**
 * @param {number} num
 * @param {string[]} plate
 * @return {number[][]}
 */
var ballGame = function (num, plate) {
    let m = plate.length;
    if (m == 0) return [];
    let n = plate[0].length;

    for (let i = 0; i < m; i++) {
        plate[i] = plate[i].split('');
    }

    const dirs = [[-1, 0], [0, 1], [1, 0], [0, -1]];

    function bfs(x, y, dirIdx, step) {
        if (step > num) return false;

        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }

        if (plate[x][y] == '.') {
            let dir = dirs[dirIdx];
            let nextX = x + dir[0];
            let nextY = y + dir[1];
            return bfs(nextX, nextY, dirIdx, step + 1);
        } else if (plate[x][y] == 'W') {
            let nextDidIdx = (dirIdx + 4 - 1) % 4;
            let dir = dirs[nextDidIdx];
            let nextX = x + dir[0];
            let nextY = y + dir[1];
            return bfs(nextX, nextY, nextDidIdx, step + 1);
        } else if (plate[x][y] == 'E') {
            let nextDidIdx = (dirIdx + 1) % 4;
            let dir = dirs[nextDidIdx];
            let nextX = x + dir[0];
            let nextY = y + dir[1];
            return bfs(nextX, nextY, nextDidIdx, step + 1);
        } else {
            return true;
        }

        return false;
    }

    let res = [];
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (i == 0 && j == 0) {
                continue;
            }
            if (i == 0 && j == n - 1) {
                continue;
            }
            if (i == m - 1 && j == 0) {
                continue;
            }
            if (i == m - 1 && j == n - 1) {
                continue;
            }
            if (plate[i][j] !== '.') {
                continue;
            }

            if (i == 0) {
                if (bfs(i, j, 2, 0)) {
                    res.push([i, j]);
                }
            }
            if (j == 0) {
                if (bfs(i, j, 1, 0)) {
                    res.push([i, j]);
                }
            }
            if (i == m - 1) {
                if (bfs(i, j, 0, 0)) {
                    res.push([i, j]);
                }
            }
            if (j == n - 1) {
                if (bfs(i, j, 3, 0)) {
                    res.push([i, j]);
                }
            }
        }
    }
    return res;
};