/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {number[]}
 */
var reversePrint = function(head) {
    let temp = [];
    while (head != null) {
        temp.push(head.val);
        head = head.next;
    }

    let res = [];
    while (temp.length) {
        res.push(temp.pop());
    }
    return res;
};