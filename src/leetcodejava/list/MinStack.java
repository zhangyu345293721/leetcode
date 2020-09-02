package leetcodejava.list;

/**
 * 定义一个最小栈
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MinStack {
    /**
     * 定义一个节点
     */
    private Node stack = null;

    public MinStack() {
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
