/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class DeleteNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 迭代，且不使用虚拟头节点
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) {
            return head.next;
        } else {
            ListNode cur = head;
            while (cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                    break;
                }
                cur = cur.next;
            }
        }
        return head;
    }
}