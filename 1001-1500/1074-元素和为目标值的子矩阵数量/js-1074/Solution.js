// 求二维矩阵中和为target的子矩阵的个数
function numSubmatrixSumTarget(matrix, target) {
    let m = matrix.length;
    if (m == 0) return 0;
    let n = matrix[0].length;
    let res = 0;

    let presum = Array(m + 1);
    for (let i = 0; i <= m; i++) {
        presum[i] = Array(n + 1).fill(0);
    }
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            presum[i][j] = presum[i - 1][j] + matrix[i - 1][j - 1];
        }
    }

    for (let i = 0; i < m; i++) {
        for (let j = i; j < m; j++) {

            let curNums = Array(n).fill(0);
            for (let k = 0; k < n; k++) {
                curNums[k] = presum[j + 1][k + 1] - presum[i][k + 1];
            }

            res += subarraySum(curNums, target);
        }
    }

    return res;
}

// nums中和为k的子数组个数
function subarraySum(nums, k) {
    let n = nums.length;
    let presum = Array(n + 1).fill(0);

    let res = 0;
    let map = new Map();
    for (let i = 1; i <= n; i++) {
        presum[i] = presum[i - 1] + nums[i - 1];
        if (presum[i] == k) {
            res++;
        }
        if (map.has(presum[i] - k)) {
            res += map.get(presum[i] - k);
        }

        map.set(presum[i], map.has(presum[i]) ? map.get(presum[i]) + 1 : 1);
    }

    return res;
}