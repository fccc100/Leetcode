class CountStudents {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int[] cnt = new int[2];
        for (int i = 0; i < n; i++) {
            cnt[students[i]]++;
        }

        for (int i = 0; i < sandwiches.length; i++) {
            if (cnt[sandwiches[i]] > 0) {
                cnt[sandwiches[i]]--;
            } else {
                break;
            }
        }
        return cnt[0] + cnt[1];
    }
}