package leetcodejava.tree;

import org.junit.Test;

import java.util.ArrayList;

/**
 * This is the solution of No. 59 problem in the book <i>Coding Interviews: Questions, Analysis & Solutions</i>,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * The description of problem is as follow:
 * ==========================================================================================================
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数 max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * 限制：
 * - 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * - 1 <= value <= 10^5
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MaxQueue59 {
    private ArrayList<Integer> list;
    private int front;
    private int rear;
    private int max;

    @Test
    public void testMaxQueue59() {
        MaxQueue59 q = new MaxQueue59();
        q.push_back(1);
        q.push_back(2);
        System.out.println(q.max_value()); // 2
        System.out.println(q.pop_front()); // 1
    }

    /**
     * 判断是否为空
     *
     * @return 布尔值
     */
    private boolean isEmpty() {
        if (front == rear) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 初始化实例变量
     */
    public MaxQueue59() {
        list = new ArrayList<>();
        rear = 0;
        front = 0;
        max = 0;
    }

    /**
     * 最大值
     *
     * @return 返回值
     */
    public int max_value() {
        boolean flag = isEmpty();
        if (flag) {
            return -1;
        }
        return max;
    }

    /**
     * 加入后面
     *
     * @param value 后面的值
     */
    public void push_back(int value) {
        list.add(value);
        rear++;
        max = value > max ? value : max;
    }

    /**
     * 弹出前面的元素
     *
     * @return 值
     */
    public int pop_front() {
        if (isEmpty()) {
            return -1;
        }
        if (max == list.get(front)) {
            max = 0;
            for (int i = front + 1; i < rear; i++) {
                max = list.get(i) > max ? list.get(i) : max;
            }
        }
        return list.get(front++);
    }
}
