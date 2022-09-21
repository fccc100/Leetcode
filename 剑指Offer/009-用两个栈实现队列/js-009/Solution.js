var CQueue = function() {
    this.stack1 = [];
    this.stack2 = [];
};

/**
 * @param {number} value
 * @return {void}
 */
CQueue.prototype.appendTail = function(value) {
    while (this.stack1.length) {
        this.stack2.push(this.stack1.pop());
    }
    this.stack2.push(value);
    while (this.stack2.length) {
        this.stack1.push(this.stack2.pop());
    }
};

/**
 * @return {number}
 */
CQueue.prototype.deleteHead = function() {
    if (!this.stack1.length) {
        return -1;
    }
    return this.stack1.pop();
};
