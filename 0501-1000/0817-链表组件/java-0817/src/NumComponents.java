import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class NumComponents {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        boolean newComponent = true;
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            if (set.contains(cur.val)) {
                if (newComponent) {
                    res++;
                    newComponent = false;
                }
            } else {
                newComponent = true;
            }
            cur = cur.next;
        }
        return res;
    }
}