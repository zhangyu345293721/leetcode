package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This is the solution of No. 57 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/insert-interval
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
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
