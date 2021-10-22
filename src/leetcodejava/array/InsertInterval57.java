package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No.57 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/happy-number
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *  
 * <p>
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class InsertInterval57 {

    @Test
    public void insertIntervalTest() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = insert2(intervals, newInterval);
        Assert.assertArrayEquals(result[0], new int[]{1, 5});
    }

    /**
     * 插入新区间合并之后
     *
     * @param intervals   区间
     * @param newInterval 新区间
     * @return 新区间
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        int length = intervals.length;
        int[][] newArr = new int[length + 1][];
        int index = 0;
        for (int[] interval : intervals) {
            newArr[index++] = interval;
        }
        newArr[index] = newInterval;
        Arrays.sort(newArr, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int[] cur = newArr[0];
        for (int i = 1; i < length + 1; i++) {
            if (cur[1] < newArr[i][0]) {
                list.add(cur);
                cur = newArr[i];
            } else {
                int last = Math.max(cur[1], newArr[i][1]);
                cur = new int[]{cur[0], last};
            }
        }
        list.add(cur);
        int[][] result = new int[list.size()][];
        int i = 0;
        for (int[] e : list) {
            result[i++] = e;
        }
        return result;
    }

    /**
     * 插入新区间合并之后
     *
     * @param intervals   区间
     * @param newInterval 新区间
     * @return 新区间
     */
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> intervalList = new ArrayList();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    intervalList.add(new int[]{left, right});
                    placed = true;
                }
                intervalList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                intervalList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            intervalList.add(new int[]{left, right});
        }
        int[][] res = new int[intervalList.size()][];
        for (int i = 0; i < intervalList.size(); ++i) {
            res[i] = intervalList.get(i);
        }
        return res;
    }
}
