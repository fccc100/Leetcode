class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        n, res = len(changed), []
        if n % 2 == 1:
            return []
        changed.sort()
        nums_map = dict()
        for x in changed:
            if x in nums_map:
                nums_map[x] = nums_map[x] + 1
            else:
                nums_map[x] = 1
        for x in changed:
            if x in nums_map:
                nums_map[x] = nums_map[x] - 1
                if nums_map[x] == 0:
                    nums_map.pop(x)
                if (x * 2) in nums_map:
                    res.append(x)
                    nums_map[x * 2] = nums_map[x * 2] - 1
                    if nums_map[x * 2] == 0:
                        nums_map.pop(x * 2)
        if len(res) == n / 2:
            return res
        return []
