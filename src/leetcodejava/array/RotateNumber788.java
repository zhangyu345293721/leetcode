package leetcodejava.array;

import org.junit.Test;

/**
 * 按照要求旋转数字
 *
 * @author: zhangyu
 */
public class RotateNumber788 {
    @Test
    public void testRotateNumber() {
        int n = 10;
        int number = rotatedDigits(n);
        System.out.println(number);
    }

    /**
     * 旋转数字
     *
     * @param N 数字
     * @return 数量
     */
    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 0; i <= N; i++) {
            String strN = String.valueOf(i);
            if ((strN.contains("2") || strN.contains("5") || strN.contains("6") || strN.contains("9")) && (!strN.contains("3") && !strN.contains("4") && !strN.contains("7"))) {
                count++;
            }
        }
        return count;
    }
}
