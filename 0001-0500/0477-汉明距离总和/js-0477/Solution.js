/**
 * @param {number[]} nums
 * @return {number}
 */
var totalHammingDistance = function(nums) {
    let n = nums.length;

    let res = 0;
    for (let i = 31; i >= 0; i--) {
        // 当前位1的个数
        let c = 0;

        for (let j = 0; j < nums.length; j++) {
            c += (1 & (nums[j] >> i));
        }

        res += c * (n - c);
    }
    return res;
}