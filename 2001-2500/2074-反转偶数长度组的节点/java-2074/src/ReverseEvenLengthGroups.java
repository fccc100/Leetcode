import java.util.ArrayList;
import java.util.List;

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
class ReverseEvenLengthGroups {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        List<ListNode> groupList = new ArrayList<>();
        groupList.add(head);
        int idx = 1;
        int cnt = 1;
        while (head != null) {
            head = head.next;
            if (head == null) break;
            if (idx == cnt) {
                groupList.add(head);
                idx = 1;
                cnt++;
            } else {
                idx++;
            }
        }

        for (int i = 0; i < groupList.size() - 1; i++) {
            ListNode h = groupList.get(i);
            ListNode last = h;
            int c = i + 1;
            while (c > 1) {
                last = last.next;
                c--;
            }

            last.next = null;
        }


        for (int i = 0; i < groupList.size(); i++) {
            if (i == groupList.size() - 1) {
                int count = 0;
                ListNode node = groupList.get(i);
                while (node != null) {
                    count++;
                    node = node.next;
                }
                if (count % 2 == 0) {
                    ListNode revNode = reverseList(groupList.get(i), i + 1);
                    groupList.set(i, revNode);
                }
            } else {
                if (i % 2 == 1) {
                    ListNode revNode = reverseList(groupList.get(i), i + 1);
                    groupList.set(i, revNode);
                }
            }
        }

        for (int i = 0; i < groupList.size() - 1; i++) {
            ListNode h = groupList.get(i);
            ListNode last = h;
            int c = i + 1;
            while (c > 1) {
                last = last.next;
                c--;
            }
            last.next = groupList.get(i + 1);
        }
        return groupList.get(0);
    }

    private ListNode reverseList(ListNode head, int cnt) {
        if (cnt == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode revNode = reverseList(head.next, cnt - 1);
        head.next.next = head;
        head.next = null;
        return revNode;
    }
}