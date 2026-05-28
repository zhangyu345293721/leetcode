package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * This is the solution of No. 1986 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/array-partition-i/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你被安排了 n 个任务。任务需要花费的时间用长度为 n 的整数数组 tasks 表示，第 i 个任务需要花费 tasks[i] 小时完成。一个 工作时间段 中，你可以 至多 连续工作 sessionTime 个小时，然后休息一会儿。
 * 你需要按照如下条件完成给定任务：
 * 如果你在某一个时间段开始一个任务，你需要在 同一个 时间段完成它。
 * 完成一个任务后，你可以 立马 开始一个新的任务。
 * 你可以按 任意顺序 完成任务。
 * 给你 tasks 和 sessionTime ，请你按照上述要求，返回完成所有任务所需要的 最少 数目的 工作时间段 。
 *
 * 测试数据保证 sessionTime 大于等于 tasks[i] 中的 最大值 。
 *
 * 示例 1：
 *
 * 输入：tasks = [1,2,3], sessionTime = 3
 * 输出：2
 * 解释：你可以在两个工作时间段内完成所有任务。
 *- 第一个工作时间段：完成第一和第二个任务，花费 1 + 2 = 3 小时。
 *- 第二个工作时间段：完成第三个任务，花费 3 小时。
 * 示例 2：
 *
 * 输入：tasks = [3,1,3,1,1], sessionTime = 8
 * 输出：2
 * 解释：你可以在两个工作时间段内完成所有任务。
 *- 第一个工作时间段：完成除了最后一个任务以外的所有任务，花费 3 + 1 + 3 + 1 = 8 小时。
 *- 第二个工作时间段，完成最后一个任务，花费 1 小时。
 *
 *
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ArrayPartition1986 {

    @Test
    public void arrayPartitionTest() {
        int[] tasks = {1,2,3};
        int sessionTime = 3;
        minSessions(tasks);
        System.out.println(sum);
        Assert.assertEquals(res, 2);
    }

    int res;  
    public int minSessions(int[] a, int t) {
        int [] group = new int[a.length];  
        res = Integer.MAX_VALUE;
        // 数组进行排序
        // Arrays.sort(a);
        searchHelper(0, group, 0, a, t);
        return res;
    }

    /**
     * 搜索帮助方法
     * 
     * @idx : 分桶的下标
     * @group: a数组个桶
     * @pos: 数组a的下标
     * @a:需要放入group中的元素
     * @t:桶的大小
     */
    public void searchHelper(int idx, int[] group, int pos, int[] a, int t) {
        // 剪枝
        if (idx >= res){
            return;
        } 
        
        // 终止条件：走到 a数组长度 说明全部处理完
        if (pos == a.length) {
            res = Math.min(res, idx);
            return;
        }

        // 尝试放入已有的组
        for (int i = 0; i < idx; i++) {
            if (group[i] + a[pos] <= t) {
                group[i] += a[pos];
                searchHelper(idx, group, pos + 1, a, t);  
                group[i] -= a[pos];
            }
            // 剪枝操作
            if(group[i] <= 0) {
                break;
            }
        }

        // 新开一组
        group[idx] = a[pos];
        searchHelper(idx + 1, group, pos + 1, a, t);  
        group[idx] = 0;  
    }
}
