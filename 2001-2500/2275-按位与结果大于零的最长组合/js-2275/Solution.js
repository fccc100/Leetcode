/**
 * @param {number[]} candidates
 * @return {number}
 */
// 求哪一位上1的个数最大，最大值就是结果
var largestCombination = function (candidates) {
    let n = candidates.length;

    let map = Array(32).fill(0);
    for (let i = 0; i < n; i++) {
        let cur = candidates[i];

        for (let i = 0; i < 32; i++) {
            if ((cur & (1 << i)) != 0) {
                map[i]++;
            }
        }
    }

    let res = 0;
    for (let i = 0; i < map.length; i++) {
        res = Math.max(res, map[i]);
    }
    return res;
};