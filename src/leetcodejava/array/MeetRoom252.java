package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 252 problem in the LeetCode,
 * the website of the problem is as follow:
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 *给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
 *
 *示例 1：
 *
 *输入：intervals = [[0,30],[5,10],[15,20]]
 *输出：false
 *示例 2：
 *
 *输入：intervals = [[7,10],[2,4]]
 *输出：true
 *
 *提示：
 *
 *0 <= intervals.length <= 104
 *intervals[i].length == 2
 *0 <= starti < endi <= 106
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MeetRoom252 {
    @Test
    public void MeetRoomTest() {
        int [] intervals = {{7,10},{2,4}};
        boolean result = canAttendMeetings(intervals);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 字符串相加(直接位运算)
     *
     * @param a 字符串1
     * @param b 字符串2
     * @return 相加字符串
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length < 2) {
            return true;
        } 
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }
}
