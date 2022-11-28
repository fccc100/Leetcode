/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveNodes {
    int max = Integer.MIN_VALUE;
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        max = Math.max(max, head.val);
        if (head.val < max) {
            return head.next;
        }
        return head;
    }
}