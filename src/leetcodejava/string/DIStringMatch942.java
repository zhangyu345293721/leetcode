package leetcodejava.string;

import org.junit.Test;

/**
 * This is the solution of No. 1002 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/di-string-match
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *  
 * 示例 1：
 *
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 *
 * 输出："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 *
 * 输出："DDI"
 * 输出：[3,2,0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
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
