package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.207 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/course-schedule
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，
 * 表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 *  
 * 提示：
 * <p>
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CourseSchedule207 {

    @Test
    public void courseScheduleTest() {
        int[][] arr = {{1, 0}, {3, 1}, {2, 0}, {3, 2}};
        boolean result = canFinish(4, arr);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    /**
     * 是否能够完成拓扑排序
     *
     * @param numCourses    n门课程
     * @param prerequisites 需求数组
     * @return 结果集
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length < 1) {
            return true;
        }
        int[] input = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        // 统计节点的入度
        for (int[] edge : prerequisites) {
            input[edge[0]]++;
        }
        // 将入度为0的点入队
        for (int i = 0; i < numCourses; i++) {
            if (input[i] == 0) {
                queue.offer(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            idx++;
            // 修改节点入度
            for (int[] edge : prerequisites) {
                int id = edge[1];
                int inputId = edge[0];
                if (id == temp) {
                    input[inputId]--;
                    if (input[inputId] == 0) {
                        queue.offer(inputId);
                    }
                }
            }
        }
        return idx == numCourses;
    }
}
