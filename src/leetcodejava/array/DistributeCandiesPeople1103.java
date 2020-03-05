package leetcodejava.array;

import org.junit.Test;

/**
 * 给小朋友分糖果
 *
 * @author: zhangyu
 */
public class DistributeCandiesPeople1103 {

    @Test
    public void testDistributeCandiesPeople() {
        int candies = 60;
        int num_people = 4;
        int[] nums = distributeCandies2(candies, num_people);
        System.out.println(nums);
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
