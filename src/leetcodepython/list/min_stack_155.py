# encoding='utf-8'

'''
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
'''
import sys


class MinStack:
    stack = []
    min_num = sys.maxsize

    def push(self, x: int) -> None:
        '''
            元素压入栈汇总
        Args:
            x: 元素
        Returns:
            None
        '''
        self.stack.append(x)
        if x < self.min_num:
            self.min_num = x

    def pop(self) -> None:
        '''
            弹出一个元素
        Returns:
            None
        '''
        self.min_num = sys.maxsize
        self.stack.pop()
        for num in self.stack:
            if num < self.min_num:
                self.min_num = num

    def top(self) -> int:
        '''
            弹出栈顶元素
        Returns:
            栈顶元素
        '''
        return self.stack[-1]

    def get_min(self) -> int:
        '''
            获取一个最小值
        Returns:
            最小值
        '''
        return self.min_num


class MinStack2:
    stack = []

    def push(self, x: int) -> None:
        '''
            元素压入栈汇总
        Args:
            x: 元素
        Returns:
            None
        '''
        self.stack.append(x)

    def pop(self) -> None:
        '''
            弹出一个元素
        Returns:
            None
        '''
        self.stack.pop()

    def top(self) -> int:
        '''
            弹出栈顶元素
        Returns:
            栈顶元素
        '''
        return self.stack[-1]

    def get_min(self) -> int:
        '''
            获取一个最小值
        Returns:
            最小值
        '''
        return min(self.stack)


class MinStack3:
    min_num = sys.maxsize
    head = None

    class Node:
        val = None
        next_node = None

        def __init__(self, val: int):
            self.val = val

    def push(self, x: int) -> None:
        '''
            元素压入栈中
        Args:
            x: 元素
        Returns:
            None
        '''
        if not self.head:
            self.head = self.Node(x)
        else:
            n = self.Node(x)
            n.next_node = self.head
            self.head = n
        if x < self.min_num:
            self.min_num = x

    def pop(self) -> None:
        '''
            弹出一个元素
        Returns:
            None
        '''
        if not self.head:
            self.head = self.head.next_node
            self.min_num = sys.maxsize
            cur = self.head
            while cur:
                if cur.val<self.min_num:
                    self.min_num=cur.val
                cur=cur.next_node

    def top(self) -> int:
        '''
            弹出栈顶元素
        Returns:
            栈顶元素
        '''
        return self.stack[-1]

    def get_min(self) -> int:
        '''
            获取一个最小值
        Returns:
            最小值
        '''
        return self.min_num


if __name__ == '__main__':
    min_stack = MinStack3()
    min_stack.push(-2)
    min_stack.push(0)
    min_stack.push(-3)
    print(min_stack.get_min())
