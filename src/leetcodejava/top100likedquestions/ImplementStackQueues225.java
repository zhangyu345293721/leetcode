package leetcodejava.top100likedquestions;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.225 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/implement-stack-using-queues
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ImplementStackQueues225 {

    private List<Integer> list = null;

    /**
     * 初始化栈
     */
    public ImplementStackQueues225() {
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
