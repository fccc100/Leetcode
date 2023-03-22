
/**
 * @param {number[]} ranks
 * @param {number} cars
 * @return {number}
 */
var repairCars = function (ranks, cars) {
    let n = ranks.length
    let max = ranks[0]
    for (let i = 0; i < n; i++) {
        max = Math.max(max, ranks[i])
    }

    let l = 1
    let r = max * cars * cars
    while (l < r) {
        let mid = Math.floor(l + ((r - l) / 2))
        if (check(ranks, cars, mid)) {
            r = mid
        } else {
            l = mid + 1
        }
    }
    return l
};

function check(nums, cars, mid) {
    let n = nums.length
    let res = 0
    for (let i = 0; i < n; i++) {
        let cnt = mid / nums[i]
        let c = Math.floor(Math.sqrt(cnt))
        res += c
    }

    return res >= cars
}