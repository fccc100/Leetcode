/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function (nums) {
  let n = nums.length;

  let max = 0;
  let res = 0;
  let end = 0;
  for (let i = 0; i < n - 1; i++) {
    max = Math.max(max, i + nums[i]);

    if (i == end) {
      res++;
      end = max;
    }
  }
  return res;
};

//  [2, 3, 1, 1,
//  [2, 3, 0, 1, 4, 4, 5, 6, 7, 8]
//  [2, 4, 4, 4, 8, ]