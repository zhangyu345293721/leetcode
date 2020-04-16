package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No. 728 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/self-dividing-numbers
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 *
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SelfDivingNumber728 {

    @Test
    public void testSelfDivingNumber() {
        int left = 1;
        int right = 22;
        List<Integer> list=selfDividingNumbers(left, right);
        System.out.println(list);
    }

    /**
     * 找出自除数
     *
     * @param left  左边输入
     * @param right 右边输入
     * @return list链表
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean flag = judgeSelfDiving(i);
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 判断一个数字是不是自除数
     *
     * @param i 输入数
     * @return 布尔值
     */
    private boolean judgeSelfDiving(int i) {
        boolean flag = true;
        int temp = i;
        while (i > 0) {
            int num = i % 10;
            i = i / 10;
            if (num == 0 || temp % num != 0) {
                flag = false;
            }
        }
        return flag;
    }
}
