// 2.位运算
// 先所有数字异或，异或结果为 a ^ b
var singleNumbers = function (nums) {
    let n = nums.length;

    // c的结果就是a ^ b
    let c = nums[0];
    for (let i = 1; i < n; i++) {
        c ^= nums[i];
    }

    // 把所有数字分为两组，相同的数字放在同一组，并且把a b分别分到两组中去再进行异或，得到的结果就分别是a、b
    // 怎么分到不同的组中
    // 从a ^ b的结果中，找到一个是1的位数，根据这一位是0还是1来分

    // 先找到第一个是1的位
    let p = 1;
    while ((p & c) == 0) {
        p = p << 1;
    }

    let a = 0, b = 0;
    for (let i = 0; i < n; i++) {
        if ((p & nums[i]) != 0) {
            a ^= nums[i];
        } else {
            b ^= nums[i];
        }
    }

    return [a, b];
}