/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.stack = [];
    this.minStack = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    this.stack.push(x);
    if (!this.minStack.length) {
        this.minStack.push(x);
    } else {
        let top = this.minStack[this.minStack.length - 1];
        if (top < x) {
            this.minStack.push(top);
        } else {
            this.minStack.push(x);
        }
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.stack.pop();
    this.minStack.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    if (!this.stack.length) {
        return -1;
    }
    return this.stack[this.stack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.min = function() {
    if (!this.minStack.length) {
        return -1;
    }
    return this.minStack[this.minStack.length - 1];
};
