package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: Subsets
 * @Description: TOTO
 * @date 2018/12/7 11:36
 **/

// 找出一个数组中所有的子串
public class Subsets3 {
    @Test
    public void fun() {
        int[] nums = {1, 2};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        // 数组长度为0就直接返回
        if (nums == null || nums.length == 0) {
            return ret;
        }
        // 定义另外一个辅助数组
        int[] pos = new int[nums.length];
        int index = 0; //标志位index
        pos[0] = -1; //第一个位置为-1
        // 控制进行回溯
        while (index >= 0) {
            pos[index]++;
            if (pos[index] < nums.length) {
                List<Integer> s = new ArrayList<Integer>();
                for (int ii = 0; ii <= index; ii++) {
                    s.add(nums[pos[ii]]);
                }
                ret.add(s);
                if (index < nums.length - 1) {
                    index++;
                    pos[index] = pos[index - 1];
                }
                continue;
            }
            index--;
        }
        ret.add(new ArrayList<Integer>());
        return ret;
    }
}