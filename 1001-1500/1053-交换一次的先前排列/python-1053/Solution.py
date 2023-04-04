class Solution:
    def prevPermOpt1(self, arr: List[int]) -> List[int]:
        n, last = len(arr), -1
        for i in range(n - 2, -1, -1):
            if arr[i] > arr[i + 1]:
                last = i
                break
        if last == -1: return arr

        max_val, max_idx = -1, -1
        for i in range(last + 1, n):
            if arr[i] < arr[last]:
                if arr[i] > max_val:
                    max_val = arr[i]
                    max_idx = i
        arr[last], arr[max_idx] = arr[max_idx], arr[last]
        return arr
