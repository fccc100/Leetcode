class MyLinkedList {

    class ListNode {
        private ListNode next;
        private int val;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode dummyHead;
    private int size;
    public MyLinkedList() {
        dummyHead = new ListNode(-1);
        size = 0;
    }

    public int get(int index) {
        if (index >= size) return -1;
        return this.get(this.dummyHead.next, index);
    }
    private int get(ListNode node, int index) {
        if (index == 0) {
            return node.val;
        }
        return get(node.next, index - 1);
    }

    public void addAtHead(int val) {
        size++;
        dummyHead.next = new ListNode(val, dummyHead.next);
    }

    public void addAtTail(int val) {
        addAtTail(dummyHead, val);
    }
    private void addAtTail(ListNode prevNode, int val) {
        if (prevNode.next == null) {
            size++;
            prevNode.next = new ListNode(val);
            return;
        }
        addAtTail(prevNode.next, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        addAtIndex(dummyHead, index, val);
    }
    private void addAtIndex(ListNode prevNode, int index, int val) {
        if (index == 0) {
            size++;
            prevNode.next = new ListNode(val, prevNode.next);
            return;
        }
        addAtIndex(prevNode.next, index - 1, val);
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        dummyHead.next = deleteAtIndex(dummyHead.next, index);
    }
    private ListNode  deleteAtIndex(ListNode node, int index) {
        if (index == 0) {
            size--;
            return node.next;
        }

        node.next = deleteAtIndex(node.next, index - 1);
        return node;
    }
}
