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
 * @return {number[]}
 */
var preorderTraversal = function(root) {
    if (root == null) return [];
    let stack = [];
    stack.push(root);

    let res = [];
    while(stack.length) {
        let curNode = stack.pop();
        res.push(curNode.val);

        if (curNode.right) {
            stack.push(curNode.right);
        }
        if (curNode.left) {
            stack.push(curNode.left);
        }
    }
    return res;
};