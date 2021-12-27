package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No. 210 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/course-schedule-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 * <p>
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class CourseSchedule210 {

    @Test
    public void courseScheduleTest() {
        int[][] arr = {{1, 0}, {3, 1}, {2, 0}, {3, 2}};
        int[] result = findOrder2(4, arr);
        System.out.println(Arrays.toString(result));
        Assert.assertEquals(result[0], 0);
    }

    /**
     * 我们先记录每个节点的入度，以及使用 map 记录每个节点所能到达的其他节点
     * 当某个节点的入度为 0，表示没有节点指向它，即该课程不需要先修其他课程，那么我们就可以从 该课程 出发
     * 然后我们将入度为 0 的节点存储进队列中，将它和它所能到达的节点 next 的通路断开，即 next 的入度 -1，
     * 当减为 0 的时候，表示入度为 0，那么添加进队列中
     *
     * @param numCourses    课程数量
     * @param prerequisites 课程关系二维数组
     * @return 数组链表
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //存储某个节点能够到达的其他节点集合
        List<Integer>[] lists = new ArrayList[numCourses];
        //记录某个节点的入度
        int[] points = new int[numCourses];
        for (int[] p : prerequisites) {
            /**
             [3, 5] 表示学习 3 之前需要先学习 5
             那么对于 3 来说， 5 指向 3，即 3 的入度 + 1
             而 5 能到达的节点集合需要增加 3 这个节点
             */
            points[p[0]]++;
            if (lists[p[1]] == null) {
                lists[p[1]] = new ArrayList<>();
            }
            lists[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        //找到入度为 0 的节点
        for (int i = 0; i < numCourses; i++) {
            //入度为 0，添加到队列中
            if (points[i] == 0) {
                queue.add(i);
            }
        }
        //记录遍历的课程顺序
        int[] res = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            /**
             首先我们应该明确这么一点，在队列中的元素都是 0 入度的课程，即没有需要前修的课程就可以直接学习
             那么我们遍历到该课程，假设学习完，那么它指向的课程入度都需要 -1，当它指向的某个课程入度为 0 的时候，同时也需要将该课程添加到队列中
             */
            while (size-- > 0) {
                int p = queue.poll();
                res[idx++] = p;
                List<Integer> list = lists[p];
                if (list == null) {
                    continue;
                }
                for (int val : list) {
                    points[val]--;
                    if (points[val] == 0) {
                        queue.add(val);
                    }
                }
            }
        }
        //idx == numCourses 意味着全部课程都访问过了，即最终都能够满足 0 入度的条件，即全部能够学习完成
        return idx == numCourses ? res : new int[0];
    }


    /**
     * 我们先记录每个节点的入度，以及使用 map 记录每个节点所能到达的其他节点
     * 当某个节点的入度为 0，表示没有节点指向它，即该课程不需要先修其他课程，那么我们就可以从 该课程 出发
     * 然后我们将入度为 0 的节点存储进队列中，将它和它所能到达的节点 next 的通路断开，即 next 的入度 -1，
     * 当减为 0 的时候，表示入度为 0，那么添加进队列中
     *
     * @param numCourses    课程数量
     * @param prerequisites 课程关系二维数组
     * @return 数组链表
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        // 实体id和实体
        Map<Integer, CoursePoint> map = new HashMap<>();
        // 出的元素
        for (int[] point : prerequisites) {
            int id = point[1];
            if (map.containsKey(id)) {
                CoursePoint coursePoint = map.get(id);
                coursePoint.points.add(point[0]);
            } else {
                CoursePoint course = new CoursePoint();
                course.id = id;
                course.num = 0;
                course.points.add(point[0]);
                map.put(id, course);
            }
        }

        // 更新入度
        for (int[] point : prerequisites) {
            if (map.containsKey(point[0])) {
                CoursePoint coursePoint = map.get(point[0]);
                coursePoint.num += 1;
            } else {
                CoursePoint coursePoint = new CoursePoint();
                coursePoint.id = point[0];
                coursePoint.num = 1;
                map.put(point[0], coursePoint);
            }
        }

        Queue<CoursePoint> queue = new LinkedList<>();
        int[] res = new int[numCourses];
        int idx = 0;
        for (CoursePoint coursePoint : map.values()) {
            if (coursePoint.num == 0) {
                queue.add(coursePoint);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while ((size--) > 0) {
                CoursePoint point = queue.poll();
                res[idx++] = point.id;
                if (point.points.size() < 1) {
                    continue;
                }
                for (int id : point.points) {
                    if (map.containsKey(id)) {
                        CoursePoint course = map.get(id);
                        course.num = course.num - 1;
                        if (course.num == 0) {
                            queue.add(map.get(id));
                        }
                    }
                }
            }
        }
        return res;
    }
}
