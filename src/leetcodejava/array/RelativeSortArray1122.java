package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is the solution of No. 1122 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/relative-sort-array
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RelativeSortArray1122 {
    @Test
    public void relativeSortArrayTest() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] result = relativeSortArray2(arr1, arr2);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
        Assert.assertEquals(result[0], 2);
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

    /**
     * 两个数组相对位置排序
     *  1) 先取出arr1中最大数
     *  2）然后将数映射到桶中
     *
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 排序后的位置
     */
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length < 1 || arr2 == null || arr2.length < 1) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        for (int num : arr1) {
            max = Math.max(num, max);
        }
        int res[] = new int[arr1.length];
        int index = 0;
        int arr[] = new int[max + 1];
        for (int num : arr1) {
            arr[num]++;
        }
        for (int num2 : arr2) {
            int count = arr[num2];
            while (count > 0) {
                res[index++] = num2;
                count--;
            }
            arr[num2] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            int count = arr[i];
            while (count > 0) {
                res[index++] = i;
                count--;
            }
            arr[i] = 0;
        }
        return res;
    }
}
