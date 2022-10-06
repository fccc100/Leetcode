class ThreeEqualParts {
    // 首先计算出1的个数
    // 1的个数不是3的倍数，直接返回[-1, -1]
    // 分成三部分，第三部分的末尾0的个数是确定的记为count，这意味着每一个部分末尾的0的个数都是count
    // 知道了每一部分的末尾0的个数，每一部分的结尾索引也就可以求出来了
    // 通过上述索引就可以求得每一部分的具体值
    // 比较去掉前导零是否相等
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }

        int firstIndex = -1;
        int secondIndex = -1;
        int oneCnt = sum / 3;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                if (cnt == oneCnt * 1) {
                    firstIndex = i;
                }
                if (cnt == oneCnt * 2) {
                    secondIndex = i + 1;
                    break;
                }
            }
        }

        int tailZero = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 1) {
                break;
            }
            tailZero++;
        }
        for (int i = tailZero;  i > 0; i--) {
            firstIndex++;
            if (arr[firstIndex] != 0) {
                return new int[]{-1, -1};
            }
            if (arr[secondIndex] != 0) {
                return new int[]{-1, -1};
            }
            secondIndex++;
        }
        StringBuilder s1 = new StringBuilder();
        boolean hasOne = false;
        int i;
        for (i = 0; i <= firstIndex; i++) {
            if (!hasOne && arr[i] == 0) {
                continue;
            }
            if (arr[i] == 1) {
                hasOne = true;
            }
            s1.append(arr[i]);
        }
        hasOne = false;
        StringBuilder s2 = new StringBuilder();
        for (; i < secondIndex; i++) {
            if (!hasOne && arr[i] == 0) {
                continue;
            }
            if (arr[i] == 1) {
                hasOne = true;
            }
            s2.append(arr[i]);
        }
        hasOne = false;
        StringBuilder s3 = new StringBuilder();
        for (; i < n; i++) {
            if (!hasOne && arr[i] == 0) {
                continue;
            }

            if (arr[i] == 1) {
                hasOne = true;
            }
            s3.append(arr[i]);
        }

        if (s1.toString().equals(s2.toString()) && s1.toString().equals(s3.toString())) {
            return new int[]{firstIndex, secondIndex};
        }
        return new int[]{-1, -1};
    }
}