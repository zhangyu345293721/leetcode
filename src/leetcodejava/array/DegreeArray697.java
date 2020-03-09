package leetcodejava.array;

import org.junit.Test;

import java.util.*;


/**
 * 数组的度
 *
 * @author: zhangyu
 */
public class DegreeArray697 {
    @Test
    public void testDegreeArray() {
        int[] arr = {1, 2, 2, 3, 1, 4, 2};
        int length = findShortestSubArray(arr);
        System.out.println(length);
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
