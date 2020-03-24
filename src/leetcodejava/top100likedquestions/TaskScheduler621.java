package leetcodejava.top100likedquestions;

import java.util.Arrays;

/**
 * This is the solution of No.621 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/task-scheduler/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 *
 * 示例 ：
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *  
 * 提示：
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
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
