/**
 * @param {number[][]} grid
 * @return {number}
 */
var deleteGreatestValue = function (grid) {
    let m = grid.length
    let n = grid[0].length
    for (let i = 0; i < m; i++) {
        grid[i].sort((a, b) => b - a)
    }

    let res = 0
    for (let j = 0; j < n; j++) {
        let cur = -Infinity
        for (let i = 0; i < m; i++) {
            cur = Math.max(cur, grid[i][j])
        }
        res += cur
    }
    return res
};