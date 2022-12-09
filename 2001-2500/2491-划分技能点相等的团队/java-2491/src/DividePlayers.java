import java.util.Arrays;

class DividePlayers {
    public long dividePlayers(int[] skill) {
        int n = skill.length;

        Arrays.sort(skill);
        if (n % 2 == 1) return -1;

        long res = 0;
        int l = 0;
        int r = n - 1;

        int sum = skill[l] + skill[r];
        while (l < r) {
            int ll = skill[l];
            int rr = skill[r];

            if (ll + rr != sum) {
                return -1;
            }
            res += (long)(ll * rr);
            l++;
            r--;
        }
        return res;
    }
}