/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var removeNodes = function (head) {
    let max = -Infinity

    function __removeNodes(head) {
        if (head == null) return null

        head.next = __removeNodes(head.next)
        max = Math.max(max, head.val)
        if (head.val < max) {
            return head.next
        }
        return head
    }

    return __removeNodes(head)
};