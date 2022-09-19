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
 * @return {TreeNode}
 */
var reverseOddLevels = function (root) {
    if (root == null) return null;
    if (root.left == null && root.right == null) return root;

    let queue = [];

    let curLevel = 0;
    queue.push(root);

    while (queue.length) {
        let len = queue.length;

        let nodeList = [];
        let nodeValue = [];
        for (let i = 0; i < len; i++) {
            let curNode = queue.shift();
            if (curNode.left) {
                queue.push(curNode.left);
            }
            if (curNode.right) {
                queue.push(curNode.right);
            }

            nodeList.push(curNode);
            nodeValue.push(curNode.val);
        }

        if (curLevel % 2 == 1) {
            let n = nodeList.length

            for (let i = 0; i < n; i++) {
                nodeList[i].val = nodeValue[n - i - 1];
            }
        }
        curLevel++;
    }
    return root;
};