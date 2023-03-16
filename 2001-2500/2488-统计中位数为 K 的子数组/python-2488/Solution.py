class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        n, k_idx = len(nums), -1
        for i in range(n):
            if nums[i] == k:
                k_idx = i
                break

        min, max, res, l_map = 0, 0, 1, dict()
        for i in range(k_idx - 1, -1, -1):
            if nums[i] > k:
                max += 1
            else:
                min += 1

            key = max - min
            if key in l_map:
                l_map[key] = l_map[key] + 1
            else:
                l_map[key] = 1
            if min == max or min == max - 1:
                res += 1
        min, max = 0, 0
        for i in range(k_idx + 1, n):
            if nums[i] > k:
                max += 1
            else:
                min += 1
            key = max - min
            if min == max or min == max - 1:
                res += 1
            if -key in l_map:
                res += l_map[-key]
            if (1 - key) in l_map:
                res += l_map[1 - key]
        return res