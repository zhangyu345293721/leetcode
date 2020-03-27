package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 914 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一副牌，每张牌上都写着一个整数。
 * <p>
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * <p>
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 3：
 * <p>
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例 4：
 * <p>
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class XKindDeckCards914 {
    @Test
    public void testXKindDeckCards() {
        int arr[] = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
        boolean b = hasGroupsSizeX3(arr);
        System.out.println(b);
    }

    /**
     * 是否能分成多组
     *
     * @param deck 数组数量
     * @return 布尔值
     */
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.size() < 2) {
            return true;
        }
        int x = -1;
        for (int num : map.values()) {
            if (num > 0) {
                x = x == -1 ? num : gcd(x, num);
                if (x == 1) {
                    return false;
                }
            }
        }
        return x >= 2;
    }

    /**
     * 是否能分成多组
     *
     * @param deck 数组数量
     * @return 布尔值
     */
    public boolean hasGroupsSizeX2(int[] deck) {
        int[] counter = new int[10000];
        for (int num : deck) {
            counter[num]++;
        }
        return Arrays.stream(counter).filter(e -> e > 0).reduce(0,this::gcd) >= 2;
    }

    /**
     * 是否能分成多组
     *
     * @param deck 数组数量
     * @return 布尔值
     */
    public boolean hasGroupsSizeX3(int[] deck) {
        int[] counter = new int[10000];
        for (int num : deck) {
            counter[num]++;
        }
        int x = 0; //任何数和0的最大公约数是本身, 所以就不用每次判断i == -1了
        for (int cnt : counter) {
            if (cnt > 0) {
                x = gcd(x, cnt);
                if (x == 1) { // 这个提前结束不错,
                    return false;
                }
            }
        }
        return x >= 2;
    }

    /**
     * 获取两个数的最大公约数
     *
     * @param a 数字a
     * @param b 数字b
     * @return g公约数
     */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

