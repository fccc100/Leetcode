class MaxAbsValExpr {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length;

        int max1 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE, min2 = Integer.MAX_VALUE;
        int max3 = Integer.MIN_VALUE, max33 = Integer.MIN_VALUE;
        int max4 = Integer.MIN_VALUE, max44 = Integer.MIN_VALUE;
        int max5 = Integer.MIN_VALUE, max55 = Integer.MIN_VALUE;
        int max6 = Integer.MIN_VALUE, max66 = Integer.MIN_VALUE;
        int max7 = Integer.MIN_VALUE, max77 = Integer.MIN_VALUE;
        int max8 = Integer.MIN_VALUE, max88 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int x1 = arr1[i], x2 = arr2[i];

            max1 = Math.max(max1, x1 + x2 + i);
            min1 = Math.min(min1, x1 + x2 + i);

            max2 = Math.max(max2, x1 + x2 - i);
            min2 = Math.min(min2, x1 + x2 - i);

            max3 = Math.max(max3, x1 - x2 + i);
            max33 = Math.max(max33, x2 - x1 - i);

            max4 = Math.max(max4, x1 - x2 - i);
            max44 = Math.max(max44, x2 - x1 + i);

            max5 = Math.max(max5, -x1 + x2 + i);
            max55 = Math.max(max55, x1 - x2 - i);

            max6 = Math.max(max6, -x1 + x2 - i);
            max66 = Math.max(max66, x1 - x2 + i);

            max7 = Math.max(max7, -x1 - x2 + i);
            max77 = Math.max(max77, x1 + x2 - i);

            max8 = Math.max(max8, -x1 - x2 - i);
            max88 = Math.max(max88, x1 + x2 + i);
        }

        int res = Integer.MIN_VALUE;
        res = Math.max(res, max1 - min1);
        res = Math.max(res, max2 - min2);
        res = Math.max(res, max3 + max33);
        res = Math.max(res, max4 + max44);
        res = Math.max(res, max5 + max55);
        res = Math.max(res, max6 + max66);
        res = Math.max(res, max7 + max77);
        res = Math.max(res, max8 + max88);
        return res;
    }
}