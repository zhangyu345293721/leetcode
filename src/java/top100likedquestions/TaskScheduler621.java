package java.top100likedquestions;

import java.util.Arrays;

/**
 * 任务规划问题
 *
 * @author: zhangyu
 */
public class TaskScheduler621 {

    /**
     * 任务规划
     *
     * @param tasks 任务数组
     * @param n     规划数
     * @return 数量
     */
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int maxHeight = map[25] - 1;
        int maxSlots = maxHeight * n;
        for (int i = 24; i >= 0 && map[i] != 0; i--) {
            maxSlots -= Math.min(maxHeight, map[i]);
        }
        return Math.max(tasks.length + maxSlots, tasks.length);
    }
}
