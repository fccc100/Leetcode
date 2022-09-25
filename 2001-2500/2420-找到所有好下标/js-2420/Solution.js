/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var goodIndices = function (nums, k) {
    let n = nums.length;

    let leftDp = Array(n).fill(1);
    for (let i = 1; i < n; i++) {
        if (nums[i] <= nums[i - 1]) {
            leftDp[i] = leftDp[i - 1] + 1;
        }
    }

    let rightDp = Array(n).fill(1);
    for (let i = n - 2; i >= 0; i--) {
        if (nums[i] <= nums[i + 1]) {
            rightDp[i] = rightDp[i + 1] + 1;
        }
    }

    let res = [];
    for (let i = 0; i < n; i++) {
        if ((i - 1 >= 0 ? leftDp[i - 1] : 0) >= k && (i + 1 < n ? rightDp[i + 1] : 0) >= k) {
            res.push(i);
        }
    }
    return res;
};