/**
 * @param {number[][]} nums1
 * @param {number[][]} nums2
 * @return {number[][]}
 */
var mergeArrays = function (nums1, nums2) {
    let m = nums1.length
    let n = nums2.length
    let map = new Map()
    for (let i = 0; i < m; i++) {
        let id = nums1[i][0]
        let v = nums1[i][1]
        if (!map.has(id)) {
            map.set(id, 0)
        }
        map.set(id, map.get(id) + v)
    }
    for (let i = 0; i < n; i++) {
        let id = nums2[i][0]
        let v = nums2[i][1]
        if (!map.has(id)) {
            map.set(id, 0)
        }
        map.set(id, map.get(id) + v)
    }
    let res = []
    for (let entry of map.entries()) {
        res.push(entry)
    }
    res.sort((a, b) => a[0] - b[0])
    return res
};