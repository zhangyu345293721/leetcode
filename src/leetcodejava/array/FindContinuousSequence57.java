package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This is the solution of No. offer57 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindContinuousSequence57 {

    @Test
    public void testFindContinuousSequence() {
        int target = 15;
        int[][] nums = findContinuousSequence1(target);
        System.out.println(nums);
    }

    /**
     * 连续数组和为固定值
     *
     * @param target 固定值
     * @return 连续数组
     */
    public int[][] findContinuousSequence1(int target) {
        List<int[]> result = new ArrayList<>();
        int end = target / 2 + 1;
        for (int i = 1; i < end; i++) {
            for (int j = i + 1; j < end + 1; j++) {
                int total = (i + j) * (j - i + 1) / 2;
                if (target == total) {
                    result.add(IntStream.range(i, j + 1).toArray());
                    break;
                }
            }
        }
        return result.stream().toArray(int[][]::new);
    }

    /**
     * 连续数组和为固定值
     *
     * @param target 固定值
     * @return 连续数组
     */
    public int[][] findContinuousSequence2(int target) {
        int left = 1;
        int right = 2;
        List<int[]> result = new ArrayList<>();
        while (left < right) {
            int total = (left + right) * (right - left + 1) / 2;
            if (total > target) {
                left++;
            } else if (total < target) {
                right++;
            } else {
                result.add(IntStream.range(left, right + 1).toArray());
                left++;
                right++;
            }
        }
        return result.stream().toArray(int[][]::new);
    }
}
