package leetcodejava.array;

import org.junit.Test;

/**
 * 获取重复次数
 *
 * @author: zhangyu
 */
public class CountRepetitions466 {

    @Test
    public void countRepetitionsTest() {
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;
        int max = getMaxRepetitions(s1, n1, s2, n2);
        System.out.println(max);
    }

    /**
     * 计算重复次数
     *
     * @param s1 字符串1
     * @param n1 重复数量
     * @param s2 字符串2
     * @param n2 重复数量2
     * @return 重复次数
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int s1cnt = 0, s2cnt = 0, index = 0;
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        int L2 = s2.length();
        //Map<Integer, Pair<Integer, Integer>> recall = new HashMap<>();
        int[] recallx = new int[s2.length()];
        int[] recally = new int[s2.length()];
        int preloopx, preloopy, inloopx, inloopy;
        while (true) {
            ++s1cnt;
            for (char c : s1arr) {
                if (c == s2arr[index]) {
                    index++;
                    if (index == L2) {
                        s2cnt++;
                        index = 0;
                    }
                }
            }
            if (n1 == s1cnt) {
                return s2cnt / n2;
            }

            // 存储的value是s1cnt，s1cnt不可能为0。value为0说明recallx[index]是空
            if (recallx[index] != 0) {
                preloopx = recallx[index];
                preloopy = recally[index];
                inloopx = s1cnt - preloopx;
                inloopy = s2cnt - preloopy;
                //inloop = new Pair<>(s1cnt - preloop.getKey(), s2cnt - preloop.getValue());
                break;
            } else {
                //recall.put(index, new Pair<Integer, Integer>(s1cnt, s2cnt));
                recallx[index] = s1cnt;
                recally[index] = s2cnt;
            }
        }

        int ans = preloopy + (n1 - preloopx) / inloopx * inloopy;
        int rest = (n1 - preloopx) % inloopx;

        for (int i = 0; i < rest; i++) {
            for (char c : s1arr) {
                if (c == s2arr[index]) {
                    index++;
                    if (index == L2) {
                        ans++;
                        index = 0;
                    }
                }
            }
        }
        return ans / n2;
    }
}
