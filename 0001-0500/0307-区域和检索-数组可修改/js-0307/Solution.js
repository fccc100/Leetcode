// 树状数组
class BinaryIndexedTree {
    constructor(n) {
        this.tree = Array(n + 1).fill(0);
    }

    lowbit(x) {
        return x & (-x);
    }

    preSum(x) {
        let res = 0;
        for (let i = x; i > 0; i -= this.lowbit(i)) {
            res += this.tree[i];
        }
        return res;
    }

    add(index, x) {
        for (let i = index; i < this.tree.length; i += this.lowbit(i)) {
            this.tree[i] += x;
        }
    }
}

/**
 * @param {number[]} nums
 */
var NumArray = function(nums) {
    this.biTree = new BinaryIndexedTree(nums.length);
    for (let i = 0; i < nums.length; i++) {
        this.biTree.add(i + 1, nums[i]);
    }
    this.nums = nums;
};

/**
 * @param {number} index
 * @param {number} val
 * @return {void}
 */
NumArray.prototype.update = function(index, val) {
    this.biTree.add(index + 1, val - this.nums[index]);
    this.nums[index] = val;
};

/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
NumArray.prototype.sumRange = function(left, right) {
    return this.biTree.preSum(right + 1) - this.biTree.preSum(left);
};

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * obj.update(index,val)
 * var param_2 = obj.sumRange(left,right)
 */