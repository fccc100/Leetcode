import com.sun.tools.javac.util.List;

import java.util.ArrayList;

class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;

        // rowWords[i]表示第i行存放的单词
        ArrayList<ArrayList<String>> rowWords = new ArrayList<>();

        // rowCharCnt[i]表示第i行的字符个数
        ArrayList<Integer> rowCharCnt = new ArrayList<>();

        int curRow = 0;
        rowWords.add(new ArrayList<>());
        int totalChar = 0;
        for (int i = 0; i < n; i++) {
            String curStr = words[i];

            if (totalChar + curStr.length() + rowWords.get(curRow).size() > maxWidth) {
                curRow++;
                rowWords.add(new ArrayList<>());
                rowWords.get(curRow).add(curStr);
                totalChar = curStr.length();

            } else {
                rowWords.get(curRow).add(curStr);
                totalChar += curStr.length();
            }
        }

        for (int i = 0; i < rowWords.size(); i++) {
            int curLen = 0;
            for (int j = 0; j < rowWords.get(i).size(); j++) {
                curLen += rowWords.get(i).get(j).length();
            }
            rowCharCnt.add(curLen);
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < rowWords.size() - 1; i++) {
            ArrayList<String> curRowList = rowWords.get(i);
            int wordCnt = curRowList.size();
            int spaceCnt = maxWidth - rowCharCnt.get(i);

            if (wordCnt == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(curRowList.get(0));
                while (spaceCnt > 0) {
                    sb.append(" ");
                    spaceCnt--;
                }
                res.add(sb.toString());
                continue;
            }

            int avgSpaceCnt = spaceCnt / (wordCnt - 1);
            int leftSpaceCnt = spaceCnt % (wordCnt - 1);

            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < curRowList.size(); j++) {
                String str = curRowList.get(j);

                cur.append(str);
                if (j == curRowList.size() - 1) break;
                for (int k = 0; k < avgSpaceCnt; k++) {
                    cur.append(" ");
                }
                while (leftSpaceCnt > 0) {
                    cur.append(" ");
                    leftSpaceCnt--;
                    break;
                }
            }
            res.add(cur.toString());
        }

        ArrayList<String> lastRow = rowWords.get(rowWords.size() - 1);
        StringBuilder last = new StringBuilder();
        for (int i = 0; i < lastRow.size(); i++) {
            last.append(lastRow.get(i));
            if (i != lastRow.size() - 1) {
                last.append(" ");
            }
        }
        while (last.length() < maxWidth) {
            last.append(" ");
        }
        res.add(last.toString());

        return res;
    }
}