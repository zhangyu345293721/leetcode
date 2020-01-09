package leetcodejava.top100likedquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 合并区间
 *
 * @author: zhangyu
 */
public class MergeIntervals {

    /**
     * 合并区间
     *
     * @param intervals 区间数组
     * @return 合并后的区间
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                final int time1 = entry1[0];
                final int time2 = entry2[0];
                return time1 - time2;
            }
        });
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0 || intervals.length == 1) {
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
