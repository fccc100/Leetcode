class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        head.next = removeElements(head.next, val);
        if (head.val == val) return head.next;
        return head;
    }
}