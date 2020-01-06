package leetcode.array.arrangementselect;


import org.junit.Test;

/**
 * 转换数字（将10进制整数转成n进制）n>=2 n<=16
 *
 * @author: zhangyu
 */
public class InvertNumber {
    @Test
    public void invertNumberFun() {
        int number = 36;
        int n = 9;
        StringBuilder sb = new StringBuilder();
        getConvertNumber(number, n, sb);
        System.out.println("figure = " + sb.toString());
    }

    /**
     * @param number 要转换的数字
     * @param n      转换的进制
     * @param sb     存储转换的字符串
     */
    private void getConvertNumber(int number, int n, StringBuilder sb) {
        int leftNumber = 0;
        int totalNumber = number;
        int count = 0;
        if (number < n) {
            sb.append(number);
            return;
        }
        while (number >= n) {
            number = number / n;
            count++;
        }
        for (int i = n - 1; i >= 0; i--) {
            leftNumber = totalNumber - (int) Math.pow(n, count) * i;
            if (leftNumber > 0) {
                sb.append(i);
                int tempCount = count - 1;
                while (tempCount > 0) {
                    if ((int) Math.pow(n, tempCount) > leftNumber) {
                        sb.append(0);
                    }
                    tempCount--;
                }
                break;
            } else if (leftNumber == 0) {
                sb.append(i);
                while (count > 0) {
                    sb.append(0);
                    count--;
                }
                return;
            }
        }
        getConvertNumber(leftNumber, n, sb);
    }


    @Test
    public void invertFun2() {
        int num = 7;
        int n = 3;
        String s = Integer.toString(num, n);
        System.out.println(s);
    }
}
