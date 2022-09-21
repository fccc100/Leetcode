import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReversePrint {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> temp = new ArrayList<>();

        while (head != null) {
            temp.add(head.val);
            head = head.next;
        }

        int n = temp.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = temp.get(n - i - 1);
        }
        return res;
    }
}