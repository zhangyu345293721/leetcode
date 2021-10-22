package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No. 1089 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/duplicate-zeros
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *  
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class DuplicateZeros1089 {

    @Test
    public void duplicateZerosTest() {
        int[] result = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(result);
        System.out.println(Arrays.toString(result));
    }


    /**
     * 重复0操作
     *
     * @param arr 数组
     */
    public void duplicateZeros(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num == 0) {
                list.add(0);
            }
            list.add(num);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        System.out.println(list);
    }
}
