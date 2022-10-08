/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class GetKthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 先求正序索引再找节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        int t = length - k;
        ListNode cur1 = head;
        while (t > 0) {
            cur1 = cur1.next;
            t--;
        }
        return cur1;
    }
}