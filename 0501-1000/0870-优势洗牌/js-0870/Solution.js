/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var advantageCount = function(nums1, nums2) {
    let n = nums1.length;

    let res = Array(n);
    nums1.sort((a, b) => a - b);
    for (let i = 0; i < n; i++) {
        nums2[i] = [nums2[i], i];
    }

    nums2.sort((a, b) => a[0] - b[0]);
    let i = 0;
    let j = 0;

    let endIndex = n - 1;
    while (i < n) {
        if (nums1[i] > nums2[j][0]) {
            res[nums2[j][1]] = nums1[i];
            i++;
            j++;
        } else {
            res[nums2[endIndex][1]] = nums1[i];
            i++;
            endIndex--;
        }
    }
    return res;
};