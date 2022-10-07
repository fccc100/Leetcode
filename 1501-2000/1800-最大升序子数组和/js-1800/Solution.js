var maxAscendingSum = function (nums) {
    let res = nums[0];
    let sum = nums[0];
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            sum += nums[i];
            res = Math.max(res, sum);
        } else {
            sum = nums[i];
        }
    }
    return res;
}