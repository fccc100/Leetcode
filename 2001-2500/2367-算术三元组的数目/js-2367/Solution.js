var arithmeticTriplets = function (nums, diff) {
    let set = new Set();
    for (let i = 0; i < nums.length; i++) {
        set.add(nums[i]);
    }

    let res = 0;
    for (let i = 0; i < nums.length; i++) {
        if (set.has(nums[i] - diff) && set.has(nums[i] + diff)) {
            res++;
        }
    }
    return res;
}