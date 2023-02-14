/**
 * @param {number[]} hours
 * @return {number}
 */
var longestWPI = function(hours) {
    for (let i = 0; i < hours.length; i++) {
        hours[i] = hours[i] > 8 ? 1 : -1
    }
    let interval = longestSubarray(hours, 0)
    return interval[1] == -1 ? 0 : interval[1] - interval[0] + 1
};
// 求和大于target的最长子数组， 返回子数组区间的左右端点
function longestSubarray(nums, target) {
    let n = nums.length
    // 求前缀和
    let presum = Array(n + 1).fill(0)
    for (let i = 1; i <= n; i++) {
        presum[i] = presum[i - 1] + nums[i - 1]
    }

    // 求单调递减栈
    let stack = []
    for (let i = 0; i <= n; i++) {
        if (!stack.length || presum[stack[stack.length - 1]] - presum[i] > 0) {
            stack.push(i)
        }
    }

    let max = 0;
    let res = [-1, -1]
    for (let i = n; i >= 0; i--) {
        while (stack.length) {
            if (presum[i] - presum[stack[stack.length - 1]] > target) {
                if (i - stack[stack.length - 1] > max) {
                    max = i - stack[stack.length - 1]
                    res = [stack[stack.length - 1], i - 1]
                }
                stack.pop()
            } else break
        }
    }
    return res
}