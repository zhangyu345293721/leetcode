package leetcode;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: ThreeSum
 * @Description: 计算三个数相加等于0的情况
 * @date 2018/12/3 17:12
 **/


public class ThreeSum {
    @Test
    public void fun() {
        int[] nums = {-1, 0, 1, 2, -1, -4, 0, 0};
        // int[] nums = {0, 0, 0, 0};
        List<List<Integer>> list = getList(nums);
        System.out.println(list);
    }

    private List<List<Integer>> getList(int[] nums) {
        //  根据链表进行保存所有出现的方式
        int flag = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (((nums[i] + nums[j] + nums[k]) == 0) && i < j && j < k && i < k) {
                        // 分两种情况，一种都是0的情况只保存一个都是0的情况
                        if (flag == 0 && isHaveThreeZero(nums[i], nums[j], nums[k])) {
                            addList(list, nums[i], nums[j], nums[k]);
                            flag = 1;
                        }
                        // 第二种保存链表里面没有出现过的情况
                        if (isExists(list, nums[i], nums[j], nums[k])) {
                            addList(list, nums[i], nums[j], nums[k]);
                        }
                    }
                }
            }
        }
        return list;
    }

    // 判断原来的list是否存在那种可能的形式
    private boolean isExists(List<List<Integer>> list, int num1, int num2, int num3) {
        for (List<Integer> l : list) {
            if (l.contains(num1) && l.contains(num2) && l.contains(num3)) {
                return false;
            }
        }
        return true;
    }

    // 判断nums数组中是否存在三个0的情况
    private boolean isHaveThreeZero(int num1, int num2, int num3) {
        if (num1 == 0 && num2 == 0 && num3 == 0) {
            return true;
        }
        return false;
    }
    // 将listSun链表加入到list当中
    private void addList(List<List<Integer>> list, int num1, int num2, int num3) {
        List<Integer> listSum = new ArrayList<>();
        listSum.add(num1);
        listSum.add(num2);
        listSum.add(num3);
        list.add(listSum);
    }
}
