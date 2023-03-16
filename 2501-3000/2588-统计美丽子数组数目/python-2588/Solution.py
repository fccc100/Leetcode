class Solution:
    def beautifulSubarrays(self, nums: List[int]) -> int:
        n, res = len(nums), 0
        pre = 0
        pre_map = dict()
        for i in range(n):
            pre = pre ^ nums[i]
            if pre == 0: res += 1
            if pre in pre_map:
                res += pre_map[pre]
                pre_map[pre] += 1
            else:
                pre_map[pre] = 1
        return res
