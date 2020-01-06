package leetcode.select;

import org.junit.Test;

import java.util.*;

/**
 * 计算三个数相加等于0的情况
 *
 * @author zhangyu
 **/


public class ThreeSum {
    @Test
    public void testThreeSum() {
        int[] nums = {-1, 0, 1, 2, -1, -4, 0, 0};
        List<List<Integer>> list = getList(nums);
        System.out.println(list);
    }

    /**
     * 三个值相加
     *
     * @param nums 数组
     * @return 返回list
     */
    private List<List<Integer>> getList(int[] nums) {
        int flag = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (((nums[i] + nums[j] + nums[k]) == 0) && i < j && j < k && i < k) {
                        if (flag == 0 && isHaveThreeZero(nums[i], nums[j], nums[k])) {
                            addList(list, nums[i], nums[j], nums[k]);
                            flag = 1;
                        }
                        if (isExists(list, nums[i], nums[j], nums[k])) {
                            addList(list, nums[i], nums[j], nums[k]);
                        }
                    }
                }
            }
        }
        return list;
    }

    private boolean isExists(List<List<Integer>> list, int num1, int num2, int num3) {
        for (List<Integer> l : list) {
            if (l.contains(num1) && l.contains(num2) && l.contains(num3)) {
                return false;
            }
        }
        return true;
    }

    private boolean isHaveThreeZero(int num1, int num2, int num3) {
        if (num1 == 0 && num2 == 0 && num3 == 0) {
            return true;
        }
        return false;
    }

    private void addList(List<List<Integer>> list, int num1, int num2, int num3) {
        List<Integer> listSum = new ArrayList<>();
        listSum.add(num1);
        listSum.add(num2);
        listSum.add(num3);
        list.add(listSum);
    }

    /**
     * 三个值相加
     *
     * @param nums 数组
     * @return 返回list
     */
    private List<List<Integer>> getList2(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
