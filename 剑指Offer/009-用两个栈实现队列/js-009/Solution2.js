
var CQueue = function() {
    this.stack1 = [];
    this.stack2 = [];
};

/**
 * @param {number} value
 * @return {void}
 */
CQueue.prototype.appendTail = function(value) {
    this.stack1.push(value);
};

/**
 * @return {number}
 */
CQueue.prototype.deleteHead = function() {
    if (this.stack2.length) {
        return this.stack2.pop();
    } else if (!this.stack1.length) {
        return -1;
    } else {
        while (this.stack1.length) {
            this.stack2.push(this.stack1.pop());
        }
        return this.stack2.pop();
    }
};
