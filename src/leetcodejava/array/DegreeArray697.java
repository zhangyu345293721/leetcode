package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


/**
 * This is the solution of No. 697 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/degree-of-an-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 * <p>
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 * <p>
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class DegreeArray697 {
    @Test
    public void degreeArrayTest() {
        int[] arr = {1, 2, 2, 3, 1, 4, 2};
        int result = findShortestSubArray(arr);
        Assert.assertEquals(result, 6);
    }

    /**
     * 找出子数组长度
     *
     * @param nums 数组
     * @return 子数组长度
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> countMap = getCountMap(nums);
        int times = getMaxAppear(countMap);
        List<Integer> figureList = getFigureAppearMaxTime(countMap, times);
        int num = getShortestLength(figureList, nums);
        return num;
    }

    /**
     * 获取距离最小数
     *
     * @param figureList 数字链表
     * @param nums       数组
     * @return 长度
     */
    private int getShortestLength(List<Integer> figureList, int[] nums) {
        List<Integer> lengthList = new ArrayList<>();
        for (int figure : figureList) {
            int i = 0;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] != figure) {
                    i++;
                } else if (nums[j] != figure) {
                    j--;
                } else {
                    break;
                }
            }
            lengthList.add(j - i + 1);
        }
        return Collections.min(lengthList);
    }

    /**
     * 获取最大次数数字
     *
     * @param countMap 数字出现次数map
     * @param times    次数
     * @return 链表
     */
    private List<Integer> getFigureAppearMaxTime(Map<Integer, Integer> countMap, int times) {
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> ele : countMap.entrySet()) {
            if (ele.getValue() == times) {
                list.add(ele.getKey());
            }
        }
        return list;
    }

    /**
     * 获取出现次数
     *
     * @param countMap 次数map
     * @return 次数
     */
    private int getMaxAppear(Map<Integer, Integer> countMap) {
        int max = Integer.MIN_VALUE;
        for (int num : countMap.values()) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * 统计数字出现次数
     *
     * @param nums 数组
     * @return map
     */
    private Map<Integer, Integer> getCountMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }
}
