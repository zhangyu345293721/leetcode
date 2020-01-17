package leetcodejava.string;

import org.junit.Test;

/**
 * 编排字符串的顺序
 *
 * @author: zhangyu
 */
public class DIStringMatch942 {


    @Test
    public void testDIStringMatch() {
        String s = "DDI";
        int[] arr = diStringMatch(s);
        System.out.println(arr);
    }

    /**
     * 按照要求编排字符串
     *
     * @param S 字符串
     * @return 数组
     */
    public int[] diStringMatch(String S) {
        int N = S.length();
        int l = 0;
        int h = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                ans[i] = l++;
            } else {
                ans[i] = h--;
            }
        }
        ans[N] = l;
        return ans;
    }
}
