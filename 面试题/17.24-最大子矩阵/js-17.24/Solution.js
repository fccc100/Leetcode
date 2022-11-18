// 返回的数组依次是最大子矩阵和，子矩阵左上角及右下角坐标
function getMaxMatrix(matrix) {
    let m = matrix.length;
    if (m == 0) return [];
    let n = matrix[0].length;

    let presum = Array(m + 1);
    for (let i = 0; i <= m; i++) {
        presum[i] = Array(n + 1).fill(0);
    }
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            presum[i][j] = presum[i - 1][j] + matrix[i - 1][j - 1];
        }
    }

    let maxSum = -Infinity;
    let x1 = 0;
    let y1 = 0;
    let x2 = 0;
    let y2 = 0;
    for (let i = 0; i < m; i++) {
        for (let j = i; j < m; j++) {

            let curNums = Array(n).fill(0);
            for (let k = 0; k < n; k++) {
                curNums[k] = presum[j + 1][k + 1] - presum[i][k + 1];
            }

            let max = maxSubarraySum(curNums);
            if (max[0] > maxSum) {
                maxSum = max[0];
                x1 = i;
                y1 = max[1];
                x2 = j;
                y2 = max[2];
            }
        }
    }

    return [maxSum, x1, y1, x2, y2];
}

// 一维数组最大子数组和及区间
function maxSubarraySum(nums) {
    let n = nums.length;

    let start = 0;
    let max = nums[0];
    let presum = nums[0];
    let res = Array(3).fill(0);

    for (let i = 1; i < n; i++) {
        if (presum > 0) {
            presum += nums[i];
        } else {
            presum = nums[i];
            start = i;
        }
        if (presum > max) {
            max = presum;
            res[1] = start;
            res[2] = i;
        }
    }
    res[0] = max;
    return res;
}