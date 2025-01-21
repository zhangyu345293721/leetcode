package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 68 problem in the LeetCode,
 * the website of the problem is as follow:
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FullJustify68 {

    @Test
    public void fullJustifyTest() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
    }

    List<String> result = new ArrayList<>(); // 本题答案列表
    int[] lens; // 记录每个单词长度，方便后续补齐空格操作
    int maxRowLen; // 替代 maxWidth，减少函数传参

    public List<String> fullJustify(String[] words, int maxWidth) {
        maxRowLen = maxWidth;
        int n = words.length;

        // 1. 记录每个单词长度
        lens = new int[n];
        for (int i = 0; i < n; i++) {
            lens[i] = words[i].length();
        }

        // 2. 单词分组，确定哪写单词在同一行
        int rowLen = 0;
        for (int i = 0; i < n; i++) {
            int start = i;
            while (i < n && rowLen + lens[i] <= maxRowLen) {
                rowLen += (lens[i] + 1);
                i++;
            }
            addResult(words, start, --i); // [start, end]对应的单词组成一行，加入答案
            rowLen = 0;
        }
        return result;
    }

    /**
     * add result to string buffer
     */
    private void addResult(String[] words, int start, int end) {
        StringBuilder sb = new StringBuilder();
        // 情况一：一行只有一个单词，直接空格补齐
        if (start == end) {
            sb.append(words[start]);
            int space = maxRowLen - lens[start];
            for (int j = 0; j < space; j++) {
                sb.append(" ");
            }
            result.add(sb.toString());
            return;
        }

        // 情况二：如果是最后一行，左对齐，即单词间一个空格，最后空格补齐
        if (end == words.length - 1) {
            int space = maxRowLen;
            for (int i = start; i < end; i++) {
                sb.append(words[i]).append(" ");
                space -= (lens[i] + 1);
            }
            sb.append(words[end]);
            space -= lens[end];
            for (int j = 0; j < space; j++) {
                sb.append(" ");
            }
            result.add(sb.toString());
            return;
        }

        // 情况三：一般情况
        // 思路：统计要插入的总空格数spaceAll 
        //      -> 计算单词间能够平分的空格数spaceMean
        //      -> 计算剩余空格数spaceLast，并从前往后分配
        // 总空格数
        int spaceAll = maxRowLen;
        for (int i = start; i <= end; i++) {
            spaceAll -= lens[i];
        }
        // 平均空格数
        int spaceMean = spaceAll / (end - start);
        // 剩余空格数
        int spaceLast = spaceAll - spaceMean * (end - start);
        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            // 在每个单词后面插入平均空格数
            for (int j = 0; j < spaceMean; j++) {
                sb.append(" ");
            }
            // 如果有剩余空格数，插一个
            if (spaceLast > 0) {
                sb.append(" ");
                spaceLast--;
            }
        }
        sb.append(words[end]);
        result.add(sb.toString());
    }
}
