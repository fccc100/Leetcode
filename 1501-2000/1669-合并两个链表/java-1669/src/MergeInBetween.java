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
class MergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list2Head = list2;
        ListNode list2Tail = list2;
        while (list2Tail.next != null) {
            list2Tail = list2Tail.next;
        }

        ListNode start = list1;
        while (a > 1) {
            start = start.next;
            a--;
        }
        ListNode end = list1;
        while (b > 0) {
            end = end.next;
            b--;
        }
        end = end.next;

        start.next = list2Head;
        list2Tail.next = end;
        return list1;
    }
}