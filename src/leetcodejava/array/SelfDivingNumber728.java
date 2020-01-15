package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断自除数
 *
 * @author: zhangyu
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
