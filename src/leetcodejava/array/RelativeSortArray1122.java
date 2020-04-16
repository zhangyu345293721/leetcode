package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is the solution of No. 1122 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/relative-sort-array
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RelativeSortArray1122 {
    @Test
    public void testRelativeSortArray() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] arr = relativeSortArray(arr1, arr2);
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * 两个数组相对位置排序
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 排序后的位置
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length < 1 || arr2 == null || arr2.length < 1) {
            return new int[0];
        }
        int[] arr = new int[arr1.length];
        int index = 0;
        for (int num2 : arr2) {
            for (int num1 : arr1) {
                if (num1 == num2) {
                    arr[index++] = num2;
                }
            }
        }
        List<Integer> leftList = getDifferenceSet(arr1, arr2);
        // 自然排序
        Collections.sort(leftList);
        for (Integer num : leftList) {
            arr[index++] = num;
        }
        return arr;
    }

    /**
     * 数组取差集的逻辑
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return list
     */
    private List<Integer> getDifferenceSet(int[] arr1, int[] arr2) {
        List<Integer> leftList = new ArrayList<>();
        for (int num1 : arr1) {
            boolean flag = true;
            for (int num2 : arr2) {
                if (num1 == num2) {
                    flag = false;
                }
            }
            if (flag) {
                leftList.add(num1);
            }
        }
        return leftList;
    }
}
