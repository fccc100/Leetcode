/**
 * @param {number[][]} grid
 * @return {boolean}
 */
var checkValidGrid = function (grid) {
    let m = grid.length
    let n = grid[0].length
    function check(grid, i, j, val) {
        if (i < 0 || i >= m) return false
        if (j < 0 || j >= n) return false
        if (grid[i][j] != val) return false
        if (val == m * n - 1) return true

        return check(grid, i + 2, j + 1, val + 1) || check(grid, i + 2, j - 1, val + 1) || check(grid, i + 1, j + 2, val + 1) || check(grid, i + 1, j - 2, val + 1) || check(grid, i - 1, j + 2, val + 1) || check(grid, i - 1, j - 2, val + 1) || check(grid, i - 2, j + 1, val + 1) || check(grid, i - 2, j - 1, val + 1)
    }

    return check(grid, 0, 0, 0)
};