package leetcodejava.string;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is the solution of No. 415 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-strings
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class AddString415 {

    @Test
    public void addStringTest() {
        String num1 = "12345";
        String num2 = "12345";
        String num = addStr(num1, num2);
        Assert.assertEquals(num, "24690");
    }

    /**
     * 1.先将字符串变成数字数组
     * 2.找到最大的list和最小的
     * 3.两个链表相加
     *
     * @param num1 字符串1
     * @param num2 字符串2
     * @return 字符串和
     */
    public String addStr(String num1, String num2) {
        if (num1 == null || num1.length() < 1) {
            return num2;
        }
        if (num2 == null || num2.length() < 1) {
            return num1;
        }
        List<Integer> numList1 = Arrays.asList(num1.split(""))
                .stream()
                .map(e -> Integer.valueOf(e))
                .collect(Collectors.toList());
        List<Integer> numList2 = Arrays.asList(num2.split(""))
                .stream()
                .map(e -> Integer.valueOf(e))
                .collect(Collectors.toList());
        List<Integer> maxList = null;
        List<Integer> minList = null;
        if (numList1.size() > numList2.size()) {
            maxList = numList1;
            minList = numList2;
        } else {
            maxList = numList2;
            minList = numList1;
        }
        int maxIndex = maxList.size() - 1;
        int minIndex = minList.size() - 1;
        // 标志位初始值为0
        int flag = 0;
        while (minIndex >= 0) {
            int total = minList.get(minIndex) + maxList.get(maxIndex) + flag;
            if (total > 9) {
                maxList.set(maxIndex, total % 10);
                flag = 1;
            } else {
                maxList.set(maxIndex, total);
                flag = 0;
            }
            maxIndex--;
            minIndex--;
        }
        // 当maxIndex还没到达0位置
        while (maxIndex >= 0) {
            int total = maxList.get(maxIndex) + flag;
            if (total > 9) {
                maxList.set(maxIndex, total % 10);
                flag = 1;
                maxIndex--;
            } else {
                maxList.set(maxIndex, total);
                flag = 0;
                maxIndex--;
            }
        }
        // 如果flag=1，向前进一位
        if (flag == 1) {
            maxList.add(0, 1);
        }
        return maxList.stream().map(e -> String.valueOf(e)).collect(Collectors.joining(""));
    }

    /**
     * 加字符串
     *
     * @param num1 字符串1
     * @param num2 字符串2
     * @return 字符串和
     */
    public String addStr2(String num1, String num2) {
        if (num1 == null || num1.length() < 1) {
            return num2;
        }
        if (num2 == null || num2.length() < 1) {
            return num1;
        }
        StringBuffer sb = new StringBuffer();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int flag = 0;
        while (index1 >= 0 || index2 >= 0) {
            int total = flag;
            if (index1 >= 0) {
                total += num1.charAt(index1--) - '0';
            }
            if (index2 >= 0) {
                total += num2.charAt(index2--) - '0';
            }
            flag = total / 10;
            sb.append(total % 10);
        }
        if (flag > 0) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}
