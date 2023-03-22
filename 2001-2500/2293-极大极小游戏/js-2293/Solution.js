/**
 * @param {number[]} nums
 * @return {number}
 */
var minMaxGame = function(nums) {
    if (nums.length == 1) return nums[0];
    let n = nums.length;
    while(n > 1) {
        for (let i = 0; i < n / 2; i++) {
            if (i % 2 == 0) {
                let index = nums[2 * i] < nums[2 * i + 1] ? 2 * i : 2 * i + 1;
                swap(nums, i, index);
            } else {
                let index = nums[2 * i] > nums[2 * i + 1] ? 2 * i : 2 * i + 1;
                swap(nums, i, index);
            }
        }
        n = n / 2;
    }
    return nums[0];
};

function swap(nums, i, j) {
    let temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}