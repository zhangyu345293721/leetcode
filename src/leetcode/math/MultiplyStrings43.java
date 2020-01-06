package leetcode.math;


import org.junit.Test;

import java.math.BigInteger;

/**
 * 字符串乘
 *
 * @author: zhangyu
 */
public class MultiplyStrings43 {

    @Test
    public void multiplyString() {
        String num1 = "101";
        String num2 = "11";
        String result = multiply2(num1, num2);
        System.out.println(result);
    }

    /**
     * @param num1 数字1
     * @param num2 数字2
     * @return 返回字符串
     */
    public String multiply(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger total = a.multiply(b);
        return total.toString();
    }

    /**
     * @param num1 数字1
     * @param num2 数字2
     * @return 返回字符串
     */
    public String multiply2(String num1, String num2) {
        if (num1 == null || num1.length() < 1) {
            return "0";
        }
        if (num2 == null || num1.length() < 1) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) {
            return "0";
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int[] result = new int[len1 + len2];
        int carry = 0;
        int pointer = result.length - 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int start = pointer;
            carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int res = n1 * n2 + result[start] + carry;
                carry = res / 10;
                res %= 10;
                // 存储数组
                result[start] = res;
                start--;
            }
            if (carry > 0) {
                result[start] = carry;
            }
            pointer--;
        }
        // 最后一个
        if (carry > 0) {
            result[0] = carry;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[0] == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }

    /**
     * @param num1 数字1
     * @param num2 数字2
     * @return 返回字符串
     */
    public String multiply3(String num1, String num2) {
        if (num1 == null || num1.length() < 1) {
            return "0";
        }
        if (num2 == null || num1.length() < 1) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) {
            return "0";
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int[] result = new int[len1 + len2];
        int carry = 0;
        int pointer = result.length - 1;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int start = pointer;
            carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int res = n1 * n2 + result[start] + carry;
                carry = res / 10;
                res %= 10;
                result[start] = res;
                start--;
            }
            if (carry > 0) {
                result[start] = carry;
            }
            pointer--;
        }
        // 最后一个
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
