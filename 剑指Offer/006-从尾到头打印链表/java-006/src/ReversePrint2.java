import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReversePrint2 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ArrayList<Integer> temp;

    public int[] reversePrint(ListNode head) {
        temp = new ArrayList<>();

        f(head);

        int n = temp.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }

    private void f(ListNode head) {
        if (head == null) {
            return;
        }

        f(head.next);
        temp.add(head.val);
    }
}