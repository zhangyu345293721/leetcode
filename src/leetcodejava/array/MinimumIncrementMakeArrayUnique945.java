package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No.945 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * <p>
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 * <p>
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MinimumIncrementMakeArrayUnique945 {
    @Test
    public void minimumIncrementMakeArrayUniqueTest() {
        int[] A = {3, 2, 1, 2, 1, 7};
        int i = minIncrementForUnique(A);
        System.out.println(i);
    }

    /**
     * 数组A最小不重复
     *
     * @param A 数组A
     * @return 步数
     */
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < A.length) {
            if (set.contains(A[i])) {
                count++;
                A[i]++;
            } else {
                set.add(A[i]);
                i++;
            }
        }
        return count;
    }
}
