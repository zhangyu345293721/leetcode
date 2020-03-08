package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 连续数和
 *
 * @author: zhangyu
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
