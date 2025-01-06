package leetcodejava.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * ==========================================================================================================
 * meeting room number
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AddTwoNumbers2 {
    @Test
    public void addTwoNumbers() {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int result = minMeetingRooms(intervals);
        System.out.println("最少会议室数量: " +result);
        System.out.println(result);
        Assert.assertEquals(result, 2);
    }
    
    /**
     * 两个链表相加
     *
     * @param intervals interval array
     * @return 结果
     */
     public static int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // 按照会议的开始时间排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 最小堆，按会议的结束时间排序
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 添加第一个会议的结束时间
        minHeap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // 如果当前会议的开始时间 >= 堆顶的结束时间，弹出堆顶
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            // 添加当前会议的结束时间
            minHeap.add(intervals[i][1]);
        }
        // 堆的大小就是所需的最少会议室数
        return minHeap.size();
    }
}
