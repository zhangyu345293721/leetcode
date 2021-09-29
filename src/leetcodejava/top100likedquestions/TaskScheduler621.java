package leetcodejava.top100likedquestions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No.621 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/task-scheduler/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 * 示例 ：
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *  
 * 提示：
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 * <p>
 * 有一批任务要完成，相同任务有一定冷却时间，求最少完成时间
 * <p>
 * 思路: 优先完成任务数最多的任务，在完成任务数最多的任务后穿插完成其他任务。 分两种情况:
 * <p>
 * 1.次数最多的任务A的cd时间大于其他任务的循环时间，那么最小时间为A全部执行完毕。时间为 (n-1)*间隔时间+n, n为Ad的次数
 * 2.A的cd时间小于其他任务循环完成时间，那么这时候就没有等待的时间了，所有任务都可以完美排期。总时间为len(task_queue)
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class TaskScheduler621 {

    @Test
    public void taskSchedulerTest() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C'};
        int n = 2;
        int result = leastInterval(tasks, n);
        System.out.println(result);
        Assert.assertEquals(result, 8);
    }

    /**
     * 执行任务完最短时间
     *
     * @param tasks 任务数组
     * @param n     规划数
     * @return 数量
     */
    public int leastInterval(char[] tasks, int n) {
        if (n < 1 || tasks.length <= 1) {
            return tasks.length;
        }
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
