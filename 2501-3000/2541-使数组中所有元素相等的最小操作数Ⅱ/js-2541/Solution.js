/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number} k
 * @return {number}
 */
var minOperations = function (nums1, nums2, k) {
    let m = nums1.length
    let n = nums2.length
    let add = 0
    let de = 0
    for (let i = 0; i < n; i++) {
        if (nums1[i] == nums2[i]) continue

        if (nums1[i] > nums2[i]) {
            let diff = nums1[i] - nums2[i]
            if (diff % k != 0) return -1
            de += diff / k
        }
        if (nums1[i] < nums2[i]) {
            let diff = nums2[i] - nums1[i]
            if (diff % k  != 0) return -1
            add += diff / k
        }
    }
    return add == de ? add : -1
};