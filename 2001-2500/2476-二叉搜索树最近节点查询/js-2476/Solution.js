/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number[]} queries
 * @return {number[][]}
 */
var closestNodes = function (root, queries) {
    let nums = []

    function dfs(root) {
        if (root == null) {
            return
        }
        dfs(root.left)
        nums.push(root.val)
        dfs(root.right)
    }

    dfs(root)

    let n = queries.length
    let res = Array(n)
    for (let i = 0; i < n; i++) {
        res[i] = []
        let min = upper_floor(nums, queries[i])
        res[i][0] = min < 0 ? -1 : nums[min]

        let max = lower_ceil(nums, queries[i])
        res[i][1] = max >= nums.length ? -1 : nums[max]
    }
    return res;
};

// 查找小于等于target的最小索引
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

// 返回大于等于target的最小值的索引，没有大于target的值返回n
function lower_ceil(nums, target) {
    let l = 0;
    let r = nums.length;
    while (l < r) {
        let mid = l + (r - l >> 1);
        if (nums[mid] < target) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    return l;
}