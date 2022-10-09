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
var expandBinaryTree = function(root) {
    if (root == null) return;
    if (root.left == null && root.right == null) return;

    expandBinaryTree(root.left);
    expandBinaryTree(root.right);
    if (root.left) {
        root.left = new TreeNode(-1, root.left);
    }
    if (root.right) {
        root.right = new TreeNode(-1, null, root.right)
    }
    return root;
};