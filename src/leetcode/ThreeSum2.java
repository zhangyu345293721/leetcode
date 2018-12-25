package leetcode;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 换一种方法进行计算每种出现的可能,然后进行逐步清除
 * 第二种方式
 *
 * @author zhangyu
 * @version V1.0
 * @ClassName: ThreeSum
 * @Description: TOTO
 * @date 2018/12/3 17:12
 **/


public class ThreeSum2 {
    @Test
    public void fun() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = getList(nums);
        System.out.println(list);
    }

    private List<List<Integer>> getList(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : nums) {
            map.put(num, index);
            index++;
        }
        List<List<Integer>> list = new ArrayList<>();
        int flag=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int number = -nums[i] - nums[j];
                if (map.keySet().contains(number) && map.get(number)>j ) {
                    // 分两种情况，一种都是0的情况只保存一个都是0的情况
                    if (flag == 0 && isHaveThreeZero(nums[i], nums[j], number)) {
                        addList(list, nums[i], nums[j], number);
                        flag = 1;
                    }
                    // 第二种保存链表里面没有出现过的情况
                    if (isExists(list, nums[i], nums[j], number)) {
                        addList(list, nums[i], nums[j], number);
                    }
                }
            }
        }
        return list;
    }

    // 统计数字出现的个数
    private Map<Integer,Integer> getIntegerAppearTimes(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(!map.keySet().contains(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        return map;
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
