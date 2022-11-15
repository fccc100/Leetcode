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
 * @return {number}
 */
var minimumOperations = function (root) {
    if (root == null) return 0

    let queue = []
    queue.push(root)
    let nums = []
    while (queue.length) {
        let len = queue.length

        let newQueue = []
        let curLevel = []
        for (let i = 0; i < len; i++) {
            let cur = queue[i]
            curLevel.push(cur.val)
            if (cur.left) {
                newQueue.push(cur.left)
            }
            if (cur.right) {
                newQueue.push(cur.right)
            }
        }
        nums.push(curLevel)
        queue = newQueue
    }

    let res = 0
    for (let i = 0; i < nums.length; i++) {
        res += minSwaps(nums[i])
    }
    return res
};

function minSwaps(arr) {
    let n = arr.length;

    let arrpos = [];
    for (let i = 0; i < n; i++)
        arrpos.push([arr[i], i]);

    arrpos.sort(function (a, b) {
        return a[0] - b[0];
    });

    let vis = new Array(n);
    for (let i = 0; i < n; i++) {
        vis[i] = false;
    }
    let ans = 0;

    for (let i = 0; i < n; i++) {
        if (vis[i] || arrpos[i][1] == i)
            continue;
        let cycle_size = 0;
        let j = i;
        while (!vis[j]) {
            vis[j] = true;

            j = arrpos[j][1];

            cycle_size++;
        }

        if (cycle_size > 0) {
            ans += (cycle_size - 1);
        }
    }

    return ans;
}