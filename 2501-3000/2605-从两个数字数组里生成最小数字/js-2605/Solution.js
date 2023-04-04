/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var minNumber = function (nums1, nums2) {
    let res = 1
    while (true) {
        let s = String(res)
        let flag1 = false
        let flag2 = false
        for (let i = 0; i < s.length; i++) {
            if (nums1.includes(s[i] * 1)) flag1 = true
        }
        for (let i = 0; i < s.length; i++) {
            if (nums2.includes(s[i] * 1)) flag2 = true
        }

        if (flag1 && flag2) return res
        res++
    }
    return -1
};