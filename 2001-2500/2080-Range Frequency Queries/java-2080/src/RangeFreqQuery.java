import java.util.ArrayList;
import java.util.List;

class RangeFreqQuery {
    List<Integer> [] idxs;
    public RangeFreqQuery(int[] arr) {
        int n = arr.length;
        idxs = new List[10001];
        for (int i = 0; i < idxs.length; i++) {
            idxs[i] = new ArrayList();
        }
        for (int i = 0; i < n; i++) {
            idxs[arr[i]].add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> cur = idxs[value];
        // 大于等于left的最小值
        int l = lower(cur, left);
        // 小于等于right的最大值
        int r = upper(cur, right);
        if (l > r) return 0;
        return r - l + 1;
    }

    private int lower(List<Integer> nums, int target) {
        int l = 0;
        int r = nums.size();
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (nums.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    private int upper(List<Integer> nums, int target) {
        int l = -1;
        int r = nums.size() - 1;
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (nums.get(mid) <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */