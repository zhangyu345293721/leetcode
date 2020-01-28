package leetcodejava.array;

import org.junit.Test;

/**
 * 加数字
 *
 * @author: zhangyu
 */
public class AddDigits258 {

    @Test
    public void testAddDigits() {
        int num = 38;
        int result = addDigits2(num);
        System.out.println(result);
    }

    /**
     * 计算一个数到个位
     *
     * @param num 数num
     * @return 各位数的和
     */
    public int addDigits(int num) {
        int total = 0;
        while (num > 0) {
            int leftNumber = num % 10;
            total += leftNumber;
            num = num / 10;
        }
        if (total < 10) {
            return total;
        } else {
            return addDigits(total);
        }
    }

    /**
     * 计算一个数到个位
     *
     * @param num 数num
     * @return 各位数的和
     */
    public int addDigits2(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}
