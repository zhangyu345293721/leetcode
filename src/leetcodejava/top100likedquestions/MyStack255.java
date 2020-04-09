package leetcodejava.top100likedquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计栈
 *
 * @author: zhangyu
 */
class MyStack {

    private List<Integer> list = null;

    /**
     * 初始化栈
     */
    public MyStack() {
        list = new ArrayList<>();
    }

    /**
     * 插入元素入栈
     *
     * @param x 元素
     */
    public void push(int x) {
        list.add(x);
    }

    /**
     * 出栈
     *
     * @return 栈顶元素
     */
    public int pop() {
        if (list != null && list.size() > 0) {
            return list.remove(list.size() - 1);
        } else {
            return -1;
        }
    }

    /**
     * 只弹出栈顶元素
     *
     * @return 栈顶元素
     */
    public int top() {
        if (list != null) {
            return list.get(list.size() - 1);
        } else {
            return -1;
        }
    }

    /**
     * 判断里面元素是否为空
     *
     * @return true或者flase
     */
    public boolean empty() {
        if (list == null || list.size() < 1) {
            return true;
        }
        return false;
    }
}
