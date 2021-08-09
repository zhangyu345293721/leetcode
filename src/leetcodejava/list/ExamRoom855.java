package leetcodejava.list;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This is the solution of No. 855 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/exam-room
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 * <p>
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 * <p>
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 * <p>
 * 示例：
 * <p>
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exam-room
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ExamRoom855 {

    public static void main(String[] args) {
        ExamRoom855 examRoom = new ExamRoom855(1000000);
        System.out.println(examRoom.seat());
        examRoom.leave(0);
        System.out.println(examRoom.seat());
        examRoom.leave(0);

    }

    /**
     * seatPriority中的数组元素1代表每个位置，数组元素2代表该位置与最近非空元素的最大距离
     */
    private PriorityQueue<int[]> seatPriority = new PriorityQueue<>((e1, e2) ->
            e2[1] == e1[1] ? e1[0] - e2[0] : e2[1] - e1[1]
    );
    private boolean blank = true;
    /**
     * sttudentList里面的元素，如果值等于0，就代表位置空着
     * 如果值等于1，就代表位置已经被占用
     */
    private List<Integer> studentList = new ArrayList<>();

    public ExamRoom855(int N) {
        for (int i = 0; i < N; i++) {
            studentList.add(0);
        }
    }

    /**
     * 座位的位置
     *
     * @return
     */
    public int seat() {
        if (blank) {
            // 第一个位置被占领
            studentList.set(0, 1);
            blank = false;
            return 0;
        } else {
            // 计算最大距离的最小元素
            computeMaxDistance();
            int[] ele = seatPriority.poll();
            int index = ele[0];
            studentList.set(index, 1);
            blank = false;
            return index;
        }
    }

    /**
     * 计算每个元素到达最近非空的最大距离
     */
    private void computeMaxDistance() {
        seatPriority.clear();
        for (int i = 0; i < studentList.size(); i++) {
            Integer flag = studentList.get(i);
            if (flag == 0) {
                int left = i - 1;
                int right = i + 1;
                int distance = 0;
                boolean leftFlag = false;
                boolean rightFlag = false;
                while (left >= 0) {
                    if (studentList.get(left) == 1) {
                        leftFlag = true;
                        break;
                    } else {
                        left--;
                    }
                }
                while (right < studentList.size()) {
                    if (studentList.get(right) == 1) {
                        rightFlag = true;
                        break;
                    } else {
                        right++;
                    }
                }
                // 都找到1，取最小
                if (leftFlag && rightFlag) {
                    distance = Math.min(i - left, right - i);
                } else if (leftFlag) {
                    distance = i - left;
                } else if (rightFlag) {
                    distance = right - i;
                }
                seatPriority.add(new int[]{i, distance});
            }
        }
    }

    /**
     * 删除某个元素
     *
     * @param p 删除元素
     */
    public void leave(int p) {
        if (p <= studentList.size()) {
            studentList.set(p, 0);
        }
        long count = studentList.stream().filter(e -> e.intValue() == 1).count();
        if (count == 0) {
            blank = true;
        }
    }
}
