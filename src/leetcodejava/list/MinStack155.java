package leetcodejava.list;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * This is the solution of No. 155 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/min-stack/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MinStack155 {

    @Test
    public void minStackTest() {
        MinStack155 minStack = new MinStack155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }

    private Deque<Integer> stack = null;

    public MinStack155() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack.stream().mapToInt(e -> e.intValue()).min().getAsInt();
    }
}

class MinStack155_1 {
    /**
     * 定义一个节点
     */
    private Node stack = null;

    public MinStack155_1() {
    }

    public void push(int x) {
        if (stack == null) {
            stack = new Node(x, x);
        } else {
            stack = new Node(x, Math.min(x, stack.min), stack);
        }
    }

    // 弹出一个元素
    public void pop() {
        stack = stack.next;
    }

    public int top() {
        return stack.val;
    }

    public int getMin() {
        return stack.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

        public Node(int val, int min) {
            this.val = val;
            this.next = null;
            this.min = min;
        }
    }
}

class MinStack155_2 {

    private Deque<Node> stack = null;

    public MinStack155_2() {
        stack = new ArrayDeque<>();
    }

    // 入栈操作
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Node(x, x));
        } else {
            stack.push(new Node(x, Math.min(x, stack.peek().min)));
        }
    }

    public void pop() {
        stack.pop();
    }

    // 取最小顶上一个元素
    public int top() {
        return stack.peek().val;
    }

    // 获取最小值
    public int getMin() {
        return stack.peek().min;
    }

    // 定义内部类
    private class Node {
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}


class MinStack155_3 {
    private Stack<Integer> stack = null;
    private Stack<Integer> minStack = null;

    public MinStack155_3() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    /**
     * 压入元素到栈中
     *
     * @param x 元素
     */
    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    /**
     * 弹出元素
     */
    public void pop() {
        stack.pop();
        minStack.pop();
    }

    /**
     * 获取最上面元素
     *
     * @return 值
     */
    public int top() {
        return stack.peek();
    }

    /**
     * 获取最小值
     *
     * @return 最小值
     */
    public int getMin() {
        return minStack.peek();
    }

}

