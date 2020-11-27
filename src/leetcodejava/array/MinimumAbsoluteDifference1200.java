package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is the solution of No. 1200 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/minimum-absolute-difference
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class MinimumAbsoluteDifference1200 {
    @Test
    public void minimumAbsoluteDifferenceTest() {
        int[] arr = {4, 2, 1, 3};
        List<List<Integer>> list = minimumAbsDifference(arr);
        System.out.println(list);
    }

    /**
     * 找出绝对值差最小的组（leetcode上超时，）
     *
     * @param arr 数组
     * @return 镶嵌链表
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int gap = Math.abs(arr[j] - arr[i]);
                if (gap < min) {
                    min = gap;
                }
            }
        }
        List<List<Integer>> pairList = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int gap = Math.abs(arr[j] - arr[i]);
                if (gap == min) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[j]);
                    list.add(arr[i]);
                    Collections.sort(list);
                    pairList.add(list);
                }
            }
        }
        return pairList;
    }

    /**
     * 找出绝对值差最小的组
     *
     * @param arr 数组
     * @return 镶嵌链表
     */
    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, Math.abs(arr[i + 1] - arr[i]));
        }
        List<List<Integer>> pairList = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int gap = Math.abs(arr[i + 1] - arr[i]);
            if (gap == min) {
                List<Integer> list = new ArrayList<>(Arrays.asList(arr[i], arr[i + 1]));
                pairList.add(list);
            }
        }
        return pairList;
    }
}
