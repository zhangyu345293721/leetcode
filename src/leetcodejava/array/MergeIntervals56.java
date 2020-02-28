package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 *
 * @author: zhangyu
 */
public class MergeIntervals56 {


    @Test
    public void testMergeIntervals() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr = merge(intervals);
        System.out.println(arr);
    }

    /**
     * 合并区间
     *
     * @param intervals 区间数组
     * @return 合并后的区间
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        if (intervals.length < 1) {
            return intervals;
        }
        int[] curInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= curInterval[1]) {
                curInterval[1] = Math.max(intervals[i][1], curInterval[1]);
            } else {
                list.add(curInterval);
                curInterval = intervals[i];
            }
        }
        list.add(curInterval);
        int[][] ret = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
