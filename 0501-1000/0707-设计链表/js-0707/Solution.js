class ListNode {
    constructor(val, next = null) {
        this.next = next;
        this.val = val;
    }
}

var MyLinkedList = function() {
    this.dummyHead = new ListNode(-1);
    this.size = 0;
};

/**
 * @param {number} index
 * @return {number}
 */
MyLinkedList.prototype.get = function(index) {
    if (index >= this.size) return -1;
    return this.__get(this.dummyHead.next, index);
};

MyLinkedList.prototype.__get = function(node, index) {
    if (index == 0) {
        return node.val;
    }

    return this.__get(node.next, index - 1);
};

/**
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtHead = function(val) {
    this.dummyHead.next = new ListNode(val, this.dummyHead.next);
    this.size++;
};

/**
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtTail = function(val) {
    this.__addAtTail(this.dummyHead, val);
};
MyLinkedList.prototype.__addAtTail = function(prevNode, val) {
    if (prevNode.next == null) {
        this.size++;
        prevNode.next = new ListNode(val);
        return;
    }
    this.__addAtTail(prevNode.next, val);
};

/**
 * @param {number} index
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtIndex = function(index, val) {
    if (index > this.size) {
        return;
    }
    if (index < 0) {
        index = 0;
    }
    this.__addAtIndex(this.dummyHead, index, val);
};
MyLinkedList.prototype.__addAtIndex = function(prevNode, index, val) {
    if (index == 0) {
        this.size++;
        prevNode.next = new ListNode(val, prevNode.next);
        return;
    }

    this.__addAtIndex(prevNode.next, index - 1, val);
};

/**
 * @param {number} index
 * @return {void}
 */
MyLinkedList.prototype.deleteAtIndex = function(index) {
    if (index >= this.size) return;
    this.dummyHead.next = this.__deleteAtIndex(this.dummyHead.next, index);
};
MyLinkedList.prototype.__deleteAtIndex = function(node, index) {
    if (index == 0) {
        this.size--;
        return node.next;
    }
    node.next = this.__deleteAtIndex(node.next, index - 1);
    return node;
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */