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
class SplitCircularLinkedList {
    public ListNode[] splitCircularLinkedList(ListNode list) {
        int size = 1;
        ListNode cur = list;
        Set<ListNode> set = new HashSet<>();
        set.add(cur);
        while (!set.contains(cur.next)) {
            size++;
            cur = cur.next;
            set.add(cur);
        }
        int lSize = (int) Math.ceil((double) size / 2);
        ListNode lHead = list;
        ListNode lTail = list;
        while (lSize > 1) {
            lTail = lTail.next;
            lSize--;
        }
        ListNode rHead = lTail.next;
        lTail.next = lHead;
        cur.next = rHead;
        return new ListNode[]{lHead, rHead};
    }
}