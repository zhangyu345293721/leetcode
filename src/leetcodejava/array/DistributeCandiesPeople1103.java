package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 1103 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/distribute-candies-to-people
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 排排坐，分糖果。
 * <p>
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：candies = 7, num_people = 4
 * 输出：[1,2,3,1]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3,0]。
 * 第四次，ans[3] += 1（因为此时只剩下 1 颗糖果），最终数组变为 [1,2,3,1]。
 * 示例 2：
 * <p>
 * 输入：candies = 10, num_people = 3
 * 输出：[5,2,3]
 * 解释：
 * 第一次，ans[0] += 1，数组变为 [1,0,0]。
 * 第二次，ans[1] += 2，数组变为 [1,2,0]。
 * 第三次，ans[2] += 3，数组变为 [1,2,3]。
 * 第四次，ans[0] += 4，最终数组变为 [5,2,3]。
 * <p>
 * 提示：
 * <p>
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class DistributeCandiesPeople1103 {

    @Test
    public void distributeCandiesPeopleTest() {
        int candies = 60;
        int num_people = 4;
        int[] result = distributeCandies2(candies, num_people);
        Assert.assertEquals(result.length, 4);
    }

    /**
     * 给小朋友分糖果
     *
     * @param candies    糖果数
     * @param num_people 人数
     * @return 糖果数组
     */
    public int[] distributeCandies(int candies, int num_people) {
        int nums[] = new int[num_people];
        int count = 1;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies < count) {
                    nums[i] += candies;
                    candies = 0;
                    break;
                } else {
                    nums[i] += count;
                }
                candies -= count;
                count++;
            }
        }
        return nums;
    }

    /**
     * 给小朋友分糖果
     *
     * @param candies    糖果数
     * @param num_people 人数
     * @return 糖果数组
     */
    public int[] distributeCandies2(int candies, int num_people) {
        int result[] = new int[num_people];
        int i = 0;
        while (candies > 0) {
            result[i % num_people] += Math.min(candies, ++i);
            candies -= i;
        }
        return result;
    }
}
