/**
 * @param {number[]} stones
 * @return {number}
 */
var maxJump = function(stones) {
    let res = 0;
    for (let i = 2; i < stones.length; i++) res = Math.max(res, stones[i] - stones[i - 2]);
    for (let i = 1; i < stones.length; i++) res = Math.max(res, stones[i] - stones[i - 1]);
    return res;
};