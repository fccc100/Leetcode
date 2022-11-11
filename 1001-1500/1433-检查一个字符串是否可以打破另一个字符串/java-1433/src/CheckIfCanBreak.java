import java.util.Arrays;

class CheckIfCanBreak {
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length();

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean isS1BreakS2 = true;
        boolean isS2BreakS1 = true;
        for (int i = 0; i < n; i++) {
            if (arr1[i] < arr2[i]) {
                isS1BreakS2 = false;
            }
            if (arr2[i] < arr1[i]) {
                isS2BreakS1 = false;
            }
        }
        return isS1BreakS2 || isS2BreakS1;
    }
}