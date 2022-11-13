/**
 * @param {number[]} nums
 * @return {number[]}
 */
var countSmaller = function (nums) {
    let n = nums.length;
    let res = Array(n).fill(0);

    function mergeSort(nums, l, r) {
        if (l >= r) return;
        let mid = l + (r - l >> 1);
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    function merge(nums, l, mid, r) {
        let temp = Array(r - l + 1);
        for (let i = 0; i < temp.length; i++) {
            temp[i] = Array(2)
            temp[i][0] = nums[i + l][0];
            temp[i][1] = nums[i + l][1];
        }

        let i = l;
        let j = mid + 1;
        for (let k = l; k <= r; k++) {
            if (i > mid) {
                nums[k][0] = temp[j - l][0];
                nums[k][1] = temp[j - l][1];
                j++;
            } else if (j > r) {
                nums[k][0] = temp[i - l][0];
                nums[k][1] = temp[i - l][1];
                res[temp[i - l][1]] += j - mid - 1
                i++;
            } else if (temp[i - l][0] <= temp[j - l][0]) {
                res[temp[i - l][1]] += j - mid - 1
                nums[k][0] = temp[i - l][0];
                nums[k][1] = temp[i - l][1];
                i++;
            } else {
                nums[k][0] = temp[j - l][0];
                nums[k][1] = temp[j - l][1];
                j++;
            }
        }
    }

    let temp = Array(n);
    for (let i = 0; i < n; i++) {
        temp[i] = Array(2)
        temp[i][0] = nums[i];
        temp[i][1] = i;
    }

    mergeSort(temp, 0, n - 1);
    return res;
};