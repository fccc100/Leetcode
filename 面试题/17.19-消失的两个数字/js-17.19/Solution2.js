var missingTwo = function (nums) {
    let n = nums.length + 2;

    // 求出数组中所有数字的异或
    let c = nums[0];
    for (let i = 1; i < nums.length; i++) {
        c ^= nums[i];
    }

    // 再与1 - n每个数字异或
    for (let i = 1; i <= n; i++) {
        c ^= i;
    }

    // 求最后一位1
    let p = 1;
    while ((p & c) == 0) {
        p <<= 1;
    }

    let a = 0, b = 0;
    for (let i = 0; i < nums.length; i++) {
        if ((nums[i] & p) != 0) {
            a ^= nums[i];
        } else {
            b ^= nums[i];
        }
    }

    for (let i = 1; i <= n; i++) {
        if ((i & p) != 0) {
            a ^= i;
        } else {
            b ^= i;
        }
    }
    return [a, b];
}