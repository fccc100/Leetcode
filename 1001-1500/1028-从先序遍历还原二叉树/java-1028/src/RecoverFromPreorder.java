class RecoverFromPreorder {
    // "1-2--3--4-5--6--7"
    public TreeNode recoverFromPreorder(String traversal) {
        return recoverTree(traversal, "-");
    }

    private TreeNode recoverTree(String s, String splitStr) {
        if (s.length() == 0) return null;

        StringBuilder val = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                val.append(s.charAt(i));
            } else {
                break;
            }
        }
        String nextS = s.substring(val.length());
        TreeNode root = new TreeNode(Integer.valueOf(val.toString()));

        String leftS, rightS;
        int leftSplitIdx = -1;
        int rightSplitIdx = -1;
        int n = nextS.length();
        int len = splitStr.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(nextS.charAt(i))) continue;
            if (i == 0) {
                if (i + len < n && nextS.substring(i, i + len).equals(splitStr) && Character.isDigit(nextS.charAt(i +len))) {
                    leftSplitIdx = i + len;
                }
            } else {
                if (i + len < n && nextS.substring(i, i + len).equals(splitStr) && Character.isDigit(nextS.charAt(i +len)) && Character.isDigit(nextS.charAt(i - 1))) {
                    rightSplitIdx = i;
                }
            }
        }

        leftS = leftSplitIdx > -1 ? rightSplitIdx > -1 ? nextS.substring(leftSplitIdx, rightSplitIdx) : nextS.substring(leftSplitIdx) : "";
        rightS = rightSplitIdx > -1 ? nextS.substring(rightSplitIdx + len) : "";

        root.left = recoverTree(leftS, splitStr + "-");
        root.right = recoverTree(rightS, splitStr + "-");
        return root;
    }
}