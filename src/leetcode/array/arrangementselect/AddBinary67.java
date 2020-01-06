package leetcode.array.arrangementselect;


import org.junit.Test;

/**
 * 加一个数
 *
 * @author: zhangyu
 */
public class AddBinary67 {
    @Test
    public void addBinaryTest() {
        String a = "1010";
        String b = "1011";
        String sum = addBinary3(a, b);
        System.out.println(sum);
    }

    /**
     * 字符串相加(先将字符串转成十进制，再十进制相加减)
     *
     * @param a 字符串1
     * @param b 字符串2
     * @return 相加字符串
     */
    private String addBinary(String a, String b) {
        if (a == null || a.length() < 1) {
            return b;
        }
        if (b == null || b.length() < 1) {
            return a;
        }
        Integer integerA = Integer.valueOf(a, 2);
        Integer integerB = Integer.valueOf(b, 2);
        return Integer.toBinaryString(integerA + integerB);
    }

    /**
     * 字符串相加(直接位运算)
     *
     * @param a 字符串1
     * @param b 字符串2
     * @return 相加字符串
     */
    private String addBinary2(String a, String b) {
        if (a == null || a.length() < 1) {
            return b;
        }
        if (b == null || b.length() < 1) {
            return a;
        }
        String shortStr = null;
        String longStr = null;
        if (a.length() > b.length()) {
            shortStr = b;
            longStr = a;
        } else {
            shortStr = a;
            longStr = b;
        }
        int i = shortStr.length() - 1;
        int j = longStr.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int tempA = 0;
            if (i >= 0) {
                tempA = shortStr.charAt(i) - '0';
            }
            int tempB = longStr.charAt(j) - '0';
            carry += tempA + tempB;
            sb.append(carry % 2);
            i--;
            j--;
            carry = carry / 2;
        }
        if (carry > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }


    /**
     * 字符串相加(直接位运算)
     *
     * @param a 字符串1
     * @param b 字符串2
     * @return 相加字符串
     */
    private String addBinary3(String a, String b) {
        if (a == null || a.length() < 1) {
            return b;
        }
        if (b == null || b.length() < 1) {
            return a;
        }
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int tempA = 0;
            int tempB = 0;
            if (i >= 0) {
                tempA = a.charAt(i) - '0';
            }
            if (j >= 0) {
                tempB = b.charAt(j) - '0';
            }
            carry += tempA + tempB;
            sb.append(carry % 2);
            i--;
            j--;
            carry = carry / 2;
        }
        if (carry > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }


    @Test
    public void charTestDemo() {
        String a = "1100";
        Integer integer = Integer.valueOf(a, 2);
        System.out.println(integer);
    }
}
