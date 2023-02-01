/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var getCommon = function (nums1, nums2) {
    let m = nums1.length
    let n = nums2.length
    let i = 0
    let j = 0
    while (i < m && j < n) {
        if (nums1[i] == nums2[j]) {
            return nums1[i]
        } else if (nums1[i] < nums2[j]) {
            i++
        } else {
            j++
        }
    }
    return -1;
};