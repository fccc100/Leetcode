/**
 * @param {number[][]} grid
 * @return {number[][]}
 */
var onesMinusZeros = function (grid) {
    let m = grid.length
    let n = grid[0].length

    let diffRow = Array(m).fill(0)
    for (let i = 0; i < m; i++) {
        let one = 0
        let zero = 0
        for (let j = 0; j < n; j++) {
            if (grid[i][j] == 0) {
                zero++
            } else {
                one++
            }
        }
        diffRow[i] = one - zero
    }
    let diffCol = Array(n).fill(0)
    for (let i = 0; i < n; i++) {
        let one = 0
        let zero = 0
        for (let j = 0; j < m; j++) {
            if (grid[j][i] == 0) {
                zero++
            } else {
                one++
            }
        }
        diffCol[i] = one - zero
    }

    let res = Array(m)
    for (let i = 0; i < m; i++) {
        res[i] = Array(n).fill(0)
    }

    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            res[i][j] = diffRow[i] + diffCol[j]
        }
    }
    return res;
};