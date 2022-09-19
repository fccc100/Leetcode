/**
 * @param {number[]} nums
 * @return {number[]}
 */
var frequencySort = function(nums) {
    let n = nums.length;

    let map = new Map();
    for (let i = 0; i < n; i++) {
        if (!map.has(nums[i])) {
            map.set(nums[i], 1);
        } else {
            map.set(nums[i], map.get(nums[i]) + 1);
        }
    }

    let pairs = [];
    for (let entry of map) {
        pairs.push(entry);
    }

    pairs.sort((a, b) => {
        if (a[1] < b[1]) {
            return -1;
        } else if (a[1] == b[1]) {
            return b[0] - a[0];
        } else {
            return 1;
        }
    })

    let res = [];
    for (let i = 0; i < pairs.length; i++) {
        for (let j = 0; j < pairs[i][1]; j++) {
            res.push(pairs[i][0]);
        }
    }
    return res;
};