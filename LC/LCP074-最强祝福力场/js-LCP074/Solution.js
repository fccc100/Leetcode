/**
 * @param {number[][]} forceField
 * @return {number}
 */
var fieldOfGreatestBlessing = function (forceField) {
    let n = forceField.length

    let xSet = new Set()
    let ySet = new Set()
    for (let i = 0; i < n; i++) {
        let x = forceField[i][0]
        let y = forceField[i][1]
        let r = forceField[i][2]
        let x1 = x * 2 - r
        let y1 = y * 2 - r
        let x2 = x * 2 + r
        let y2 = y * 2 + r

        xSet.add(x1)
        xSet.add(x2)
        ySet.add(y1)
        ySet.add(y2)
    }

    let xs = [...xSet]
    let ys = [...ySet]
    xs.sort((a, b) => a - b)
    ys.sort((a, b) => a - b)

    let diff = Array(n * 2 + 2)
    for (let i = 0; i < diff.length; i++) {
        diff[i] = Array(n * 2 + 2).fill(0)
    }

    for (let i = 0; i < n; i++) {
        let x = forceField[i][0]
        let y = forceField[i][1]
        let r = forceField[i][2]
        let x1 = x * 2 - r
        let y1 = y * 2 - r
        let x2 = x * 2 + r
        let y2 = y * 2 + r

        diff[xs.indexOf(x1) + 1][ys.indexOf(y1) + 1] ++
        diff[xs.indexOf(x2) + 2][ys.indexOf(y1) + 1] --
        diff[xs.indexOf(x1) + 1][ys.indexOf(y2) + 2] --
        diff[xs.indexOf(x2) + 2][ys.indexOf(y2) + 2] ++

        // 数据量大时可使用二分查找坐标
        // diff[upper_floor(xs, x1) + 1][upper_floor(ys, y1) + 1] ++
        // diff[upper_floor(xs, x2) + 2][upper_floor(ys, y1) + 1] --
        // diff[upper_floor(xs, x1) + 1][upper_floor(ys, y2) + 2] --
        // diff[upper_floor(xs, x2) + 2][upper_floor(ys, y2) + 2] ++
    }

    let res = 0
    for (let i = 1; i < diff.length; i++) {
        for (let j = 1; j < diff[i].length; j++) {
            diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1]
            res = Math.max(res, diff[i][j])
        }
    }

    return res
};

function upper_floor(nums, target) {
    let l = -1;
    let r = nums.length - 1;
    while (l < r) {
        let mid = l + (r - l + 1 >> 1);
        if (nums[mid] <= target) {
            l = mid;
        } else {
            r = mid - 1;
        }
    }
    return l;
}